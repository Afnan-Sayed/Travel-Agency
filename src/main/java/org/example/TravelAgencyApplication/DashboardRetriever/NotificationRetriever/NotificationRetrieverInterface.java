//package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;
//
//import java.util.ArrayList;
//
//public class NotificationRetrieverInterface {
//    private final NotificationRetriever retriever;
//    private final NotificationModifier modifier;
//
//    public NotificationRetrieverInterface() {
//        retriever = new NotificationRetriever();
//        modifier = new NotificationModifier();
//    }
//
//    //retrieve
//    public ArrayList<NotificationInfo> retrieve(int userID) {
//        return retriever.retrieveNotifications(userID);
//    }
//
//    public ArrayList<NotificationInfo> filter(int userID,boolean read,String email) {
//        return retriever.retrieve(userID,read, !read, email);
//    }
//
//    public ArrayList<NotificationInfo> filter(int userID,String email) {
//        return retriever.retrieve(userID,true, true, email);
//    }
//
//    public ArrayList<NotificationInfo> filter(int userID,boolean read) {
//        return retriever.retrieve(userID,read, !read, null);
//    }
//
//
//    //modify
//    public void delete(String notificationID) {
//        modifier.deleteNotification(notificationID);
//    }
//
//    public void readNotification(String notificationID) {
//        modifier.changeReadStatus(notificationID);
//    }
//
//}
