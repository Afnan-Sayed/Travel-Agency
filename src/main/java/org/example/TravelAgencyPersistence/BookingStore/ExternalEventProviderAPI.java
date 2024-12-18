package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ExternalEventProviderAPI {
    private ArrayList<Event> events;

    public ExternalEventProviderAPI() {
        events = new ArrayList<>();
        Event e1 = new Event();
        e1.eventID = 1; e1.name = "Pyramids Music Festival"; e1.date = new Date(2024, Calendar.DECEMBER, 22); e1.description = "Join the unforgettable music festival by the pyramids of Giza, featuring electronic beats and stunning views!";
        e1.latitude = 29.9781; e1.longitude = 31.1342; e1.ticketPrice = 180;
        events.add(e1);

        Event e2 = new Event();
        e2.eventID = 2; e2.name = "Artificial Intelligence Conference in Cairo University"; e2.date = new Date(2024, Calendar.JANUARY, 24); e2.description = "AI conference featuring talks and workshops led by AI experts!";
        e2.latitude = 30.0272; e2.longitude = 31.2085; e2.ticketPrice = 0;
        events.add(e2);

        Event e3 = new Event();
        e3.eventID = 3; e3.name = "Egyptian Museum Tour"; e3.date = new Date(2024, Calendar.DECEMBER, 29); e3.description = "Explore the wonders of Egyptian history!";
        e3.latitude = 30.047778; e3.longitude = 31.236193; e3.ticketPrice = 70;
        events.add(e3);

        Event e4 = new Event();
        e4.eventID = 4; e4.name = "Rock Concert in Giza"; e4.date = new Date(2025, Calendar.JANUARY, 3); e4.description = "Get ready to rock and roll!";
        e4.latitude = 30.013056; e4.longitude = 31.208853; e4.ticketPrice = 140;
        events.add(e4);

        Event e5 = new Event();
        e5.eventID = 5; e5.name = "Christmas Eve Party in Cairo"; e5.date = new Date(2024, Calendar.DECEMBER, 24); e5.description = "Enjoy Christmas Eve with us in Cairo!";
        e5.latitude = 30.06263; e5.longitude = 31.24967; e5.ticketPrice = 90;
        events.add(e5);
    }

    public ArrayList<Event> getAllEvents() {
        return events;
    }

    public Event getEventByID(int id) {
        for (Event event : events) if (event.eventID == id) return event;
        return null;
    }
}
