package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;
import org.springframework.stereotype.Component;


public class StatisticsDataRetriever {
    NotificationContentPortal portal;
    protected StatisticsDataRetriever() {
        portal = NotificationContentPortal.getInstance();
    }
    //general Info
    public int NoOfAllNotifications() {
        return portal.getStatisticsProvider().getTotalNotifications();
    }
    public int NoOfSuccessfulNotifications() {
        return portal.getStatisticsProvider().getNoOfSuccessfulNotifications();
    }
    public int NoOfFailedNotifications()
    {
        return portal.getStatisticsProvider().getNoOfFailedNotifications();
    }
    public int NoOfReadNotifications()
    {
        return portal.getStatisticsProvider().getNoOfReadNotifications();
    }
    public int NoOfUnreadNotifications()
    {
        return portal.getStatisticsProvider().getNoOfUnreadNotifications();
    }
    public int mostUsedTemplateID()
    {
        return portal.getStatisticsProvider().getMostUsedTemplateID();
    }
    public int IDofUserWithMostNotifications()
    {
        return portal.getStatisticsProvider().getMostFrequentReceiverID();
    }
    public String mostUsedEmail()
    {
        return portal.getStatisticsProvider().getMostUsedEmail();
    }
    public int NoOfSuccessfulNotificationsForATemplate(Integer templateID) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(true,false,false,false,null,templateID,null);
    }
    public int NoOfFailedNotificationsForATemplate(Integer TemplateID) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(false,true,false,false,null,TemplateID,null);
    }

    //user specific information
    public int NoOfNotificationsForAUser(Integer userID) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(false,false,false,false,userID,null,null);
    }
    public int NoOfNotificationsForAnEmail(String email) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(false,false,false,false,null,null,email);
    }
    public int NoOfSuccessfulNotificationsForAUser(Integer userID) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(true,false,false,false,userID,null,null);
    }
    public int NoOfFailedNotificationsForAUser(Integer userID) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(false,true,false,false,userID,null,null);
    }
    public int NoOfSuccessfulNotificationsForAnEmail(String email) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(true,false,false,false,null,null,email);
    }
    public int NoOfFailedNotificationsForAnEmail(String email) {
        return portal.getStatisticsProvider().getNoOfNotificationOnFilter(false,true,false,false,null,null,email);
    }

}
