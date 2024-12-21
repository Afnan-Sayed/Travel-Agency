package org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics;


import org.springframework.stereotype.Component;

public class NotificationLog {
    private StatisticsDataRetriever statisticsRetriever;
    private QueueChecker checker;
    private ConcreteDataRetriever concreteRetriever;
    private static NotificationLog  log;
    private NotificationLog()
    {
        statisticsRetriever =  new StatisticsDataRetriever();
        checker = new QueueChecker();
        concreteRetriever = new  ConcreteDataRetriever();
    }
    public static synchronized NotificationLog getInstance() {
        if (log == null) {
            log = new NotificationLog();
        }
        return log;
    }
    public StatisticsDataRetriever getStatisticsDataRepresentative()
    {
        return statisticsRetriever;
    }
    public QueueChecker getQueueChecker()
    {
        return checker;
    }
    public ConcreteDataRetriever getConcreteDataRepresentative(){ return concreteRetriever;}
}
