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
        bookedHotelRoom.hotelID = room.hotelID;
        ArrayList<String> notificationInput= new ArrayList<>();
        notificationInput.add(hotelRetriever.getHotelByID(room.hotelID).hotelName);
        if(hotelPortal.bookHotelRoom(bookedHotelRoom)&&hotelPortal.addBookedHotelRoom(bookedHotelRoom)){
            notificationInput.add(String.valueOf(bookingID));
            //notificationBuilder.makeNotification(new HotelBookingSuccessTemplate(),notificationInput,userID);
            return true;
        }
        else {
            //notificationBuilder.makeNotification(new HotelBookingFailureTemplate(),notificationInput,userID);
            return false;
        }
    }
    public boolean bookHotelRoom(int hotelID,int roomNumber, int userID, int bookingID,Date date,int nights){
        return bookHotelRoom(userID,hotelRetriever.getFilteredHotelRooms(null,null,roomNumber,null,null,hotelID).get(0),bookingID,nights,date);
    }
    public boolean cancelHotelRoom(int userID,BookedHotelRoom room){
        if(hotelPortal.cancelBooking(room)&&hotelPortal.removeBookedHotelRoom(room)){
            ArrayList<String> notificationInput= new ArrayList<>();
            notificationInput.add(hotelRetriever.getHotelByID(room.hotelID).hotelName);
            //notificationBuilder.makeNotification(new HotelBookingCancellationTemplate(),notificationInput,userID);
            return true;
        }
        return false;
    }
    public boolean cancelHotelRoom(int userID,int roomID,int bookingID){
        return cancelHotelRoom(userID,hotelRetriever.getFilteredBookedHotelRooms(roomID,userID,bookingID,null,null,null).get(0));
    }
    public void cancelAllBookedHotelRooms(int bookingID){
        ArrayList<BookedHotelRoom> allBookedHotelRooms = hotelPortal.getFilteredBookedHotelRooms(null,null,bookingID,null,null,null);
        for(BookedHotelRoom bookedHotelRoom : allBookedHotelRooms){
            hotelPortal.cancelBooking(bookedHotelRoom);
        }
    }
}
