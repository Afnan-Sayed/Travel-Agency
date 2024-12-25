package org.example.TravelAgencyController.DashboardInterface.BookingsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.BookingRetrieverInterface;
import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.EventBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/{id}/dashboard/booking/events")
public class EventBookingsController {

    public BookingRetrieverInterface retriever;
    public EventBookingsController() {
        retriever = BookingRetrieverInterface.getInstance();
    }

    @GetMapping("/all")
    public ArrayList<EventBooking> getBookings(@PathVariable int id) {
        return retriever.retrieveAllEventBookings(id);
    }

    @GetMapping("/old")
    public ArrayList<EventBooking> getOldBookings(@PathVariable int id) {
        return retriever.retrieveArchivedEventBookings(id);
    }

    @GetMapping("/upcoming")
    public ArrayList<EventBooking> getUpcomingBookings(@PathVariable int id) {
        return retriever.retrieveUpcomingEventBookings(id);
    }

}
