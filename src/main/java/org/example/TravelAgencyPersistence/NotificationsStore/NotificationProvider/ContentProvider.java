package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;

import java.util.ArrayList;

public class ContentProvider {
    private NotificationProvider notificationProvider;

    // Constructor
    public ContentProvider(NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }

    // Delegate methods to NotificationProvider
    public ArrayList<Notification> getNotificationsByUserID(int userID) {
        return notificationProvider.getNotifOfUserByID(userID);
    }

    public ArrayList<Notification> getNotificationsByEmail(String email) {
        return notificationProvider.getNotifByEmail(email);
    }

    public ArrayList<Notification> getNotificationsByTemplateID(int templateID) {
        return notificationProvider.getNotifByTemplateID(templateID);
    }

    public ArrayList<Notification> getAllNotifications() {
        return notificationProvider.getAllNotifications();
    }

    public void addNotification(Notification notification) {
        notificationProvider.addNotification(notification);
    }

    public void deleteNotification(int receiverID, String message) {
        notificationProvider.deleteNotification(receiverID, message);
    }
}
