package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class HotelBooker {
    private static HotelBooker hotelBooker;
    private HotelPortal hotelPortal;
    private HotelRetriever hotelRetriever;
    private HotelBooker(){
        hotelPortal = HotelPortal.getInstance();
        hotelRetriever = HotelRetriever.getInstance();
    }
    public static HotelBooker getInstance(){
        if(hotelBooker == null){
            hotelBooker = new HotelBooker();
        }
        return hotelBooker;
    }
    public boolean bookHotelRoom(int userID, HotelRoom room){
        BookedHotelRoom bookedHotelRoom = new BookedHotelRoom();
        bookedHotelRoom.userID = userID;
        bookedHotelRoom.roomID = room.roomID;
        ArrayList<BookedHotelRoom> allUserBookedHotelRooms = hotelPortal.getFilteredBookedHotelRooms(null,userID,null,null,null,null);
        if(allUserBookedHotelRooms.contains(bookedHotelRoom)){
            //send notification saying that room is already booked
            return false;
        }
        if(hotelPortal.addBookedHotelRoom(bookedHotelRoom)){
            //send success notification
            return true;
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
        if(hotelPortal.removeBookedHotelRoom(bookedHotelRoom)){
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
            hotelPortal.removeBookedHotelRoom(bookedHotelRoom);
        }
    }
}
