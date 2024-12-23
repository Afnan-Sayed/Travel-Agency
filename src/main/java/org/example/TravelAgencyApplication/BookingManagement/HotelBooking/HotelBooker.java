/*
package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class HotelBooker {
    private HotelPortal hotelPortal;
    public HotelBooker(){
        hotelPortal = new HotelPortal();
    }
    public boolean bookHotelRoom(int userID, HotelRoom room){
        BookedHotelRoom bookedHotelRoom = new BookedHotelRoom();
        bookedHotelRoom.userID = userID;
        bookedHotelRoom.roomID = room.roomID;
        ArrayList<BookedHotelRoom> allUserBookedHotelRooms = hotelPortal.getBookedHotelRoomsByUserID(userID);
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
        return bookHotelRoom(userID,hotelPortal.getHotelRoomByID(roomID));
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
        return cancelHotelRoom(userID,hotelPortal.getHotelRoomByID(roomID));
    }
}
*/
