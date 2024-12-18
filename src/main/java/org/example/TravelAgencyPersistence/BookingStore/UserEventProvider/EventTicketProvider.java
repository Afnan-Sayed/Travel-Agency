package org.example.TravelAgencyPersistence.BookingStore.UserEventProvider;

import org.example.TravelAgencyPersistence.BookingStore.EventTicketRepo;

import java.util.ArrayList;

public class EventTicketProvider {
    private EventTicketRepo repo;

    public EventTicketProvider() {
        repo = new EventTicketRepo();
    }

    public ArrayList<EventTicket> getAllEventTickets() {
        return repo.getAllEventTickets();
    }

    public ArrayList<EventTicket> getEventTicketsByUserID(int userID) {
        return repo.getEventTicketsByUserID(userID);
    }

    public ArrayList<EventTicket> getEventTicketsByEventID(int eventID) {
        return repo.getEventTicketsByEventID(eventID);
    }

    public boolean addEventTicket(EventTicket eventTicket) {
        return repo.addEventTicket(eventTicket);
    }

    public boolean removeEventTicket(EventTicket eventTicket) {
        return repo.removeEventTicket(eventTicket);
    }
}
