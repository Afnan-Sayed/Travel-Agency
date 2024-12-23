package org.example.TravelAgencyController.DashboardInterface.NotificationsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever.NotificationInfo;
import org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever.NotificationRetrieverInterface;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/{id}/dashboard/notifications")
public class NotificationController {

    public NotificationRetrieverInterface retriever;
    public NotificationController() {
        retriever = NotificationRetrieverInterface.getInstance();
    }


    @GetMapping("/all")
    public ArrayList<NotificationInfo> getNotifications(
            @PathVariable int id,
            @RequestParam(required = false) Boolean read,
            @RequestParam(required = false) String email
    ) {
        if (read ==null && email ==null){
            return retriever.retrieve(id);
        }
        if (email!=null && read!=null){
            return retriever.filter(id,read,email);
        }
        if (read==null){
            return retriever.filter(id,email);
        }
        else{
            return retriever.filter(id,read);
        }
    }

    @PutMapping("/read{notificationId}")
    public String markAsRead(
            @PathVariable int id,
            @PathVariable String notificationId,
            @RequestBody NotificationInfo notification
    ) {
        retriever.readNotification(notificationId,notification);
        return "User " + id + " set notification " + notificationId + " read status to " + notification.read;
    }

    @DeleteMapping("/delete{notificationId}")
    public String deleteNotification(
            @PathVariable int id,
            @PathVariable String notificationId
    ){
        retriever.delete(notificationId);
        return "User " + id + " deleted notification " + notificationId;
    }


}

