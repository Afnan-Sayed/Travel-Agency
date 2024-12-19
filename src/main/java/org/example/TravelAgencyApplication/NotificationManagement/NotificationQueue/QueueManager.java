package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;


import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import java.util.UUID;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {

    Queue<Notification> Notifications;

    private MessageSender sender;
    private static QueueManager manager;
    private QueueManager()
    {
        sender =  new MessageSender(new QueueFailureHandler());
        Notifications = new LinkedList<>();

    }
    public static synchronized QueueManager getInstance() {
        if (manager == null) {
            manager = new QueueManager();
        }
        return manager;
    }
    public void sendNotification(String Message, int userID, String receiver, int notificationReceiverType, int templateID)
    {
        // receiver type 1 = email only, 2 = phone only
        boolean email = (notificationReceiverType == 1), phone = (notificationReceiverType == 2) ;
        Notification notification = new Notification();
        notification.notificationID = generateID();
        notification.templateID = templateID;
        notification.mail = email?receiver:null;
        notification.phoneNumber = phone?receiver:null;
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
            if(!(resultNotification == null)) {
                notification.notificationID = generateID();
                Notifications.add(notification);
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
}
