package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Builder;
import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;

public class EventBooker {
    private EventPortal eventPortal;
    private EventRetriever eventRetriever;
    private Builder notificationBuilder;

    private static EventBooker instance;
    public static EventBooker getInstance() {
        if (instance == null) instance = new EventBooker();
        return instance;
    }

    private EventBooker() {
        eventPortal = EventPortal.getInstance();
        eventRetriever = EventRetriever.getInstance();
        notificationBuilder = new Builder();
    }

    boolean bookEvent(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.userID = userID;
        ArrayList<EventTicket> allUserEvents = eventRetriever.getEventTicketsByUserID(userID);
        boolean bookingSuccess;
        if (allUserEvents.contains(eventTicket)) bookingSuccess = false;
        else if (eventPortal.addEventTicket(eventTicket)) bookingSuccess = true;
        else bookingSuccess = false;
        ArrayList<String> notificationInput = new ArrayList<>();
        notificationInput.add(event.name);
        if (bookingSuccess) {
            notificationBuilder.makeNotification(new EventBookingSuccessTemplate(), notificationInput, userID, 3);
        }
        else {
            notificationBuilder.makeNotification(new EventBookingFailureTemplate(), notificationInput, userID, 3);
        }
        return bookingSuccess;
    }

    boolean bookEvent(int userID, int eventID) {
        return bookEvent(userID, eventRetriever.getEventByID(eventID));
    }

    boolean cancelEventTicket(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.userID = userID;
        if (eventPortal.cancelEventTicket(eventTicket)) {
            ArrayList<String> notificationInput = new ArrayList<>();
            notificationInput.add(event.name);
            notificationBuilder.makeNotification(new EventCancellationTemplate(), notificationInput, userID, 3);
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
