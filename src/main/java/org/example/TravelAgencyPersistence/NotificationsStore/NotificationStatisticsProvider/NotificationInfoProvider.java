package org.example.TravelAgencyPersistence.NotificationsStore.NotificationStatisticsProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationInfoProvider {
    private NotificationRepo repo;

    public NotificationInfoProvider(NotificationRepo repo) {
        this.repo = repo;
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
    // Predicates for filtering
    public static Predicate<Notification> successfulFilter() {
        return notification -> notification.status == 0;
    }

    public static Predicate<Notification> failedFilter() {
        return notification -> notification.status != 0;
    }

    public static Predicate<Notification> readFilter() {
        return notification -> notification.read;
    }

    public static Predicate<Notification> unreadFilter() {
        return notification -> !notification.read;
    }

    public static Predicate<Notification> emailFilter(String email) {
        return notification -> notification.mail.equalsIgnoreCase(email);
    }

    public static Predicate<Notification> userByIdFilter(int userId) {
        return notification -> notification.receiverID == userId;
    }

    public static Predicate<Notification> templateIdFilter(int templateId) {
        return notification -> notification.templateID == templateId;
    }


    // Method to count notifications based on dynamic filters
    public int getNoOfNotificationOnFilter(
            boolean successfulFlag, boolean failedFlag, boolean readFlag, boolean unreadFlag,
            Integer userId, Integer templateId, String email) {

        List<Predicate<Notification>> filters = new ArrayList<>();

        // Add filters based on flags
        if (successfulFlag) filters.add(successfulFilter());
        if (failedFlag) filters.add(failedFilter());
        if (readFlag) filters.add(readFilter());
        if (unreadFlag) filters.add(unreadFilter());
        if (userId != null) filters.add(userByIdFilter(userId));
        if (templateId != null) filters.add(templateIdFilter(templateId));
        if (email != null && !email.isEmpty()) filters.add(emailFilter(email));

        // Apply filters to count matching notifications
        return (int) repo.getAllNotifications().stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and)) // Combine filters
                .count();
    }
}
