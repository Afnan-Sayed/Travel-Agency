package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;


import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;

import java.util.ArrayList;
import java.util.UUID;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {

    Queue<Notification> Notifications;

    private MessageSender sender;
    private static QueueManager manager;
    private QueueManager()
    {
        sender =  new MessageSender();
        Notifications = new LinkedList<>();

    }
    public static synchronized QueueManager getInstance() {
        if (manager == null) {
            manager = new QueueManager();
        }
        return manager;
    }
    public void sendNotification(String Message, int userID, ArrayList<String> receiver, int notificationReceiverType, int templateID)
    {
        // receiver type 1 = email only, 2 = phone only, 3 = both
        Notification notification = new Notification();
        notification.notificationID = generateID();
        notification.templateID = templateID;
        notification.mail = receiver.get(0);
        notification.phoneNumber = receiver.get(1);
        notification.read = false;
        notification.message = Message;
        notification.receiverID = userID;
        notification.status = 0;
        Notifications.add(notification);
    }
    protected void sendNotification(Notification notification)
    {
        Notifications.add(notification);
    }
    public static String generateID() {
            return UUID.randomUUID().toString();
        }

    public synchronized void processMessages()
    {
        while (!Notifications.isEmpty()) {
            Notification notification = Notifications.poll();
            Notification resultNotification = sender.sendMessage(notification);
            if (!(resultNotification == null)) {
                if(resultNotification.notificationID == null) {
                    notification.notificationID = generateID();
                    Notifications.add(notification);
                }
                else handleError(resultNotification);
            }
        }
    }

    public int countOfNotificationsInQueue()
    {
        return Notifications.size();
    }
    public int countOfEmailNotificationsInQueue()
    {
        int emails = 0;
        for (Notification n:Notifications)
            if(n.mail != null)
                emails++;
        return emails;
    }
    public int countOfSmsNotificationsInQueue()
    {
        int SMS = 0;
        for (Notification n:Notifications)
            if(n.phoneNumber != null)
                SMS++;
        return SMS;
    }
    public void handleError(Notification notification)
    {
        if(notification.status < 10)
        {
            notification.status++;
            manager.sendNotification(notification);
        }
    }
}
