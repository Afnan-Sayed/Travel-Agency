package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;

public class EventBooker {
    EventPortal eventPortal;
    EventRetriever eventRetriever;

    private static EventBooker instance;
    public static EventBooker getInstance() {
        if (instance == null) instance = new EventBooker();
        return instance;
    }

    private EventBooker() {
        eventPortal = EventPortal.getInstance();
        eventRetriever = EventRetriever.getInstance();
    }

    boolean bookEvent(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.userID = userID;
        ArrayList<EventTicket> allUserEvents = eventRetriever.getEventTicketsByUserID(userID);
        boolean successful;
        if (allUserEvents.contains(eventTicket)) successful = false;
        else if (eventPortal.addEventTicket(eventTicket)) successful = true;
        else successful = false;
        if (successful) {
            //send success notification
        }
        else {
            //send failure notification
        }
        return successful;
    }

    boolean bookEvent(int userID, int eventID) {
        return bookEvent(userID, eventRetriever.getEventByID(eventID));
    }

    boolean cancelEventTicket(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.userID = userID;
        if (eventPortal.cancelEventTicket(eventTicket)) {
            //send cancellation notification
            return true;
        }
        return false;
    }

    boolean cancelEventTicket(int userID, int eventID) {
        return cancelEventTicket(userID, eventRetriever.getEventByID(eventID));
    }

    void cancelAllEventTickets(int bookingID) {
        ArrayList<EventTicket> eventTickets = eventRetriever.getEventTicketsByBookingID(bookingID);
        for (EventTicket eventTicket : eventTickets) {
            cancelEventTicket(eventTicket.userID, eventTicket.event);
        }
    }
}
