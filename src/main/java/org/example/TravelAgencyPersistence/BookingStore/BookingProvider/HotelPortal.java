package org.example.TravelAgencyPersistence.BookingStore.BookingProvider;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoomProvider;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoomProvider;

import java.awt.print.Book;
import java.util.ArrayList;

public class HotelPortal {
    private HotelRoomProvider hotelRoomProvider;
    private BookedHotelRoomProvider bookedHotelRoomProvider;
    public HotelPortal() {
        hotelRoomProvider = new HotelRoomProvider();
        bookedHotelRoomProvider = new BookedHotelRoomProvider();
    }
    public HotelRoom getHotelRoomByID(int id) {
        return hotelRoomProvider.getHotelRoomByID(id);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return hotelRoomProvider.getAllHotelRooms();
    }
    public ArrayList<BookedHotelRoom> getAllBookedHotelRooms() {
        return bookedHotelRoomProvider.getAllBookedHotelRooms();
    }
    public ArrayList<BookedHotelRoom> getBookedHotelRoomsByUserID(int userID) {
        return bookedHotelRoomProvider.getBookedHotelRoomsByUserID(userID);
    }
    public BookedHotelRoom getBookedHotelRoomsByRoomID(int roomID) {
        return bookedHotelRoomProvider.getBookedHotelRoomsByRoomID(roomID);
    }
    public boolean addBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.addBookedHotelRoom(room);
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom room) {
        return bookedHotelRoomProvider.removeBookedHotelRoom(room);
    }
}
