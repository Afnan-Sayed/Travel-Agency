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
    private final ContentProvider contentProvider;
    private final StatisticsProvider statisticsProvider;

    // Private Constructor
    private NotificationContentPortal() {
        NotificationRepo repo = new NotificationRepo();
        NotificationProvider NP = new NotificationProvider(repo);
        NotificationInfoProvider IP = new NotificationInfoProvider(repo);
        contentProvider = new ContentProvider(NP);
        statisticsProvider = new StatisticsProvider(IP);
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
        return contentProvider.getNotificationsByUserID(userID);
    }

    public ArrayList<Notification> getNotificationsByEmail(String email) {
        return contentProvider.getNotificationsByEmail(email);
    }

    public ArrayList<Notification> getNotificationsByTemplateID(int templateID) {
        return contentProvider.getNotificationsByTemplateID(templateID);
    }

    public ArrayList<Notification> getAllNotifications() {
        return contentProvider.getAllNotifications();
    }

    public ArrayList<Notification> getSuccessfulNotifications() {
        return contentProvider.getAllSuccessfulNotifications();
    }

    public ArrayList<Notification> getFailedNotifications() {
        return contentProvider.getAllFailedNotifications();
    }

    public void addNotification(Notification notification) {
        contentProvider.addNotification(notification);
    }

    public void deleteNotification(int receiverID, String message) {
        contentProvider.deleteNotification(receiverID, message);
    }

    // StatisticsProvider functionalities
    public int getTotalNotifications() {
        return statisticsProvider.getTotalNotifications();
    }

    public String getMostUsedEmail() {
        return statisticsProvider.getMostUsedEmail();
    }

    public int getMostUsedTemplateID() {
        return statisticsProvider.getMostUsedTemplateID();
    }

    public int getCountOfEmail(String email) {
        return statisticsProvider.getCountOfEmail(email);
    }

    public int getMostFrequentReceiverID() {
        return statisticsProvider.getMostFrequentReceiverID();
    }

    public int getNoOfSuccessfulNotifications() {
        return statisticsProvider.getNoOfSuccessfulNotifications();
    }

    public int getNoOfFailedNotifications() {
        return statisticsProvider.getNoOfFailedNotifications();
    }


    public Map<String, List<Notification>> groupNotificationsByEmail() {
        return statisticsProvider.groupNotificationsByEmail();
    }
}
