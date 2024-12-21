package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

public class MessageSender {
    EmailAPI emailAPI;
    SmsAPI smsAPI;
    NotificationContentPortal portal;

    protected MessageSender()
    {
        emailAPI = new EmailAPI();
        smsAPI = new SmsAPI();
        portal = NotificationContentPortal.getInstance();
    }
    public Notification sendMessage(Notification notification)
    {
        int status = 0;
        //makes sure id is unique
        if(!IsUniqueID(notification.notificationID)) {
            notification.notificationID = null;
            return notification;
        }
        //sends message to mail
        if(notification.mail != null)
        {
            status =emailAPI.sendNotification(notification.message, notification.mail);
        }
        //sends message to sms
        else if(notification.phoneNumber != null)
        {
            status = smsAPI.sendNotification(notification.message, notification.phoneNumber);
        }
        //successfully sent
        if(status == 0) {
            //making sure status is 0 (successful)
            notification.status = 0;
            //logic for saving notification
            portal.getContentProviderClass().addNotification(notification);
            //making sure that the notification is not modified
            return null;
        }
        //failed
        else
        {
            //tries to process each notification 10 times before discarding it
            return notification;
        }
    }

    private boolean IsUniqueID(String ID)
    {
        if(portal.getContentProviderClass().getNotificationByNotificationID(ID).isEmpty())
            return false;
        else
            return true;
    }
}
