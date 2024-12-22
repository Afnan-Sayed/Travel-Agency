package org.example.TravelAgencyController.NotificationsInterface.NotificationStatus;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationStatistics.NotificationLog;
import org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/notifications/concrete")
public class ConcreteDataRetrieverController {
    private final NotificationLog notificationLog;

    public ConcreteDataRetrieverController() {
        this.notificationLog = NotificationLog.getInstance();
    }

    @GetMapping("/all")
    public ArrayList<Notification> getAllNotifications() {
        return notificationLog.getConcreteDataRepresentative().AllNotifications();
    }

    @GetMapping("/successful")
    public ArrayList<Notification> getSuccessfulNotifications() {
        return notificationLog.getConcreteDataRepresentative().SuccessfulNotifications();
    }

    @GetMapping("/failed")
    public ArrayList<Notification> getFailedNotifications() {
        return notificationLog.getConcreteDataRepresentative().FailedNotifications();
    }

    @GetMapping("/read")
    public ArrayList<Notification> getReadNotifications() {
        return notificationLog.getConcreteDataRepresentative().ReadNotifications();
    }

    @GetMapping("/unread")
    public ArrayList<Notification> getUnreadNotifications() {
        return notificationLog.getConcreteDataRepresentative().UnreadNotifications();
    }

    @GetMapping("/user/{userID}")
    public ArrayList<Notification> getNotificationsForUser(@PathVariable Integer userID) {
        return notificationLog.getConcreteDataRepresentative().NotificationsForAUser(userID);
    }
    @GetMapping("/user/successful/{userID}")
    public ArrayList<Notification> getSuccessfulNotificationsForUser(@PathVariable Integer userID) {
        return notificationLog.getConcreteDataRepresentative().SuccessfulNotificationsForAUser(userID);
    }
    @GetMapping("/user/failed/{userID}")
    public ArrayList<Notification> getFailedNotificationsForUser(@PathVariable Integer userID) {
        return notificationLog.getConcreteDataRepresentative().FailedNotificationsForAUser(userID);
    }

    @GetMapping("/email/{email}")
    public ArrayList<Notification> getNotificationsForEmail(@PathVariable String email) {
        return notificationLog.getConcreteDataRepresentative().NotificationsForAnEmail(email);
    }

    @GetMapping("/template/{templateID}/successful")
    public ArrayList<Notification> getSuccessfulNotificationsForTemplate(@PathVariable Integer templateID) {
        return notificationLog.getConcreteDataRepresentative().SuccessfulNotificationsForATemplate(templateID);
    }

    @GetMapping("/template/{templateID}/failed")
    public ArrayList<Notification> getFailedNotificationsForTemplate(@PathVariable Integer templateID) {
        return notificationLog.getConcreteDataRepresentative().NoOfFailedNotificationsForATemplate(templateID);
    }

    @GetMapping("/email/successful/{email}")
    public ArrayList<Notification> getSuccessfulNotificationsForEmail(@PathVariable String email) {
        return notificationLog.getConcreteDataRepresentative().SuccessfulNotificationsForAnEmail(email);
    }

    @GetMapping("/email/failed/{email}")
    public ArrayList<Notification> getFailedNotificationsForEmail(@PathVariable String email) {
        return notificationLog.getConcreteDataRepresentative().FailedNotificationsForAnEmail(email);
    }
}
