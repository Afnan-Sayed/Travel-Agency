package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;

public class EventBooker {
    EventPortal eventPortal;
    public EventBooker() {
        eventPortal = new EventPortal();
    }

    boolean bookEvent(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.eventID = event.eventID;
        eventTicket.userID = userID;
        ArrayList<EventTicket> allUserEvents = eventPortal.getEventTicketsByUserID(userID);
        if (allUserEvents.contains(eventTicket)) {
            //send notification saying that event is already booked
            return false;
        }
        if (eventPortal.addEventTicket(eventTicket)) {
            //send success notification
            return true;
        }
        else {
            //send failure notification
            return false;
        }
    }

    boolean bookEvent(int userID, int eventID) {
        return bookEvent(userID, eventPortal.getEventByID(eventID));
    }

    boolean cancelEvent(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.eventID = event.eventID;
        eventTicket.userID = userID;
        if (eventPortal.removeEventTicket(eventTicket)) {
            //send success notification
            return true;
        }
        else {
            //send failure notification
            return false;
        }
    }

    boolean cancelEvent(int userID, int eventID) {
        return cancelEvent(userID, eventPortal.getEventByID(eventID));
    }
}
