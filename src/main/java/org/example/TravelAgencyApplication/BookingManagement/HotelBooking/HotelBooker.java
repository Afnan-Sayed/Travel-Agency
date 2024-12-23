package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Builder;
import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Date;

public class HotelBooker {
    private static HotelBooker hotelBooker;
    private HotelPortal hotelPortal;
    private HotelRetriever hotelRetriever;
    private Builder notificationBuilder;
    private HotelBooker(){
        hotelPortal = HotelPortal.getInstance();
        hotelRetriever = HotelRetriever.getInstance();
        notificationBuilder = new Builder();
    }
    public static HotelBooker getInstance(){
        if(hotelBooker == null){
            hotelBooker = new HotelBooker();
        }
        return hotelBooker;
    }
    public boolean bookHotelRoom(int userID, HotelRoom room, int bookingID, int nights, Date date){
        BookedHotelRoom bookedHotelRoom = new BookedHotelRoom();
        bookedHotelRoom.userID = userID;
        bookedHotelRoom.roomID = room.roomID;
        bookedHotelRoom.bookingID = bookingID;
        bookedHotelRoom.date = date;
        bookedHotelRoom.nights = nights;
        bookedHotelRoom.hotel = room.hotel;
        ArrayList<String> notificationInput= new ArrayList<>();
        notificationInput.add(room.hotel.hotelName);
        if(hotelPortal.bookHotelRoom(bookedHotelRoom)){
            notificationBuilder.makeNotification(new HotelBookingSuccessTemplate(),notificationInput,userID);
        }
        else {
            //send failure notification
            return false;
        }
    }
    public boolean bookHotelRoom(int userID,int roomID){
        return bookHotelRoom(userID,hotelPortal.getFilteredHotelRooms(roomID,null,null,null,null,null).get(0));
    }
    public boolean cancelHotelRoom(int userID,HotelRoom room){
        BookedHotelRoom bookedHotelRoom = new BookedHotelRoom();
        bookedHotelRoom.userID = userID;
        bookedHotelRoom.roomID = room.roomID;
        if(hotelPortal.cancelBooking(bookedHotelRoom)){
            //send success notification
            return true;
        }
        else {
            //send failure notification
            return false;
        }
    }
    public boolean cancelHotelRoom(int userID,int roomID){
        return cancelHotelRoom(userID,hotelPortal.getFilteredHotelRooms(roomID,null,null,null,null,null).get(0));
    }
    public void cancelAllBookedHotelRooms(int bookingID){
        ArrayList<BookedHotelRoom> allBookedHotelRooms = hotelPortal.getFilteredBookedHotelRooms(null,null,bookingID,null,null,null);
        for(BookedHotelRoom bookedHotelRoom : allBookedHotelRooms){
            hotelPortal.cancelBooking(bookedHotelRoom);
        }
    }
}
