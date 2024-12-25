package org.example.TravelAgencyController.NotificationsInterface.NotificationStatus;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics.NotificationLog;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications/statistics")
public class StatisticsRetrieverController {
    private final NotificationLog notificationLog;

    public StatisticsRetrieverController() {
        this.notificationLog = NotificationLog.getInstance();
    }

    @GetMapping("/total")
    public int getTotalNotifications() {
        return notificationLog.getStatisticsDataRepresentative().NoOfAllNotifications();
    }

    @GetMapping("/successful")
    public int getSuccessfulNotifications() {
        return notificationLog.getStatisticsDataRepresentative().NoOfSuccessfulNotifications();
    }

    @GetMapping("/failed")
    public int getFailedNotifications() {
        return notificationLog.getStatisticsDataRepresentative().NoOfFailedNotifications();
    }

    @GetMapping("/read")
    public int getReadNotifications() {
        return notificationLog.getStatisticsDataRepresentative().NoOfReadNotifications();
    }

    @GetMapping("/unread")
    public int getUnreadNotifications() {
        return notificationLog.getStatisticsDataRepresentative().NoOfUnreadNotifications();
    }

    @GetMapping("/most-used-template")
    public int getMostUsedTemplateID() {
        return notificationLog.getStatisticsDataRepresentative().mostUsedTemplateID();
    }

    @GetMapping("/most-active-user")
    public int getUserWithMostNotifications() {
        return notificationLog.getStatisticsDataRepresentative().IDofUserWithMostNotifications();
    }

    @GetMapping("/most-used-email")
    public String getMostUsedEmail() {
        return notificationLog.getStatisticsDataRepresentative().mostUsedEmail();
    }

    @GetMapping("/template/{templateID}/successful")
    public int getSuccessfulNotificationsForTemplate(@PathVariable Integer templateID) {
        return notificationLog.getStatisticsDataRepresentative().NoOfSuccessfulNotificationsForATemplate(templateID);
    }

    @GetMapping("/template/{templateID}/failed")
    public int getFailedNotificationsForTemplate(@PathVariable Integer templateID) {
        return notificationLog.getStatisticsDataRepresentative().NoOfFailedNotificationsForATemplate(templateID);
    }

    @GetMapping("/user/notifications")
    public int getNotificationsForUser(@RequestParam Integer userID) {
        return notificationLog.getStatisticsDataRepresentative().NoOfNotificationsForAUser(userID);
    }

    @GetMapping("/email/notifications")
    public int getNotificationsForEmail(@RequestParam String email) {
        return notificationLog.getStatisticsDataRepresentative().NoOfNotificationsForAnEmail(email);
    }

    @GetMapping("/user/successful")
    public int getSuccessfulNotificationsForUser(@RequestParam Integer userID) {
        return notificationLog.getStatisticsDataRepresentative().NoOfSuccessfulNotificationsForAUser(userID);
    }

    @GetMapping("/user/failed")
    public int getFailedNotificationsForUser(@RequestParam Integer userID) {
        return notificationLog.getStatisticsDataRepresentative().NoOfFailedNotificationsForAUser(userID);
    }

    @GetMapping("/email/successful")
    public int getSuccessfulNotificationsForEmail(@RequestParam String email) {
        return notificationLog.getStatisticsDataRepresentative().NoOfSuccessfulNotificationsForAnEmail(email);
    }

    @GetMapping("/email/failed")
    public int getFailedNotificationsForEmail(@RequestParam String email) {
        return notificationLog.getStatisticsDataRepresentative().NoOfFailedNotificationsForAnEmail(email);
    }
}
