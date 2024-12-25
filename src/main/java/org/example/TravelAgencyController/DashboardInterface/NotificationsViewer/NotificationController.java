package org.example.TravelAgencyController.DashboardInterface.NotificationsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever.NotificationInfo;
import org.example.TravelAgencyApplication.DashboardRetriever.NotificationRetriever.NotificationRetrieverInterface;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dashboard/notifications")
public class NotificationController {

    public NotificationRetrieverInterface retriever;
    public NotificationController() {
        retriever = NotificationRetrieverInterface.getInstance();
    }


    @GetMapping("/all")
    public ArrayList<NotificationInfo> getNotifications(
            @RequestParam int userID,
            @RequestParam(required = false) Boolean read,
            @RequestParam(required = false) String email
    ) {
        if (read ==null && email ==null){
            return retriever.retrieve(userID);
        }
        if (email!=null && read!=null){
            return retriever.filter(userID,read,email);
        }
        if (read==null){
            return retriever.filter(userID,email);
        }
        else{
            return retriever.filter(userID,read);
        }
    }

    @PutMapping("/{notificationID}")
    public boolean markAsRead(
            @RequestParam int userID,
            @PathVariable String notificationID,
            @RequestParam boolean read
    ) {
        return retriever.readNotification(notificationID,read, userID);
    }//if return is false then it didn't complete

    @DeleteMapping("/{notificationID}/delete")
    public boolean deleteNotification(
            @RequestParam int userID,
            @PathVariable String notificationID
    ){
        return retriever.delete(notificationID, userID);
    }//if return is false then it didn't complete


}

