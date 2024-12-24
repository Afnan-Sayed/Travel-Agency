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

    public EventTicket bookEvent(Event event, int userID, int bookingID) {
        EventTicket eventTicket = eventPortal.bookEvent(event, userID, bookingID);
        ArrayList<String> notificationInput = new ArrayList<>();
        notificationInput.add(event.name);
        if (eventTicket != null) {
            notificationBuilder.makeNotification(new EventBookingSuccessTemplate(), notificationInput, userID);
        }
        else {
            notificationBuilder.makeNotification(new EventBookingFailureTemplate(), notificationInput, userID);
        }
        return eventTicket;
    }

    public EventTicket bookEvent(int eventID, int userID, int bookingID) {
        return bookEvent(eventRetriever.getEventByID(eventID), userID, bookingID);
    }

    public boolean cancelEventTicket(int userID, Event event) {
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.userID = userID;
        if (eventPortal.cancelEventTicket(eventTicket)) {
            ArrayList<String> notificationInput = new ArrayList<>();
            notificationInput.add(event.name);
            notificationBuilder.makeNotification(new EventCancellationTemplate(), notificationInput, userID);
            return true;
        }
        return false;
    }

    public boolean cancelEventTicket(int userID, int eventID) {
        return cancelEventTicket(userID, eventRetriever.getEventByID(eventID));
    }

    public void cancelAllEventTickets(int bookingID) {
        ArrayList<EventTicket> eventTickets = eventRetriever.getEventTicketsByBookingID(bookingID);
        for (EventTicket eventTicket : eventTickets) {
            cancelEventTicket(eventTicket.userID, eventTicket.event);
        }
    }
}
