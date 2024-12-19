package org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;

import java.util.ArrayList;

public class ContentProvider {
    private NotificationProvider notificationProvider;


    protected ContentProvider(NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }


    public ArrayList<Notification> getNotificationsByUserID(int userID) {
        return notificationProvider.getNotificationOfUserByID(userID);
    }

    public ArrayList<Notification> getNotificationsByEmail(String email) {
        return notificationProvider.getNotificationByEmail(email);
    }

    public ArrayList<Notification> getNotificationsByTemplateID(int templateID) {
        return notificationProvider.getNotificationByTemplateID(templateID);
    }

    public ArrayList<Notification> getAllNotifications() {
        return notificationProvider.getAllNotifications();
    }

    public ArrayList<Notification> getAllSuccessfulNotifications() {
        return notificationProvider.getSuccessfulNotifications();
    }

    public ArrayList<Notification> getAllFailedNotifications() {
        return notificationProvider.getFailedNotifications();
    }

    public ArrayList<Notification> getNotificationByNotificationID(String ID){return notificationProvider.getNotificationByNotificationID(ID);}
    public ArrayList<Notification> getAllReadNotifications() {
        return notificationProvider.getReadNotifications();
    }

    public ArrayList<Notification> getAllUnreadNotifications() {
        return notificationProvider.getUnreadNotifications();
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

}
