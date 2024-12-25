package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class BookedHotelRoomRepo {
    private static BookedHotelRoomRepo bookedHotelRoomRepo;
    private ArrayList<BookedHotelRoom> bookedHotelRooms;
    private BookedHotelRoomRepo() {
        bookedHotelRooms = new ArrayList<>();
        BookedHotelRoom bookedHotelRoom1 = new BookedHotelRoom();
        bookedHotelRoom1.roomID = 1;
        bookedHotelRoom1.userID = 1;
        bookedHotelRooms.add(bookedHotelRoom1);

        BookedHotelRoom bookedHotelRoom2 = new BookedHotelRoom();
        bookedHotelRoom2.roomID = 2;
        bookedHotelRoom2.userID = 2;
        bookedHotelRooms.add(bookedHotelRoom2);

        BookedHotelRoom bookedHotelRoom3 = new BookedHotelRoom();
        bookedHotelRoom3.roomID = 3;
        bookedHotelRoom3.userID = 3;
        bookedHotelRooms.add(bookedHotelRoom3);

        BookedHotelRoom bookedHotelRoom4 = new BookedHotelRoom();
        bookedHotelRoom4.roomID = 4;
        bookedHotelRoom4.userID = 4;
        bookedHotelRooms.add(bookedHotelRoom4);

        BookedHotelRoom bookedHotelRoom5 = new BookedHotelRoom();
        bookedHotelRoom5.roomID = 5;
        bookedHotelRoom5.userID = 5;
        bookedHotelRooms.add(bookedHotelRoom5);

        BookedHotelRoom bookedHotelRoom6 = new BookedHotelRoom();
        bookedHotelRoom6.roomID = 6;
        bookedHotelRoom6.userID = 6;
        bookedHotelRooms.add(bookedHotelRoom6);

        BookedHotelRoom bookedHotelRoom7 = new BookedHotelRoom();
        bookedHotelRoom7.roomID = 7;
        bookedHotelRoom7.userID = 7;
        bookedHotelRooms.add(bookedHotelRoom7);
    }
    public static BookedHotelRoomRepo getInstance() {
        if (bookedHotelRoomRepo == null) {
            bookedHotelRoomRepo = new BookedHotelRoomRepo();
        }
        return bookedHotelRoomRepo;
    }
    public ArrayList<BookedHotelRoom> getAllBookedHotelRooms() {
        return bookedHotelRooms;
    }
    public boolean addBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        if(bookedHotelRooms.contains(bookedHotelRoom)) {
            return false;
        }
        else{
            bookedHotelRooms.add(bookedHotelRoom);
            return true;
        }
    }
    public boolean removeBookedHotelRoom(BookedHotelRoom bookedHotelRoom) {
        if(bookedHotelRooms.contains(bookedHotelRoom)) {
            bookedHotelRooms.remove(bookedHotelRoom);
            return true;
        }
        else{
            return false;
        }
    }
}
