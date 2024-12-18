package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationProvider;

import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.NotificationProvider;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationRepo;
import src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationStatisticsProvider.NotificationInfoProvider;


public class NotificationContentPortal {
    private static NotificationContentPortal portal; // Single instance (Lazy Initialization)
    private final ContentProvider contentProvider;
    private final StatisticsProvider statisticsProvider;

    // Private Constructor
    private NotificationContentPortal() {
        NotificationRepo repo = new NotificationRepo();
        NotificationProvider NP = new NotificationProvider(repo);
        NotificationInfoProvider IP = new NotificationInfoProvider(repo);
        contentProvider = new ContentProvider(NP);
        statisticsProvider = new StatisticsProvider(IP);
    }

    public ContentProvider getContentProviderClass()
    {
        return contentProvider;
    }
    public StatisticsProvider getStatisticsProvider()
    {
        return statisticsProvider;
    }
    public static synchronized NotificationContentPortal getInstance() {
        if (portal == null) {
            portal = new NotificationContentPortal();
        }
        return portal;
    }
}
