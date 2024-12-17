package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;

import java.util.ArrayList;

public class ContentProvider {
    private NotificationProvider notificationProvider;


    public ContentProvider(NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }


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

    public ArrayList<Notification> getAllSuccessfulNotifications() {
        return notificationProvider.getSuccessfulNotifications();
    }

    public ArrayList<Notification> getAllFailedNotifications() {
        return notificationProvider.getFailedNotifications();
    }

    public void addNotification(Notification notification) {
        notificationProvider.addNotification(notification);
    }

    public void deleteNotification(int receiverID, String message) {
        notificationProvider.deleteNotification(receiverID, message);
    }

}
