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
        hotelRoomProvider = new HotelRoomProvider();
        bookedHotelRoomProvider = new BookedHotelRoomProvider();
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
    public boolean addHotelRoom(HotelRoom room) {
        return hotelRoomProvider.addHotelRoom(room);
    }
    public ArrayList<HotelRoom> getFilteredHotelRooms(Integer roomID, String roomType, Integer roomNumber, Integer price, Boolean isBooked, Hotel hotel) {
        return hotelRoomProvider.getFilteredHotelRooms(roomID, roomType, roomNumber, price, isBooked, hotel);
    }
    public ArrayList<BookedHotelRoom> getFilteredBookedHotelRooms(Integer roomID, Integer userID, Integer bookingID, HotelRoom hotelRoom, Date date, Integer nights) {
        return bookedHotelRoomProvider.getFilteredBookedHotelRooms(roomID, userID, bookingID, hotelRoom, date, nights);
    }
    public boolean removeHotelRoom(HotelRoom room) {
        return hotelRoomProvider.removeHotelRoom(room);
    }
    public boolean addBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.addBookedHotelRoom(room);
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.removeBookedHotelRoom(room);
    }
}
