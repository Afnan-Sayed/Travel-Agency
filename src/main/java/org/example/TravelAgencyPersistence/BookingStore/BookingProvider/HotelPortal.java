package org.example.TravelAgencyPersistence.BookingStore.BookingProvider;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoomProvider;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoomProvider;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

public class HotelPortal {
    private static HotelPortal hotelPortal;
    private HotelRoomProvider hotelRoomProvider;
    private BookedHotelRoomProvider bookedHotelRoomProvider;
    private HotelPortal() {
        hotelRoomProvider = HotelRoomProvider.getInstance();
        bookedHotelRoomProvider = BookedHotelRoomProvider.getInstance();
    }
    public static HotelPortal getInstance() {
        if(hotelPortal == null) {
            hotelPortal = new HotelPortal();
        }
        return hotelPortal;
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return hotelRoomProvider.getAllHotelRooms();
    }
    public ArrayList<BookedHotelRoom> getAllBookedHotelRooms() {
        return bookedHotelRoomProvider.getAllBookedHotelRooms();
    }
    public ArrayList<Hotel> getAllHotels() {
        return hotelRoomProvider.getAllHotels();
    }
    public boolean bookHotelRoom(BookedHotelRoom bookedHotelRoom) {
        return hotelRoomProvider.bookHotelRoom(bookedHotelRoom);
    }
    public ArrayList<HotelRoom> getFilteredHotelRooms(Integer roomID, String roomType, Integer roomNumber, Integer price, Boolean isBooked, Integer hotelID) {
        return hotelRoomProvider.getFilteredHotelRooms(roomID, roomType, roomNumber, price, isBooked, hotelID);
    }
    public ArrayList<BookedHotelRoom> getFilteredBookedHotelRooms(Integer roomID, Integer userID, Integer bookingID, HotelRoom hotelRoom, Date date, Integer nights) {
        return bookedHotelRoomProvider.getFilteredBookedHotelRooms(roomID, userID, bookingID, hotelRoom, date, nights);
    }
    public boolean cancelBooking(BookedHotelRoom room) {
        return hotelRoomProvider.cancelBooking(room);
    }
    public boolean addBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.addBookedHotelRoom(room);
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.removeBookedHotelRoom(room);
    }
}
