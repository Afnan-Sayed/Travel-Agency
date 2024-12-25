package org.example.TravelAgencyPersistence.NotificationsStore;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;

import java.util.ArrayList;

public class NotificationRepo {
    private ArrayList<Notification> Notifications;
    public NotificationRepo()
    {
        Notifications = new ArrayList<>();
    }
    public ArrayList<Notification> getAllNotifications() {
        return Notifications;
    }
    public void addNotification(Notification notification) {
        Notifications.add(notification);
    }

    public boolean deleteNotification(String notificationID) {
        return Notifications.removeIf(n -> n.notificationID.equals(notificationID));
    }
}
