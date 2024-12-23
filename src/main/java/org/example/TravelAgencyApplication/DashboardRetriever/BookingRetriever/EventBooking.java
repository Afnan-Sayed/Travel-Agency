package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;

import java.util.ArrayList;

public class EventBooking extends Booking {
    public Event event;
    public ArrayList<EventTicketInfo> tickets;

    public EventBooking(Event event, ArrayList<EventTicketInfo> tickets) {
        this.event = event;
        this.tickets = tickets;
    }
}
