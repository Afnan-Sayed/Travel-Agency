package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;


public class NotificationModifier {
    private NotificationContentPortal notificationContent = NotificationContentPortal.getInstance();

    public NotificationModifier() {

    }

    public void delNotification(int notificationId) {
        // todo notificationContent.deleteNotification(???, ???); //ask Ahmed what to add here
    }

    //TODO if seen and unseen will be added add their function here (read, or unread)
//    public void readNotification(int notificationId) {
//        //get notification's index using its ID
//        //change the read to true
//        //save it
//    }


}
