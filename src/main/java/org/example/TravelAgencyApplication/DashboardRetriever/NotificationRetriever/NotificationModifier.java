package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;


import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

public class NotificationModifier {
    private NotificationContentPortal portal;
    private NotificationRetriever retriever;

    public NotificationModifier() {
        portal = NotificationContentPortal.getInstance();
        retriever = new NotificationRetriever();
    }

    public boolean deleteNotification(String notificationId, int userID) {
        if(retriever.checkNotification(notificationId,userID)){
            return portal.getContentProviderClass().deleteNotification(notificationId);
        }
        else return false;
    }

    public boolean changeReadStatus(String notificationId, boolean read, int userID) {
        if(retriever.checkNotification(notificationId,userID)){
            portal.getContentProviderClass().markAsRead(notificationId, read);
            return true;
        }
        else return false;
    }




}
