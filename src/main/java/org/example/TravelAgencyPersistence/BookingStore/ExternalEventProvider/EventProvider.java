package org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider;

import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProviderAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventProvider {
    private ExternalEventProviderAPI repo;

    private static EventProvider instance;
    public static EventProvider getInstance() {
        if (instance == null) instance = new EventProvider();
        return instance;
    }

    private EventProvider() {
        repo = ExternalEventProviderAPI.getInstance();
    }

    public static Predicate<Event> eventIDFilter(int eventID) {
        return event -> event.eventID == eventID;
    }

    public static Predicate<Event> dateAfterOrEqualFilter(Date date) {
        return event -> event.date.after(date) || event.date.equals(date);
    }

    public static Predicate<Event> dateBeforeOrEqualFilter(Date date) {
        return event -> event.date.before(date) || event.date.equals(date);
    }

    public static Predicate<Event> nameContainsFilter(String search) {
        return event -> event.name.contains(search);
    }

    public static Predicate<Event> descriptionContainsFilter(String search) {
        return event -> event.description.contains(search);
    }

    public static Predicate<Event> priceMoreThanOrEqualFilter(int price) {
        return event -> event.ticketPrice >= price;
    }

    public static Predicate<Event> priceLessThanOrEqualFilter(int price) {
        return event -> event.ticketPrice <= price;
    }


    // Method to count notifications based on dynamic filters
    public ArrayList<Event> getEvents(
            Integer eventID, Date dateAfterOrEqual, Date dateBeforeOrEqual, String nameSearch,
            String descriptionSearch, Integer priceMoreThanOrEqual, Integer priceLessThanOrEqual) {

        ArrayList<Predicate<Event>> filters = new ArrayList<>();

        // Add filters based on flags
        if (eventID != null) filters.add(eventIDFilter(eventID));
        if (dateAfterOrEqual != null) filters.add(dateAfterOrEqualFilter(dateAfterOrEqual));
        if (dateBeforeOrEqual != null) filters.add(dateBeforeOrEqualFilter(dateBeforeOrEqual));
        if (nameSearch != null) filters.add(nameContainsFilter(nameSearch));
        if (descriptionSearch != null) filters.add(descriptionContainsFilter(descriptionSearch));
        if (priceMoreThanOrEqual != null) filters.add(priceMoreThanOrEqualFilter(priceMoreThanOrEqual));
        if (priceLessThanOrEqual != null) filters.add(priceLessThanOrEqualFilter(priceLessThanOrEqual));


        // Apply filters to count matching notifications
        return repo.getAllEvents().stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and)) // Combine filters
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
