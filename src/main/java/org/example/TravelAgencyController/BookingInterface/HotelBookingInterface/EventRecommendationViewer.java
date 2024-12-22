package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.EventBooking.EventRetriever;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;

import java.util.ArrayList;

public class EventRecommendationViewer {
    private EventRetriever eventRetriever;
    private static EventRecommendationViewer eventRecommendationViewer;
    private EventRecommendationViewer() {
    }
    public static EventRecommendationViewer getInstance() {
        if (eventRecommendationViewer == null) {
            eventRecommendationViewer = new EventRecommendationViewer();
        }
        return eventRecommendationViewer;
    }
    public ArrayList<Event> getEventRecommendations(Hotel hotel) {
        return eventRetriever.getEventsWithinRadius(hotel.latitude, hotel.longitude, 10.0);
    }
}
