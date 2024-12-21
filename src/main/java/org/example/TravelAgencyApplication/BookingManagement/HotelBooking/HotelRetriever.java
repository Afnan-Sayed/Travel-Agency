package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;

import java.util.ArrayList;

public class HotelRetriever {
    private HotelPortal hotelPortal;

    public HotelRetriever(){
        hotelPortal = new HotelPortal();
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return hotelPortal.getAllHotelRooms();
    }
    public HotelRoom getHotelRoomByID(int roomID) {
        return hotelPortal.getHotelRoomByID(roomID);
    }
}
