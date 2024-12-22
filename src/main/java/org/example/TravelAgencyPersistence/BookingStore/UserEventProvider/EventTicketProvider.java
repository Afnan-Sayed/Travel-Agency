package org.example.TravelAgencyPersistence.BookingStore.UserEventProvider;

import org.example.TravelAgencyPersistence.BookingStore.EventTicketRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventTicketProvider {
    private EventTicketRepo repo;
    private static EventTicketProvider instance;

    public static EventTicketProvider getInstance() {
        if (instance == null) instance = new EventTicketProvider();
        return instance;
    }

    private EventTicketProvider() {
        repo = EventTicketRepo.getInstance();
    }

    public boolean addEventTicket(EventTicket eventTicket) {
        return repo.addEventTicket(eventTicket);
    }

    public boolean removeEventTicket(EventTicket eventTicket) {
        return repo.removeEventTicket(eventTicket);
    }

    public static Predicate<EventTicket> userIDFilter(int userID) {
        return eventTicket -> eventTicket.userID == userID;
    }

    public static Predicate<EventTicket> bookingIDFilter(int bookingID) {
        return eventTicket -> eventTicket.bookingID == bookingID;
    }

    public static Predicate<EventTicket> eventTicketIDFilter(int eventTicketID) {
        return eventTicket -> eventTicket.eventTicketID == eventTicketID;
    }

    public static Predicate<EventTicket> ticketNumFilter(int ticketNum) {
        return eventTicket -> eventTicket.ticketNum == ticketNum;
    }

    public static Predicate<EventTicket> eventIDFilter(int eventID) {
        return eventTicket -> eventTicket.event.eventID == eventID;
    }

    public static Predicate<EventTicket> dateAfterOrEqualFilter(Date date) {
        return eventTicket -> eventTicket.event.date.after(date) || eventTicket.event.date.equals(date);
    }

    public static Predicate<EventTicket> dateBeforeOrEqualFilter(Date date) {
        return eventTicket -> eventTicket.event.date.before(date) || eventTicket.event.date.equals(date);
    }

    public static Predicate<EventTicket> nameContainsFilter(String search) {
        return eventTicket -> eventTicket.event.name.contains(search);
    }

    public static Predicate<EventTicket> descriptionContainsFilter(String search) {
        return eventTicket -> eventTicket.event.description.contains(search);
    }

    public static Predicate<EventTicket> priceMoreThanOrEqualFilter(int price) {
        return eventTicket -> eventTicket.event.ticketPrice >= price;
    }

    public static Predicate<EventTicket> priceLessThanOrEqualFilter(int price) {
        return eventTicket -> eventTicket.event.ticketPrice <= price;
    }


    // Method to count notifications based on dynamic filters
    public ArrayList<EventTicket> getEventTickets(
            Integer userID, Integer bookingID, Integer eventTicketID, Integer ticketNum,
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {

        ArrayList<Predicate<EventTicket>> filters = new ArrayList<>();

        // Add filters based on flags
        if (userID != null) filters.add(userIDFilter(userID));
        if (bookingID != null) filters.add(bookingIDFilter(bookingID));
        if (eventTicketID != null) filters.add(eventTicketIDFilter(eventTicketID));
        if (ticketNum != null) filters.add(ticketNumFilter(ticketNum));
        if (eventID != null) filters.add(eventIDFilter(eventID));
        if (dateAfterOrEqual != null) filters.add(dateAfterOrEqualFilter(dateAfterOrEqual));
        if (dateBeforeOrEqual != null) filters.add(dateBeforeOrEqualFilter(dateBeforeOrEqual));
        if (nameSearch != null) filters.add(nameContainsFilter(nameSearch));
        if (descriptionSearch != null) filters.add(descriptionContainsFilter(descriptionSearch));
        if (priceMoreThanOrEqual != null) filters.add(priceMoreThanOrEqualFilter(priceMoreThanOrEqual));
        if (priceLessThanOrEqual != null) filters.add(priceLessThanOrEqualFilter(priceLessThanOrEqual));


        // Apply filters to count matching notifications
        return repo.getAllEventTickets().stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and)) // Combine filters
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
