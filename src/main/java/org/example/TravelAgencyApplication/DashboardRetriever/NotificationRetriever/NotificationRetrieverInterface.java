package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import java.util.ArrayList;

public class NotificationRetrieverInterface {
    private final NotificationRetriever retriever;
    private final NotificationModifier modifier;

    public NotificationRetrieverInterface(int userID) {
        retriever = new NotificationRetriever(userID);
        modifier = new NotificationModifier(userID);
    }

    //retrieve
    public ArrayList<NotificationInfo> retrieve() {
        return retriever.retrieveNotifications();
    }

    public ArrayList<NotificationInfo> filter(boolean read,String email) {
        return retriever.retrieve(read, !read, email);
    }

    public ArrayList<NotificationInfo> filter(String email) {
        return retriever.retrieve(true, true, email);
    }

    public ArrayList<NotificationInfo> filter(boolean read) {
        return retriever.retrieve(read, !read, null);
    }


    //modify
    public void delete(String notificationID) {
        modifier.deleteNotification(notificationID);
    }

    public void readNotification(String notificationID) {
        modifier.changeReadStatus(notificationID);
    }

}
