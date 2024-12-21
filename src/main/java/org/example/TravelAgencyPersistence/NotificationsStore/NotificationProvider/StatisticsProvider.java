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
    public String getMostUsedEmail() {
        return infoProvider.getMostUsedEmail();
    }

    public int getMostUsedTemplateID() {
        return infoProvider.getMostUsedTemplateID();
    }

    public int getMostFrequentReceiverID() {
        return infoProvider.getMostFrequentReceiverID();
    }

    //dynamicFiltering
    public int getNoOfNotificationOnFilter(
            boolean successfulFlag, boolean failedFlag, boolean readFlag, boolean unreadFlag,
            Integer userId, Integer templateId, String email)
    {
        return infoProvider.getNoOfNotificationOnFilter(successfulFlag, failedFlag, readFlag, unreadFlag, userId, templateId, email);
    }
}
