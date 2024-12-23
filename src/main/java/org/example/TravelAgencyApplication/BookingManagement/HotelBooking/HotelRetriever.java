package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Date;


public class HotelRetriever {
    private static HotelRetriever hotelRetriever;
    private HotelPortal hotelPortal;

    private HotelRetriever(){
        hotelPortal = HotelPortal.getInstance();
    }
    public static HotelRetriever getInstance(){
        if(hotelRetriever == null){
            hotelRetriever = new HotelRetriever();
        }
        return hotelRetriever;
    }
    public ArrayList<HotelRoom> getFilteredHotelRooms(Integer roomID, String roomType, Integer roomNumber, Integer price, Boolean isBooked, Hotel hotel){
        return hotelPortal.getFilteredHotelRooms(roomID,roomType,roomNumber,price,isBooked,hotel);
    }
    public ArrayList<BookedHotelRoom> getFilteredBookedHotelRooms(Integer roomID, Integer userID, Integer bookingID, HotelRoom hotelRoom, Date date, Integer nights){
        return hotelPortal.getFilteredBookedHotelRooms(roomID,userID,bookingID,hotelRoom,date,nights);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return hotelPortal.getAllHotelRooms();
    }

}
