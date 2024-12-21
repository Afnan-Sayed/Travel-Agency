package org.example.TravelAgencyPersistence.NotificationsStore;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;

import java.util.ArrayList;

public class NotificationRepo {
    private ArrayList<Notification> Notifications;
    public NotificationRepo()
    {
        Notifications = new ArrayList<>();
        Notification n1 = new Notification();
        n1.notificationID = "1"; n1.templateID = 1; n1.receiverID = 101; n1.message = "Welcome to our service"; n1.mail = "john1@example.com"; n1.phoneNumber = "+1234567801"; n1.status = 0; n1.read = false;
        Notifications.add(n1);

        Notification n2 = new Notification();
        n2.notificationID = "2";n2.templateID = 2; n2.receiverID = 102; n2.message = "Your booking is confirmed"; n2.mail = "jane2@example.com"; n2.phoneNumber = "+1234567802"; n2.status = 1; n2.read = false;
        Notifications.add(n2);

        Notification n3 = new Notification();
        n3.notificationID = "3";n3.templateID = 3; n3.receiverID = 103; n3.message = "Payment received"; n3.mail = "mike3@example.com"; n3.phoneNumber = "+1234567803"; n3.status = 0; n3.read = false;
        Notifications.add(n3);

        Notification n4 = new Notification();
        n4.notificationID = "4";n4.templateID = 1; n4.receiverID = 104; n4.message = "Your itinerary is ready"; n4.mail = "sara4@example.com"; n4.phoneNumber = "+1234567804"; n4.status = 1; n4.read = false;
        Notifications.add(n4);

        Notification n5 = new Notification();
        n5.notificationID = "5";n5.templateID = 2; n5.receiverID = 105; n5.message = "Flight rescheduled"; n5.mail = "paul5@example.com"; n5.phoneNumber = "+1234567805"; n5.status = 0; n5.read = false;
        Notifications.add(n5);

        Notification n6 = new Notification();
        n6.notificationID = "6";n6.templateID = 3; n6.receiverID = 106; n6.message = "Hotel booking successful"; n6.mail = "kate6@example.com"; n6.phoneNumber = "+1234567806"; n6.status = 1; n6.read = false;
        Notifications.add(n6);

        Notification n7 = new Notification();
        n7.notificationID = "7";n7.templateID = 1; n7.receiverID = 107; n7.message = "Reminder for your trip"; n7.mail = "adam7@example.com"; n7.phoneNumber = "+1234567807"; n7.status = 0; n7.read = false;
        Notifications.add(n7);

        Notification n8 = new Notification();
        n8.notificationID = "8";n8.templateID = 2; n8.receiverID = 108; n8.message = "Invoice sent to your mail"; n8.mail = "emma8@example.com"; n8.phoneNumber = "+1234567808"; n8.status = 1; n8.read = false;
        Notifications.add(n8);

        Notification n9 = new Notification();
        n9.notificationID = "9";n9.templateID = 3; n9.receiverID = 109; n9.message = "Feedback request"; n9.mail = "lucas9@example.com"; n9.phoneNumber = "+1234567809"; n9.status = 0; n9.read = false;
        Notifications.add(n9);

        Notification n10 = new Notification();
        n10.notificationID = "10";n10.templateID = 1; n10.receiverID = 110; n10.message = "Cancellation confirmation"; n10.mail = "lily10@example.com"; n10.phoneNumber = "+1234567810"; n10.status = 1; n10.read = false;
        Notifications.add(n10);

        Notification n11 = new Notification();
        n11.notificationID = "11";n11.templateID = 2; n11.receiverID = 111; n11.message = "New promotion available"; n11.mail = "noah11@example.com"; n11.phoneNumber = "+1234567811"; n11.status = 0; n11.read = false;
        Notifications.add(n11);

        Notification n12 = new Notification();
        n12.notificationID = "12";n12.templateID = 3; n12.receiverID = 112; n12.message = "Your seats are confirmed"; n12.mail = "ava12@example.com"; n12.phoneNumber = "+1234567812"; n12.status = 1; n12.read = false;
        Notifications.add(n12);

        Notification n13 = new Notification();
        n13.notificationID = "13";n13.templateID = 1; n13.receiverID = 113; n13.message = "Thank you for choosing us"; n13.mail = "will13@example.com"; n13.phoneNumber = "+1234567813"; n13.status = 0; n13.read = true;
        Notifications.add(n13);

        Notification n14 = new Notification();
        n14.notificationID = "14";n14.templateID = 2; n14.receiverID = 114; n14.message = "Discount voucher sent"; n14.mail = "mia14@example.com"; n14.phoneNumber = "+1234567814"; n14.status = 1; n14.read = true;
        Notifications.add(n14);

        Notification n15 = new Notification();
        n15.notificationID = "15";n15.templateID = 3; n15.receiverID = 115; n15.message = "Trip summary sent"; n15.mail = "ethan15@example.com"; n15.phoneNumber = "+1234567815"; n15.status = 0; n15.read = true;
        Notifications.add(n15);

        Notification n16 = new Notification();
        n16.notificationID = "16";n16.templateID = 1; n16.receiverID = 116; n16.message = "Details of your package"; n16.mail = "zara16@example.com"; n16.phoneNumber = "+1234567816"; n16.status = 1; n16.read = true;
        Notifications.add(n16);

        Notification n17 = new Notification();
        n17.notificationID = "17";n17.templateID = 2; n17.receiverID = 117; n17.message = "Special offer on hotels"; n17.mail = "leo17@example.com"; n17.phoneNumber = "+1234567817"; n17.status = 0; n17.read = true;
        Notifications.add(n17);

        Notification n18 = new Notification();
        n18.notificationID = "18";n18.templateID = 3; n18.receiverID = 118; n18.message = "Booking reminder"; n18.mail = "ivy18@example.com"; n18.phoneNumber = "+1234567818"; n18.status = 1; n18.read = true;
        Notifications.add(n18);

        Notification n19 = new Notification();
        n19.notificationID = "19";n19.templateID = 1; n19.receiverID = 119; n19.message = "Loyalty points updated"; n19.mail = "ryan19@example.com"; n19.phoneNumber = "+1234567819"; n19.status = 0; n19.read = true;
        Notifications.add(n19);

        Notification n20 = new Notification();
        n20.notificationID = "20";n20.templateID = 2; n20.receiverID = 120; n20.message = "Your trip details finalized"; n20.mail = "nora20@example.com"; n20.phoneNumber = "+1234567820"; n20.status = 1; n20.read = true;
        Notifications.add(n20);
    }
    public ArrayList<Notification> getAllNotifications() {
        return Notifications;
    }
    public void addNotification(Notification notification) {
        Notifications.add(notification);
    }

    public boolean deleteNotification(String notificationID) {
        return Notifications.removeIf(n -> n.notificationID.equals(notificationID));
    }
}
