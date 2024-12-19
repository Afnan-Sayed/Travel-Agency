package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyApplication.BookingManagement.Haversine;
import java.util.ArrayList;

public class EventRetriever {
    EventPortal eventPortal;
    public EventRetriever() {
        eventPortal = new EventPortal();
    }

    public ArrayList<Event> getAllEvents() {
        return eventPortal.getAllEvents();
    }

    public ArrayList<Event> getEventsWithinRadius(double latitude, double longitude, double radius) {
        ArrayList<Event> allEvents = getAllEvents();
        ArrayList<Event> eventsWithinRadius = new ArrayList<>();
        for (Event event : allEvents) {
            if (Haversine.distance(latitude, longitude, event.latitude, event.longitude) <= radius) eventsWithinRadius.add(event);
        }
        return eventsWithinRadius;
    }

    public Event getEventByID(int id) {
        return eventPortal.getEventByID(id);
    }
}
