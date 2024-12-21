package org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;

import java.util.ArrayList;

public class ContentProvider {
    private NotificationProvider notificationProvider;


    protected ContentProvider(NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }
    public ArrayList<Notification> getFilteredNotifications(boolean successfulFlag, boolean failedFlag, boolean readFlag, boolean unreadFlag, Integer userId, Integer templateId, String email, String notificationID)
    {
        return notificationProvider.getFilteredNotifications(successfulFlag,failedFlag,readFlag,unreadFlag,userId,templateId,email, notificationID);
    }
    public void addNotification(Notification notification) {
        notificationProvider.addNotification(notification);
    }

    public boolean deleteNotification(String notificationID) {
        return notificationProvider.deleteNotification(notificationID);
    }
    public void markAsRead(String notificationID, boolean readStatus)
    {
        notificationProvider.markAsRead(notificationID,readStatus);
    }

}
