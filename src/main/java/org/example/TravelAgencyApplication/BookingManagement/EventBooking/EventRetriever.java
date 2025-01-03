package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyApplication.BookingManagement.Haversine;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;
import java.util.Date;

public class EventRetriever {
    EventPortal eventPortal;

    private static EventRetriever instance;
    public static EventRetriever getInstance() {
        if (instance == null) instance = new EventRetriever();
        return instance;
    }

    private EventRetriever() {
        eventPortal = EventPortal.getInstance();
    }

    public ArrayList<Event> getEventsWithinRadius(double latitude, double longitude, double radius) {
        ArrayList<Event> allEvents = getAllEvents();
        ArrayList<Event> eventsWithinRadius = new ArrayList<>();
        for (Event event : allEvents) {
            if (Haversine.distance(latitude, longitude, event.latitude, event.longitude) <= radius) eventsWithinRadius.add(event);
        }
        return eventsWithinRadius;
    }

    public ArrayList<Event> getFilteredEvents(
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {
        return eventPortal.getFilteredEvents(eventID, dateAfterOrEqual, dateBeforeOrEqual, nameSearch,
                descriptionSearch, priceMoreThanOrEqual, priceLessThanOrEqual);
    }

    public ArrayList<EventTicket> getFilteredEventTickets(
            Integer userID, Integer bookingID, Integer eventTicketID, Integer ticketNum,
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {
        return eventPortal.getFilteredEventTickets(userID, bookingID, eventTicketID, ticketNum, eventID,
                dateAfterOrEqual, dateBeforeOrEqual, nameSearch, descriptionSearch, priceMoreThanOrEqual, priceLessThanOrEqual);
    }

    //the following are common search queries that are provided by default.
    //for more complex search queries, the above methods will have to be used.

    public ArrayList<Event> getAllEvents() {
        return getFilteredEvents(null, null, null, null,
                null, null, null);
    }

    public Event getEventByID(int eventID) {
        ArrayList<Event> events = getFilteredEvents(eventID, null, null, null, null, null, null);
        if (!events.isEmpty()) return events.getFirst();
        return null;
    }

    public ArrayList<EventTicket> getEventTicketsByBookingID(Integer bookingID) {
        return getFilteredEventTickets(null, bookingID, null, null, null,
                null, null, null, null, null, null);
    }

}
