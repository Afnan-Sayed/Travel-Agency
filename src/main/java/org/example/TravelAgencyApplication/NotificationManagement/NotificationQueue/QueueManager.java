package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;


import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.springframework.beans.factory.DisposableBean;

import java.util.ArrayList;
import java.util.UUID;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager implements DisposableBean {
    private Thread processingThread;
    private volatile boolean running = true;

    Queue<Notification> Notifications;

    private MessageSender sender;
    private static QueueManager manager;

    private QueueManager()
    {
        sender =  new MessageSender();
        Notifications = new LinkedList<>();
        processingThread = new Thread(this::processMessagesContinuously);
        processingThread.start();

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
        synchronized (Notifications) {
            Notifications.add(notification);
            Notifications.notify();
        }
    }
    protected void sendNotification(Notification notification)
    {
        synchronized (Notifications) {
            Notifications.add(notification);
            Notifications.notify(); // Notify the processing thread about new data
        }
    }
    public static String generateID() {
            return UUID.randomUUID().toString();
        }

    public synchronized int countOfNotificationsInQueue()
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
    private void processMessagesContinuously() {
        while (running) {
            Notification notification;
            synchronized (Notifications) {
                while (Notifications.isEmpty()) {
                    try {
                        Notifications.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return; // Exit the loop and terminate the thread
                    }
                }
                notification = Notifications.poll();
            }

            if (notification != null) {
                Notification resultNotification = sender.sendMessage(notification);
                if (resultNotification != null) {
                    if (resultNotification.notificationID == null) {
                        notification.notificationID = generateID();
                        sendNotification(notification); // Re-add to queue in case of repeated ID
                    } else {
                        handleError(resultNotification);
                    }
                }
            }
        }
    }
    @Override
    public void destroy() {
        stopProcessing();
    }
    public void stopProcessing() {
        running = false; // Signal the thread to stop
        synchronized (Notifications) {
            Notifications.notify(); // Wake up the thread
        }
        try {
            processingThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
