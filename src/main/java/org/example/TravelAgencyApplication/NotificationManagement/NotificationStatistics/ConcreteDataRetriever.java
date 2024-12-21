package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public class ConcreteDataRetriever {
    NotificationContentPortal portal;
    protected ConcreteDataRetriever() {
        portal = NotificationContentPortal.getInstance();
    }
    //general Info
    public ArrayList<Notification> AllNotifications() {
        return portal.getContentProviderClass().getFilteredNotifications(false,false,false,false,null,null,null,null);
    }
    public ArrayList<Notification> SuccessfulNotifications() {
        return portal.getContentProviderClass().getFilteredNotifications(true,false,false,false,null,null,null,null);
    }
    public ArrayList<Notification> FailedNotifications()
    {
        return portal.getContentProviderClass().getFilteredNotifications(false,true,false,false,null,null,null,null);
    }
    public ArrayList<Notification> ReadNotifications()
    {
        return portal.getContentProviderClass().getFilteredNotifications(false,false,true,false,null,null,null,null);
    }
    public ArrayList<Notification> UnreadNotifications()
    {
        return portal.getContentProviderClass().getFilteredNotifications(false,false,false,true,null,null,null,null);
    }
    public ArrayList<Notification> SuccessfulNotificationsForATemplate(Integer templateID) {
        return portal.getContentProviderClass().getFilteredNotifications(true,false,false,false,null,templateID,null,null);
    }
    public ArrayList<Notification> NoOfFailedNotificationsForATemplate(Integer templateID) {
        return portal.getContentProviderClass().getFilteredNotifications(false,true,false,false,null,templateID,null,null);
    }

    //user specific information
    public ArrayList<Notification> NotificationsForAUser(Integer userID) {
        return portal.getContentProviderClass().getFilteredNotifications(false,false,false,false,userID,null,null,null);
    }
    public ArrayList<Notification> SuccessfulNotificationsForAUser(Integer userID) {
        return portal.getContentProviderClass().getFilteredNotifications(true,false,false,false,userID,null,null,null);
    }
    public ArrayList<Notification> FailedNotificationsForAUser(Integer userID) {
        return portal.getContentProviderClass().getFilteredNotifications(false,true,false,false,userID,null,null,null);
    }
    public ArrayList<Notification> NotificationsForAnEmail(String email) {
        return portal.getContentProviderClass().getFilteredNotifications(false,false,false,false,null,null,null,email);
    }
    public ArrayList<Notification> SuccessfulNotificationsForAnEmail(String email) {
        return portal.getContentProviderClass().getFilteredNotifications(true,false,false,false,null,null,null,email);
    }
    public ArrayList<Notification> FailedNotificationsForAnEmail(String email) {
        return portal.getContentProviderClass().getFilteredNotifications(false,true,false,false,null,null,null,email);
    }
}
