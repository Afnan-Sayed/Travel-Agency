package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationStatisticsProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;

import java.util.*;
import java.util.stream.Collectors;

public class NotificationInfoProvider {
    private NotificationRepo repo;

    public NotificationInfoProvider(NotificationRepo repo) {
        this.repo = repo;
    }

    // total no of notifications
    public int getTotalNotifications() {
        return repo.getAllNotifications().size();
    }

    // most used email
    public String getMostUsedEmail() {
        return repo.getAllNotifications().stream()
                .collect(Collectors.groupingBy(n -> n.mail, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No email found");
    }

    // most used template ID
    public int getMostUsedTemplateID() {
        return repo.getAllNotifications().stream()
                .collect(Collectors.groupingBy(n -> n.templateID, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    // count of notifications for a specific email
    public int getCountOfEmail(String email) {
        return (int) repo.getAllNotifications().stream()
                .filter(n -> n.mail.equalsIgnoreCase(email))
                .count();
    }

    // most frequent receiver ID
    public int getMostFrequentReceiverID() {
        return repo.getAllNotifications().stream()
                .collect(Collectors.groupingBy(n -> n.receiverID, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }


    // Get all notifications grouped by email
    public Map<String, List<Notification>> groupNotificationsByEmail() {
        return repo.getAllNotifications().stream()
                .collect(Collectors.groupingBy(n -> n.mail));
    }
}
