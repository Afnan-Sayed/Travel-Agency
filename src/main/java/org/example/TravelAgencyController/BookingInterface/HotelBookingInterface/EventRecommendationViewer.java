package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

public class EventRecommendationViewer {
    private static EventRecommendationViewer eventRecommendationViewer;
    private EventRecommendationViewer() {
    }
    public static EventRecommendationViewer getInstance() {
        if (eventRecommendationViewer == null) {
            eventRecommendationViewer = new EventRecommendationViewer();
        }
        return eventRecommendationViewer;
    }
}
