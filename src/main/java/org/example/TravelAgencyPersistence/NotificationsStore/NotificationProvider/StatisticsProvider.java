package org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationStatisticsProvider.NotificationInfoProvider;


import java.util.List;
import java.util.Map;


public class StatisticsProvider {
    private NotificationInfoProvider infoProvider;

    // Constructor
    protected StatisticsProvider(NotificationInfoProvider infoProvider) {
        this.infoProvider = infoProvider;
    }

    // Delegate methods to NotificationInfoProvider
    public int getTotalNotifications() {
        return infoProvider.getTotalNotifications();
    }

    public String getMostUsedEmail() {
        return infoProvider.getMostUsedEmail();
    }

    public int getMostUsedTemplateID() {
        return infoProvider.getMostUsedTemplateID();
    }

    public int getCountOfEmail(String email) {
        return infoProvider.getCountOfEmail(email);
    }

    public int getMostFrequentReceiverID() {
        return infoProvider.getMostFrequentReceiverID();
    }

    public int getNoOfSuccessfulNotifications() {
        return infoProvider.getCountOfSuccessfulNotifications();
    }

    public int getNoOfFailedNotifications() {
        return infoProvider.getCountOfFailedNotifications();
    }

    public int getNoOfReadNotifications() {
        return infoProvider.getCountOfReadNotifications();
    }

    public int getNoOfUnreadNotifications() {
        return infoProvider.getCountOfUnreadNotifications();
    }

    public Map<String, List<Notification>> groupNotificationsByEmail() {
        return infoProvider.groupNotificationsByEmail();
    }


    //dynamicFiltering
    public int getNoOfNotificationOnFilter(
            boolean successfulFlag, boolean failedFlag, boolean readFlag, boolean unreadFlag,
            Integer userId, Integer templateId, String email)
    {
        return infoProvider.getNoOfNotificationOnFilter(successfulFlag, failedFlag, readFlag, unreadFlag, userId, templateId, email);
    }
}
