package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;

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
    public ArrayList<Notification> getNotifOfUserByID(int ID) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.receiverID == ID)
                .collect(Collectors.toList());
    }

    // notifications by email
    public ArrayList<Notification> getNotifByEmail(String email) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.mail.equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    // notifications by template ID
    public ArrayList<Notification> getNotifByTemplateID(int templateID) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.templateID == templateID)
                .collect(Collectors.toList());
    }

    // add a new notification
    public void addNotification(Notification notification) {
        repo.addNotification(notification);
    }

    // delete notification by receiver ID and message
    public boolean deleteNotification(int receiverID, String message) {
        return repo.deleteNotification(receiverID, message);
    }
}
