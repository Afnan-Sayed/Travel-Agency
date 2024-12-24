package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.EventBooking.EventRetriever;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/event-recommendations")
public class EventRecommendationViewer {
    private static EventRecommendationViewer eventRecommendationViewer;
    EventRetriever eventRetriever;
    private EventRecommendationViewer() {
        eventRetriever = EventRetriever.getInstance();
    }
    public static EventRecommendationViewer getInstance() {
        if (eventRecommendationViewer == null) {
            eventRecommendationViewer = new EventRecommendationViewer();
        }
        return eventRecommendationViewer;
    }
    @GetMapping({"","/"})
    public ArrayList<Event> getEventRecommendations(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        return eventRetriever.getEventsWithinRadius(latitude, longitude, radius);
    }
}
