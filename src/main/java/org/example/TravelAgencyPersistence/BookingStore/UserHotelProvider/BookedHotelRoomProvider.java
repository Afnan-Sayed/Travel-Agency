package org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider;
import org.example.TravelAgencyPersistence.BookingStore.BookedHotelRoomRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;

import java.util.ArrayList;

public class BookedHotelRoomProvider {
    private BookedHotelRoomRepo repo;
public BookedHotelRoomProvider() {
        repo = new BookedHotelRoomRepo();
    }
    public ArrayList<BookedHotelRoom> getAllBookedHotelRooms() {
        return repo.getAllBookedHotelRooms();
    }
    public ArrayList<BookedHotelRoom> getBookedHotelRoomsByUserID(int userID) {
        return repo.getBookedHotelRoomsByUserID(userID);
    }
    public BookedHotelRoom getBookedHotelRoomsByRoomID(int roomID) {
        return repo.getBookedHotelRoomByRoomID(roomID);
    }
    public boolean addBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        return repo.addBookedHotelRoom(bookedHotelRoom);
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        return repo.removeBookedHotelRoom(bookedHotelRoom);
    }
}
