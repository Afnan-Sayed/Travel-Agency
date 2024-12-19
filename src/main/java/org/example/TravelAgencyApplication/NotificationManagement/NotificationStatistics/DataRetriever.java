package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider.NotificationContentPortal;

public class DataRetriever {
    NotificationContentPortal portal;
    protected DataRetriever()
    {
        portal = NotificationContentPortal.getInstance();
    }
    public int IDofUserWithMostNotifications()
    {
       return portal.getStatisticsProvider().getMostFrequentReceiverID();
    }
    public int mostUsedTemplateID()
    {
        return portal.getStatisticsProvider().getMostUsedTemplateID();
    }

    public int NoOfFailedNotifications()
    {
        return portal.getStatisticsProvider().getNoOfFailedNotifications();
    }
    public int NoOfSucceededNotifications()
    {
        return portal.getStatisticsProvider().getNoOfSuccessfulNotifications();
    }
    public int NoOfReadNotifications()
    {
        return portal.getStatisticsProvider().getNoOfReadNotifications();
    }
    public int NoOfUnreadNotifications()
    {
        return portal.getStatisticsProvider().getNoOfUnreadNotifications();
    }
    public int NoOfAllNotifications()
    {
        return portal.getStatisticsProvider().getTotalNotifications();
    }

}
