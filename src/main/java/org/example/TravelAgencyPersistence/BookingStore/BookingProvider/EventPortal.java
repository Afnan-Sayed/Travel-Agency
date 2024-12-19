package org.example.TravelAgencyPersistence.BookingStore.BookingProvider;

import org.example.TravelAgencyPersistence.BookingStore.EventTicketRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.EventProvider;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicketProvider;

import java.util.ArrayList;

public class EventPortal {

    EventProvider eventProvider;
    EventTicketProvider eventTicketProvider;

    public EventPortal() {
        eventProvider = new EventProvider();
        eventTicketProvider = new EventTicketProvider();
    }

    public Event getEventByID(int eventID) {
        return eventProvider.getEventByID(eventID);
    }

    public ArrayList<Event> getAllEvents() {
        return eventProvider.getAllEvents();
    }

    public ArrayList<EventTicket> getAllEventTickets() {
        return eventTicketProvider.getAllEventTickets();
    }

    public ArrayList<EventTicket> getEventTicketsByUserID(int userID) {
        return eventTicketProvider.getEventTicketsByUserID(userID);
    }

    public ArrayList<EventTicket> getEventTicketsByEventID(int eventID) {
        return eventTicketProvider.getEventTicketsByEventID(eventID);
    }

    public boolean addEventTicket(EventTicket eventTicket) {
        return eventTicketProvider.addEventTicket(eventTicket);
    }

    public boolean removeEventTicket(EventTicket eventTicket) {
        return eventTicketProvider.removeEventTicket(eventTicket);
    }
}
