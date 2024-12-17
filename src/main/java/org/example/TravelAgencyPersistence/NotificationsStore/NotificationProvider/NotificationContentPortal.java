package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationStatisticsProvider.NotificationInfoProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotificationContentPortal {
    private static NotificationContentPortal portal; // Single instance (Lazy Initialization)
    private final NotificationProvider notificationProvider;
    private final NotificationInfoProvider infoProvider;

    // Private Constructor
    private NotificationContentPortal() {
        NotificationRepo repo = new NotificationRepo();
        notificationProvider = new NotificationProvider(repo);
        infoProvider = new NotificationInfoProvider(repo);
    }

    // Public Method to Return the Singleton Instance
    public static synchronized NotificationContentPortal getInstance() {
        if (portal == null) {
            portal = new NotificationContentPortal();
        }
        return portal;
    }

    // ContentProvider functionalities
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

    // StatisticsProvider functionalities
    public int getTotalNotifications() {
        return infoProvider.getTotalNotifications();
    }

    public String getMostUsedEmail() {
        return infoProvider.getMostUsedEmail();
    }

    public int getMostUsedTemplateID() {
        return infoProvider.getMostUsedTemplateID();
    }

    public int getCountOfEmail(String email) {
        return infoProvider.getCountOfEmail(email);
    }

    public int getMostFrequentReceiverID() {
        return infoProvider.getMostFrequentReceiverID();
    }


    public Map<String, List<Notification>> groupNotificationsByEmail() {
        return infoProvider.groupNotificationsByEmail();
    }
}
