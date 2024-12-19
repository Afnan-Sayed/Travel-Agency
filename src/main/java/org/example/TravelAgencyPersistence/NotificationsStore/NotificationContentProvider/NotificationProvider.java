package org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

    public ArrayList<Notification> getNotificationByNotificationID(String ID) {
        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(notification -> notification.notificationID.equals(ID))
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
    public boolean deleteNotification(String notificationID) {
        return repo.deleteNotification(notificationID);
    }

    // notifications of a specific user by ID
    public static Predicate<Notification> userByIdFilter(int id) {
        return notification -> notification.receiverID == id;
    }

    // notifications by email
    public static Predicate<Notification> emailFilter(String email) {
        return notification -> notification.mail.equalsIgnoreCase(email);
    }

    // notifications by template ID
    public static Predicate<Notification> templateByIdFilter(int templateId) {
        return notification -> notification.templateID == templateId;
    }

    // notifications succeeded
    public static Predicate<Notification> successfulFilter() {
        return notification -> notification.status == 0;
    }

    // notifications failed
    public static Predicate<Notification> failedFilter() {
        return notification -> notification.status != 0;
    }
    // notifications read
    public static Predicate<Notification> readFilter() {
        return notification -> notification.read;
    }
    // notifications unread
    public static Predicate<Notification> unreadFilter() {
        return notification -> !notification.read;
    }
    //notification by notification ID
    public static Predicate<Notification> notificationIdFilter(String notificationID) {
        return notification -> notification.notificationID.equals(notificationID);
    }

    // add a new notification
    public ArrayList<Notification> getFilteredNotifications(boolean successfulFlag, boolean failedFlag, boolean readFlag, boolean unreadFlag, Integer userId, Integer templateId, String email, String notificationID) {
        ArrayList<Predicate<Notification>> filters = new ArrayList<>();
        // Add filters based on flags
        if (successfulFlag) filters.add(successfulFilter());
        if (failedFlag) filters.add(failedFilter());
        if (readFlag) filters.add(readFilter());
        if (unreadFlag) filters.add(unreadFilter());
        if (userId != null) filters.add(userByIdFilter(userId));
        if (templateId != null) filters.add(templateByIdFilter(templateId));
        if (email != null && !email.isEmpty()) filters.add(emailFilter(email));
        if(notificationID != null) filters.add(notificationIdFilter(notificationID));

        return (ArrayList<Notification>) repo.getAllNotifications()
                .stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
    }
}
