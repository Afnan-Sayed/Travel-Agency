package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue.QueueManager;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.springframework.stereotype.Component;


public class QueueChecker {
    QueueManager queueManager;
    protected QueueChecker() {
        queueManager = QueueManager.getInstance();
    }
    public int countOfNotificationsInQueue()
    {
        return queueManager.countOfNotificationsInQueue();
    }
    public int countOfEmailNotificationsInQueue()
    {
        return queueManager.countOfEmailNotificationsInQueue();
    }
    public int countOfSmsNotificationsInQueue()
    {
        return queueManager.countOfSmsNotificationsInQueue();
    }

}
