package org.example.TravelAgencyController.DashboardInterface.BookingsViewer;

import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.BookingRetrieverInterface;
import org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever.HotelBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/{id}/dashboard/booking/hotels")
public class HotelBookingsController {

    public BookingRetrieverInterface retriever; //todo singleton
    public HotelBookingsController() {
        retriever = new BookingRetrieverInterface();
    }

    @GetMapping("/all")
    public ArrayList<HotelBooking> getBookings(@PathVariable int id) {
        return retriever.retrieveAllHotelBookings(id);
    }

    @GetMapping("/old")
    public ArrayList<HotelBooking> getBookingsOld(@PathVariable int id) {
        return retriever.retrieveArchivedHotelBookings(id);
    }

    @GetMapping("/upcoming")
    public ArrayList<HotelBooking> getBookingsUpcoming(@PathVariable int id) {
        return retriever.retrieveUpcomingHotelBookings(id);
    }
}
