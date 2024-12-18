package org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider;

import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProviderAPI;

import java.util.ArrayList;

public class EventProvider {
    private ExternalEventProviderAPI repo;
    public EventProvider() {
        repo = new ExternalEventProviderAPI();
    }

    public Event getEventByID(int eventID) {
        return repo.getEventByID(eventID);
    }

    public ArrayList<Event> getAllEvents() {
        return repo.getAllEvents();
    }
}
