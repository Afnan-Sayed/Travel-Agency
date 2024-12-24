package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;

import java.util.ArrayList;

public class HotelBooking extends Booking {
    public HotelInfo hotel;
    public ArrayList<HotelRoomInfo> room;

    public HotelBooking(int bookingID, HotelInfo hotel, ArrayList<HotelRoomInfo> room) {
        this.bookingID = bookingID;
        this.hotel = hotel;
        this.room = room;
    }
}
