package org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NotificationProvider {
    private NotificationRepo repo;
    public NotificationProvider(NotificationRepo repo) {
        this.repo = repo;
    }

    // get all notifications
    public ArrayList<Notification> getAllNotifications() {
        return repo.getAllNotifications();
    }

    // notifications of a specific user by ID
    public ArrayList<Notification> getNotificationOfUserByID(int ID) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.receiverID == ID)
                .collect(Collectors.toList());
    }

    // notifications by email
    public ArrayList<Notification> getNotificationByEmail(String email) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.mail.equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    // notifications by template ID
    public ArrayList<Notification> getNotificationByTemplateID(int templateID) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.templateID == templateID)
                .collect(Collectors.toList());
    }

    // notifications succeeded
    public ArrayList<Notification> getSuccessfulNotifications() {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.status == 0)
                .collect(Collectors.toList());
    }

    // notifications failed
    public ArrayList<Notification> getFailedNotifications() {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.status != 0)
                .collect(Collectors.toList());
    }
    // notifications read
    public ArrayList<Notification> getReadNotifications() {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.read)
                .collect(Collectors.toList());
    }

    // notifications unread
    public ArrayList<Notification> getUnreadNotifications() {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> !notification.read)
                .collect(Collectors.toList());
    }

    // add a new notification
    public void addNotification(Notification notification) {
        repo.addNotification(notification);
    }

    // delete notification by receiver ID and message
    public boolean deleteNotification(int notificationID) {
        return repo.deleteNotification(notificationID);
    }
}
