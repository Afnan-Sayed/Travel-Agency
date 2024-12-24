package org.example.TravelAgencyPersistence.BookingStore.BookingProvider;

import org.example.TravelAgencyPersistence.BookingStore.EventTicketRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.EventProvider;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicketProvider;

import java.util.ArrayList;
import java.util.Date;

public class EventPortal {

    private EventProvider eventProvider;
    private EventTicketProvider eventTicketProvider;

    private static EventPortal instance;

    public static EventPortal getInstance() {
        if (instance == null) instance = new EventPortal();
        return instance;
    }

    private EventPortal() {
        eventProvider = EventProvider.getInstance();
        eventTicketProvider = EventTicketProvider.getInstance();
    }

    public EventTicket bookEvent(Event event, int userID, int bookingID) {
        int ticketNum = eventProvider.bookEvent(event);
        if (ticketNum == 0) return null;
        EventTicket eventTicket = new EventTicket();
        eventTicket.event = event;
        eventTicket.bookingID = bookingID;
        eventTicket.userID = userID;
        eventTicket.ticketNum = ticketNum;
        return eventTicketProvider.addEventTicket(eventTicket);
    }

    public boolean cancelEventTicket(EventTicket eventTicket) {
        return eventTicketProvider.removeEventTicket(eventTicket);
    }

    public ArrayList<Event> getFilteredEvents(
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {
        return eventProvider.getEvents(eventID, dateAfterOrEqual, dateBeforeOrEqual, nameSearch,
                descriptionSearch, priceMoreThanOrEqual, priceLessThanOrEqual);
    }

    public ArrayList<EventTicket> getFilteredEventTickets(
            Integer userID, Integer bookingID, Integer eventTicketID, Integer ticketNum,
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {
        return eventTicketProvider.getEventTickets(userID, bookingID, eventTicketID, ticketNum, eventID,
                dateAfterOrEqual, dateBeforeOrEqual, nameSearch, descriptionSearch, priceMoreThanOrEqual, priceLessThanOrEqual);
    }
}
