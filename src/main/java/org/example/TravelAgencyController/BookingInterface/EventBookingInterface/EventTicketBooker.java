package org.example.TravelAgencyController.BookingInterface.EventBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.EventBooking.EventBooker;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventTicketBooker {
    private EventBooker eventBooker;

    public EventTicketBooker() {
        eventBooker = EventBooker.getInstance();
    }

    @PostMapping("/book/{eventID}")
    public EventTicket bookEventTicket(@PathVariable Integer eventID,
                                    @RequestParam int userID, @RequestParam int bookingID) {
        return eventBooker.bookEvent(eventID, userID, bookingID);
    }

    @DeleteMapping("/cancel/{eventTicketID}")
    public boolean cancelEventTicket(@PathVariable Integer eventTicketID, @RequestParam int userID) {
        return eventBooker.cancelEventTicket(eventTicketID, userID);
    }
}
