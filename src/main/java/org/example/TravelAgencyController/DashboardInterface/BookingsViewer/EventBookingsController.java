package org.example.TravelAgencyController.DashboardInterface.BookingsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.BookingRetrieverInterface;
import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.EventBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dashboard/booking/events")
public class EventBookingsController {

    public BookingRetrieverInterface retriever;
    public EventBookingsController() {
        retriever = BookingRetrieverInterface.getInstance();
    }

    @GetMapping("/all")
    public ArrayList<EventBooking> getBookings(@RequestParam int userID) {
        return retriever.retrieveAllEventBookings(userID);
    }

    @GetMapping("/old")
    public ArrayList<EventBooking> getOldBookings(@RequestParam int userID) {
        return retriever.retrieveArchivedEventBookings(userID);
    }

    @GetMapping("/upcoming")
    public ArrayList<EventBooking> getUpcomingBookings(@RequestParam int userID) {
        return retriever.retrieveUpcomingEventBookings(userID);
    }

}
