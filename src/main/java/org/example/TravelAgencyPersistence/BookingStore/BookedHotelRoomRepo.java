package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BookedHotelRoomRepo {
    private static BookedHotelRoomRepo bookedHotelRoomRepo;
    private ArrayList<BookedHotelRoom> bookedHotelRooms;
    private BookedHotelRoomRepo() {
        bookedHotelRooms = new ArrayList<>();
        BookedHotelRoom bookedHotelRoom1 = new BookedHotelRoom();
        bookedHotelRoom1.roomID = 1;
        bookedHotelRoom1.userID = 1;
        bookedHotelRoom1.bookingID = 101;
        bookedHotelRoom1.hotelID = 1;
        bookedHotelRoom1.date = new Date(2024 - 1900, 11, 25);
        bookedHotelRoom1.nights = 2;
        bookedHotelRoom1.roomNum = 101;
        bookedHotelRooms.add(bookedHotelRoom1);

        BookedHotelRoom bookedHotelRoom2 = new BookedHotelRoom();
        bookedHotelRoom2.roomID = 2;
        bookedHotelRoom2.userID = 2;
        bookedHotelRoom2.bookingID = 102;
        bookedHotelRoom2.hotelID = 2;
        bookedHotelRoom2.date = new Date(2024 - 1900, 11, 26);
        bookedHotelRoom2.nights = 3;
        bookedHotelRoom2.roomNum = 102;
        bookedHotelRooms.add(bookedHotelRoom2);

        BookedHotelRoom bookedHotelRoom3 = new BookedHotelRoom();
        bookedHotelRoom3.roomID = 3;
        bookedHotelRoom3.userID = 2;
        bookedHotelRoom3.bookingID = 102;
        bookedHotelRoom3.hotelID = 2;
        bookedHotelRoom3.date = new Date(2024 - 1900, 11, 26);
        bookedHotelRoom3.nights = 3;
        bookedHotelRoom3.roomNum = 103;
        bookedHotelRooms.add(bookedHotelRoom3);

        BookedHotelRoom bookedHotelRoom4 = new BookedHotelRoom();
        bookedHotelRoom4.roomID = 4;
        bookedHotelRoom4.userID = 3;
        bookedHotelRoom4.bookingID = 103;
        bookedHotelRoom4.hotelID = 1;
        bookedHotelRoom4.date = new Date(2024 - 1900, 11, 27);
        bookedHotelRoom4.nights = 1;
        bookedHotelRoom4.roomNum = 104;
        bookedHotelRooms.add(bookedHotelRoom4);

        BookedHotelRoom bookedHotelRoom5 = new BookedHotelRoom();
        bookedHotelRoom5.roomID = 5;
        bookedHotelRoom5.userID = 3;
        bookedHotelRoom5.bookingID = 103;
        bookedHotelRoom5.hotelID = 1;
        bookedHotelRoom5.date = new Date(2024 - 1900, 11, 27);
        bookedHotelRoom5.nights = 1;
        bookedHotelRoom5.roomNum = 105;
        bookedHotelRooms.add(bookedHotelRoom5);

        BookedHotelRoom bookedHotelRoom6 = new BookedHotelRoom();
        bookedHotelRoom6.roomID = 6;
        bookedHotelRoom6.userID = 3;
        bookedHotelRoom6.bookingID = 103;
        bookedHotelRoom6.hotelID = 1;
        bookedHotelRoom6.date = new Date(2024 - 1900, 11, 27);
        bookedHotelRoom6.nights = 1;
        bookedHotelRoom6.roomNum = 106;
        bookedHotelRooms.add(bookedHotelRoom6);

        BookedHotelRoom bookedHotelRoom7 = new BookedHotelRoom();
        bookedHotelRoom7.roomID = 7;
        bookedHotelRoom7.userID = 4;
        bookedHotelRoom7.bookingID = 104;
        bookedHotelRoom7.hotelID = 2;
        bookedHotelRoom7.date = new Date(2024 - 1900, 11, 28);
        bookedHotelRoom7.nights = 2;
        bookedHotelRoom7.roomNum = 107;
        bookedHotelRooms.add(bookedHotelRoom7);

        BookedHotelRoom bookedHotelRoom8 = new BookedHotelRoom();
        bookedHotelRoom8.roomID = 8;
        bookedHotelRoom8.userID = 5;
        bookedHotelRoom8.bookingID = 105;
        bookedHotelRoom8.hotelID = 1;
        bookedHotelRoom8.date = new Date(2023 - 1900, 10, 15);
        bookedHotelRoom8.nights = 1;
        bookedHotelRoom8.roomNum = 108;
        bookedHotelRooms.add(bookedHotelRoom8);

        BookedHotelRoom bookedHotelRoom9 = new BookedHotelRoom();
        bookedHotelRoom9.roomID = 9;
        bookedHotelRoom9.userID = 2;
        bookedHotelRoom9.bookingID = 106;
        bookedHotelRoom9.hotelID = 2;
        bookedHotelRoom9.date = new Date(2022 - 1900, 9, 10);
        bookedHotelRoom9.nights = 2;
        bookedHotelRoom9.roomNum = 109;
        bookedHotelRooms.add(bookedHotelRoom9);

        BookedHotelRoom bookedHotelRoom10 = new BookedHotelRoom();
        bookedHotelRoom10.roomID = 10;
        bookedHotelRoom10.userID = 1;
        bookedHotelRoom10.bookingID = 107;
        bookedHotelRoom10.hotelID = 2;
        bookedHotelRoom10.date = new Date(2020 - 1900, 8, 5);
        bookedHotelRoom10.nights = 3;
        bookedHotelRoom10.roomNum = 110;
        bookedHotelRooms.add(bookedHotelRoom10);
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
