package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;

public class EventTicketRepo {
    ArrayList<EventTicket> eventTickets;
    public EventTicketRepo() {
        eventTickets = new ArrayList<>();
        EventTicket e1 = new EventTicket();
        e1.eventID = 1; e1.userID = 3;
        eventTickets.add(e1);

        EventTicket e2 = new EventTicket();
        e2.eventID = 2; e2.userID = 1;
        eventTickets.add(e2);

        EventTicket e3 = new EventTicket();
        e3.eventID = 3; e3.userID = 4;
        eventTickets.add(e3);

        EventTicket e4 = new EventTicket();
        e4.eventID = 4; e4.userID = 2;
        eventTickets.add(e4);

        EventTicket e5 = new EventTicket();
        e5.eventID = 5; e5.userID = 1;
        eventTickets.add(e5);

        EventTicket e6 = new EventTicket();
        e6.eventID = 1; e6.userID = 2;
        eventTickets.add(e6);

        EventTicket e7 = new EventTicket();
        e7.eventID = 2; e7.userID = 5;
        eventTickets.add(e7);
    }

    public ArrayList<EventTicket> getAllEventTickets() {
        return eventTickets;
    }

    public ArrayList<EventTicket> getEventTicketsByUserID(int userID) {
        ArrayList<EventTicket> answer = new ArrayList<>();
        for (EventTicket eventTicket : eventTickets) if (eventTicket.userID == userID) answer.add(eventTicket);
        return answer;
    }

    public ArrayList<EventTicket> getEventTicketsByEventID(int eventID) {
        ArrayList<EventTicket> answer = new ArrayList<>();
        for (EventTicket eventTicket : eventTickets) if (eventTicket.eventID == eventID) answer.add(eventTicket);
        return answer;
    }

    public boolean addEventTicket(EventTicket eventTicket) {
        return eventTickets.add(eventTicket);
    }

    public boolean removeEventTicket(EventTicket eventTicket) {
        return eventTickets.remove(eventTicket);
    }
}
