package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

public class AvailableHotelsViewer {
    private static AvailableHotelsViewer availableHotelsViewer;
    private AvailableHotelsViewer() {
    }
    public static AvailableHotelsViewer getInstance() {
        if (availableHotelsViewer == null) {
            availableHotelsViewer = new AvailableHotelsViewer();
        }
        return availableHotelsViewer;
    }


}
