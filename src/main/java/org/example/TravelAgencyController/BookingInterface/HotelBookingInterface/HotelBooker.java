package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

public class HotelBooker {
    private static HotelBooker hotelBooker;
    private HotelBooker() {
    }
    public static HotelBooker getInstance() {
        if (hotelBooker == null) {
            hotelBooker = new HotelBooker();
        }
        return hotelBooker;
    }
}
