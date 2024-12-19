package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue.MessageSender;
import org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue.QueueFailureHandler;
import org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue.QueueManager;

import java.util.LinkedList;

public class NotificationLog {
    private DataRetriever retriever;
    private QueueChecker checker;
    private static NotificationLog  log;
    private NotificationLog()
    {
        retriever =  new DataRetriever();
        checker = new QueueChecker();

    }
    public static synchronized NotificationLog getInstance() {
        if (log == null) {
            log = new NotificationLog();
        }
        return log;
    }
    public DataRetriever getDataRetriever()
    {
        return retriever;
    }
    public QueueChecker getQueueChecker()
    {
        return checker;
    }
}
