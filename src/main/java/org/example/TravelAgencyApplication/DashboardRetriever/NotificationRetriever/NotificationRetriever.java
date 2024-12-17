package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import java.util.ArrayList;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;

public class NotificationRetriever { //This class is concerned with retrieving a single user's notifications
    private ArrayList<Notification> notifications;
    private int userId;
    private NotificationContentPortal notificationContent = NotificationContentPortal.getInstance();

    public void retrieveNotifications() {
        notifications = notificationContent.getNotificationsByUserID(userId);
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    //TODO Should we add read and unread?
//    public ArrayList<Notification> getSeenNotifications() {
//        ArrayList<Notification> temp = new ArrayList<>(notifications);
//        temp.retainAll(notificationContent.getSeenNotifications());
//
//    }


    public NotificationRetriever(int ID) {
        userId = ID;
        retrieveNotifications();
    }
}
