package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;

import java.util.ArrayList;

public class EventBooking extends Booking {
    public Event event;
    public ArrayList<EventTicketInfo> tickets;

    public EventBooking(int bookingID , Event event, ArrayList<EventTicketInfo> tickets) {
        this.bookingID = bookingID;
        this.event = event;
        this.tickets = tickets;
    }
}
