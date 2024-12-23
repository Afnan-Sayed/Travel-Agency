package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;


import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

public class NotificationModifier {
    private NotificationContentPortal portal;

    public NotificationModifier() {portal = NotificationContentPortal.getInstance();}

    public void deleteNotification(String notificationId) {
        portal.getContentProviderClass().deleteNotification(notificationId);
    }

    public void changeReadStatus(String notificationId, NotificationInfo N) {
        portal.getContentProviderClass().markAsRead(notificationId, !N.read);
        N.read = !N.read;
    }




}
