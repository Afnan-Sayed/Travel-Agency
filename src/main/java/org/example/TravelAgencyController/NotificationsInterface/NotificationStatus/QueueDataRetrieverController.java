package org.example.TravelAgencyController.NotificationsInterface.NotificationStatus;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics.NotificationLog;
import org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics.QueueChecker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications/queue")
public class QueueDataRetrieverController {

    private final NotificationLog notificationLog;

    public QueueDataRetrieverController() {
        this.notificationLog = NotificationLog.getInstance();
    }

    @GetMapping("/total")
    public int getTotalNotificationsInQueue() {
        QueueChecker queueChecker = notificationLog.getQueueChecker();
        return queueChecker.countOfNotificationsInQueue();
    }

    @GetMapping("/email")
    public int getEmailNotificationsInQueue() {
        QueueChecker queueChecker = notificationLog.getQueueChecker();
        return queueChecker.countOfEmailNotificationsInQueue();
    }

    @GetMapping("/sms")
    public int getSmsNotificationsInQueue() {
        QueueChecker queueChecker = notificationLog.getQueueChecker();
        return queueChecker.countOfSmsNotificationsInQueue();
    }
}
