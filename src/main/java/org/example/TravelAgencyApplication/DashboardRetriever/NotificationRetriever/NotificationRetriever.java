package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

import java.util.ArrayList;


public class NotificationRetriever { //This class is concerned with retrieving a single user's notifications
    private ArrayList<Notification> notifications;
    private int userId;
    private NotificationContentPortal portal = NotificationContentPortal.getInstance();

    public NotificationRetriever(int ID) {
        userId = ID;
    } //id is given since creation

    public ArrayList<Notification> retrieve(boolean read, boolean unread, String email) {
        return notifications = portal.getContentProviderClass().getFilteredNotifications(
                true,
                false,
                read,
                unread,
                userId,
                null,
                email,
                null
        );
    } //the filters needed by this component

    public ArrayList<Notification> retrieveNotifications() {
        //notifications = portal.getContentProviderClass().getNotificationsByUserID(ID); //old and lame\
        //new and advanced:
        return retrieve(true, true,null);
    }//default filters


}
