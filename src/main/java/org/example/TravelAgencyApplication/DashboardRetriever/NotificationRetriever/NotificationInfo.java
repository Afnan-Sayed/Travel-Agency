package org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever;

public class NotificationInfo { //dashboard user notification concerned data
    public String notificationId;
    public String message;
    public String email;
    public boolean read;

    NotificationInfo(String notificationId, String message, String email, boolean read) {
        this.notificationId = notificationId;
        this.message = message;
        this.email = email;
        this.read = read;
    }

//    public String getNotificationId() {
//        return notificationId;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public boolean isRead() {
//        return read;
//    }
}
