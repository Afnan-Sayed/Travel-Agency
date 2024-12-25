package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

import java.util.ArrayList;

public class NotificationRetrieverInterface {
    private final NotificationRetriever retriever;
    private final NotificationModifier modifier;

    private NotificationRetrieverInterface() {
        retriever = new NotificationRetriever();
        modifier = new NotificationModifier();
    }

    //singleton
    private static NotificationRetrieverInterface instance;
    public static NotificationRetrieverInterface getInstance() {
        if (instance == null) {instance = new NotificationRetrieverInterface();}
        return instance;
    }

    //retrieve
    public ArrayList<NotificationInfo> retrieve(int userID) {
        return retriever.retrieveNotifications(userID);
    }

    public ArrayList<NotificationInfo> filter(int userID,boolean read,String email) {
        return retriever.retrieve(userID,read, !read, email);
    }

    public ArrayList<NotificationInfo> filter(int userID,String email) {
        return retriever.retrieve(userID,false, false, email);
    }

    public ArrayList<NotificationInfo> filter(int userID,boolean read) {
        return retriever.retrieve(userID,read, !read, null);
    }


    //modify
    public boolean delete(String notificationID, int userID) {
        return modifier.deleteNotification(notificationID, userID);
    }

    public boolean readNotification(String notificationID, boolean read, int userID) {
        return modifier.changeReadStatus(notificationID, read, userID);
    }

}
