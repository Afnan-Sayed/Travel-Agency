package org.example.TravelAgencyController.DashboardInterface.BookingsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.BookingRetrieverInterface;
import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.HotelBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dashboard/booking/hotels")
public class HotelBookingsController {

    public BookingRetrieverInterface retriever;
    public HotelBookingsController() {
        retriever = BookingRetrieverInterface.getInstance();
    }

    @GetMapping("/all")
    public ArrayList<HotelBooking> getBookings(@RequestParam int userID) {
        return retriever.retrieveAllHotelBookings(userID);
    }

    @GetMapping("/old")
    public ArrayList<HotelBooking> getBookingsOld(@RequestParam int userID) {
        return retriever.retrieveArchivedHotelBookings(userID);
    }

    @GetMapping("/upcoming")
    public ArrayList<HotelBooking> getBookingsUpcoming(@RequestParam int userID) {
        return retriever.retrieveUpcomingHotelBookings(userID);
    }
}
