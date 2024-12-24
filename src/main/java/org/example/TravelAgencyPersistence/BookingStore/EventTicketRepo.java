package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;

public class EventTicketRepo {
    private ArrayList<EventTicket> eventTickets;

    private ExternalEventProviderAPI eventRepo = ExternalEventProviderAPI.getInstance();

    private static EventTicketRepo instance;
    public static EventTicketRepo getInstance() {
        if (instance == null) instance = new EventTicketRepo();
        return instance;
    }

    private EventTicketRepo() {
        eventTickets = new ArrayList<>();
        EventTicket e1 = new EventTicket();
        e1.event = eventRepo.getAllEvents().get(0); e1.userID = 3; e1.bookingID = 1; e1.eventTicketID = 1; e1.ticketNum = 430;
        eventTickets.add(e1);

        EventTicket e2 = new EventTicket();
        e2.event = eventRepo.getAllEvents().get(1); e2.userID = 1; e2.bookingID = 2; e2.eventTicketID = 2; e2.ticketNum = 612;
        eventTickets.add(e2);

        EventTicket e3 = new EventTicket();
        e3.event = eventRepo.getAllEvents().get(2); e3.userID = 4; e3.bookingID = 5; e3.eventTicketID = 3; e3.ticketNum = 40;
        eventTickets.add(e3);

        EventTicket e4 = new EventTicket();
        e4.event = eventRepo.getAllEvents().get(3); e4.userID = 2; e4.bookingID = 4; e4.eventTicketID = 4; e4.ticketNum = 168;
        eventTickets.add(e4);

        EventTicket e5 = new EventTicket();
        e5.event = eventRepo.getAllEvents().get(4); e5.userID = 1; e5.bookingID = 10; e5.eventTicketID = 5; e5.ticketNum = 50;
        eventTickets.add(e5);

        EventTicket e6 = new EventTicket();
        e6.event = eventRepo.getAllEvents().get(0); e6.userID = 2; e6.bookingID = 11; e6.eventTicketID = 6; e5.ticketNum = 101;
        eventTickets.add(e6);

        EventTicket e7 = new EventTicket();
        e7.event = eventRepo.getAllEvents().get(1); e7.userID = 5; e7.bookingID = 20; e7.eventTicketID = 7; e7.ticketNum = 345;
        eventTickets.add(e7);
    }

    public ArrayList<EventTicket> getAllEventTickets() {
        return eventTickets;
    }

    public EventTicket addEventTicket(EventTicket eventTicket) {
        eventTicket.eventTicketID = eventTickets.stream().mapToInt(t -> t.eventTicketID).max().getAsInt() + 1;
        eventTickets.add(eventTicket);
        return eventTicket;
    }

    public boolean removeEventTicket(EventTicket eventTicket) {
        return eventTickets.remove(eventTicket);
    }
}
