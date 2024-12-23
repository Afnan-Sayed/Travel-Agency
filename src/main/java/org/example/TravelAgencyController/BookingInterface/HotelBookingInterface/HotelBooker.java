package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoomProvider;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoomProvider;

import java.util.Date;

public class HotelBooker {
    HotelRoomProvider hotelRoomProvider;
    BookedHotelRoomProvider bookedHotelRoomProvider;
    private static HotelBooker hotelBooker;
    private HotelBooker() {
    }
    public static HotelBooker getInstance() {
        if (hotelBooker == null) {
            hotelBooker = new HotelBooker();
        }
        return hotelBooker;
    }
    public boolean bookHotelRoom(int roomID, int userID, int bookingID, Hotel hotel, Date date, int nights) {
        BookedHotelRoom room = new BookedHotelRoom();
        room.roomID = roomID;
        room.userID = userID;
        room.bookingID = bookingID;
        room.hotel = hotel;
        room.date = date;
        room.nights = nights;
        return hotelRoomProvider.bookHotelRoom(room);
    }
    public boolean cancelBooking(int roomID, int userID, int bookingID, Hotel hotel, Date date, int nights) {
        BookedHotelRoom room = new BookedHotelRoom();
        room.roomID = roomID;
        room.userID = userID;
        room.bookingID = bookingID;
        room.hotel = hotel;
        room.date = date;
        room.nights = nights;
        return hotelRoomProvider.cancelBooking(room);
    }
}
