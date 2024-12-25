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

    @PutMapping("/{notificationId}")
    public boolean markAsRead(
            @PathVariable int id,
            @PathVariable String notificationId,
            @RequestParam boolean read
    ) {
        return retriever.readNotification(notificationId,read, id);
    }//if return is false then it didn't complete

    @DeleteMapping("/{notificationId}/delete")
    public boolean deleteNotification(
            @PathVariable int id,
            @PathVariable String notificationId
    ){
        return retriever.delete(notificationId, id);
    }//if return is false then it didn't complete


}

