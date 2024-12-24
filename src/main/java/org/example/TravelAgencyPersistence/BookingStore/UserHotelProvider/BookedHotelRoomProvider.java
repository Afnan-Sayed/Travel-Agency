package org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider;
import org.example.TravelAgencyPersistence.BookingStore.BookedHotelRoomRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookedHotelRoomProvider {
    private static BookedHotelRoomProvider bookedHotelRoomProvider;
    private BookedHotelRoomRepo repo;
    private BookedHotelRoomProvider() {
        repo = BookedHotelRoomRepo.getInstance();
    }
    public static BookedHotelRoomProvider getInstance() {
        if (bookedHotelRoomProvider == null) {
            bookedHotelRoomProvider = new BookedHotelRoomProvider();
        }
        return bookedHotelRoomProvider;
    }
    public boolean addBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        return repo.addBookedHotelRoom(bookedHotelRoom);
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        return repo.removeBookedHotelRoom(bookedHotelRoom);
    }
    public ArrayList<BookedHotelRoom> getAllBookedHotelRooms() {
        return repo.getAllBookedHotelRooms();
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByRoomID(int roomID) {
        return bookedHotelRoom -> bookedHotelRoom.roomID == roomID;
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByUserID(int userID) {
        return bookedHotelRoom -> bookedHotelRoom.userID == userID;
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByBookingID(int bookingID) {
        return bookedHotelRoom -> bookedHotelRoom.bookingID == bookingID;
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByHotelRoom(HotelRoom hotelRoom) {
        return bookedHotelRoom -> bookedHotelRoom.roomID == hotelRoom.roomID;
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByDate(Date date) {
        return bookedHotelRoom -> bookedHotelRoom.date.equals(date);
    }
    public Predicate<BookedHotelRoom> getBookedHotelRoomByNights(int nights) {
        return bookedHotelRoom -> bookedHotelRoom.nights == nights;
    }
    public ArrayList<BookedHotelRoom> getFilteredBookedHotelRooms(Integer roomID, Integer userID, Integer bookingID, HotelRoom hotelRoom, Date date, Integer nights) {
        ArrayList<Predicate<BookedHotelRoom>> filters = new ArrayList<>();
        if(roomID != null){
            filters.add(getBookedHotelRoomByRoomID(roomID));
        }
        if(userID != null){
            filters.add(getBookedHotelRoomByUserID(userID));
        }
        if(bookingID != null){
            filters.add(getBookedHotelRoomByBookingID(bookingID));
        }
        if(hotelRoom != null){
            filters.add(getBookedHotelRoomByHotelRoom(hotelRoom));
        }
        if(date != null){
            filters.add(getBookedHotelRoomByDate(date));
        }
        if(nights != null){
            filters.add(getBookedHotelRoomByNights(nights));
        }
        return (ArrayList<BookedHotelRoom>) repo.getAllBookedHotelRooms()
                .stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
    }
}
