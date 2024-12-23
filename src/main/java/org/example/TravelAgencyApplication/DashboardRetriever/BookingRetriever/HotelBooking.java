package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;

import java.util.ArrayList;

public class HotelBooking extends Booking {
    public Hotel hotel;
    public ArrayList<HotelRoomInfo> room;

    public HotelBooking(Hotel hotel, ArrayList<HotelRoomInfo> room) {
        this.hotel = hotel;
        this.room = room;
    }
}
