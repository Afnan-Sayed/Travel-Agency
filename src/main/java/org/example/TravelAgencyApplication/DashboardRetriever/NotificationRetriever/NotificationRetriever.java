package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

import java.util.ArrayList;


public class NotificationRetriever { //This class is concerned with retrieving a single user's notifications
    private int userId;
    private NotificationContentPortal portal = NotificationContentPortal.getInstance();

    public NotificationRetriever(int ID) {
        userId = ID;
    } //id is given since creation

    public ArrayList<NotificationInfo> retrieve(boolean read, boolean unread, String email) {
        ArrayList<Notification> data = portal.getContentProviderClass().getFilteredNotifications(
                true,
                false,
                read,
                unread,
                userId,
                null,
                email,
                null
        );
        ArrayList<NotificationInfo> protectedData = new ArrayList<>();

        for (Notification notification : data) {
            protectedData.add(new NotificationInfo(
                    notification.notificationID,
                    notification.message,
                    notification.mail,
                    notification.read
                    )
            );
        }
        return protectedData;

    } //the filters needed by this component

    public ArrayList<NotificationInfo> retrieveNotifications() {
        return retrieve(true, true,null);
    }//default filters


}
