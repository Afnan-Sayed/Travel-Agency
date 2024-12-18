package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;

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

    public ArrayList<Notification> getAllReadNotifications() {
        return notificationProvider.getReadNotifications();
    }

    public ArrayList<Notification> getAllUnreadNotifications() {
        return notificationProvider.getUnreadNotifications();
    }

    public void addNotification(Notification notification) {
        notificationProvider.addNotification(notification);
    }

    public boolean deleteNotification(int notificationID) {
        return notificationProvider.deleteNotification(notificationID);
    }

}
