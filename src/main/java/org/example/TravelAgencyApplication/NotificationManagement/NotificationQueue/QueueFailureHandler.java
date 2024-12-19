package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;

public class QueueFailureHandler {
    QueueManager manager;
    QueueFailureHandler()
    {
        manager = QueueManager.getInstance();
    }
    public void handle(Notification notification)
    {
        if(notification.status < 10)
        {
            notification.status++;
            manager.sendNotification(notification);
        }
    }
}
