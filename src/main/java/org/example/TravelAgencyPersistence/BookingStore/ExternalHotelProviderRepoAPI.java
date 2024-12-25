package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class ExternalHotelProviderRepoAPI {
    private static ExternalHotelProviderRepoAPI externalHotelProviderRepoAPI;
    private ArrayList<Hotel> hotels;
    private ExternalHotelProviderRepoAPI() {
        hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.hotelID = 1;
        hotel1.hotelName = "Cairo Hotel";
        hotel1.latitude = 30.0444;
        hotel1.longitude = 31.2357;
        hotel1.rating = 4.5;
        hotel1.description = "Hotel in Cairo";
        hotel1.rooms = new ArrayList<>();

        HotelRoom room1 = new HotelRoom();
        room1.roomID = 1;
        room1.roomType = "Single";
        room1.roomNumber = 1;
        room1.price = 110;
        room1.isBooked = false;
        room1.hotelID = hotel1.hotelID;
        hotel1.rooms.add(room1);

        HotelRoom room2 = new HotelRoom();
        room2.roomID = 2;
        room2.roomType = "Double";
        room2.roomNumber = 2;
        room2.price = 200;
        room2.isBooked = false;
        room2.hotelID = hotel1.hotelID;
        hotel1.rooms.add(room2);

        HotelRoom room3 = new HotelRoom();
        room3.roomID = 3;
        room3.roomType = "Single";
        room3.roomNumber = 3;
        room3.price = 80;
        room3.isBooked = false;
        room3.hotelID = hotel1.hotelID;
        hotel1.rooms.add(room3);

        hotels.add(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.hotelID = 2;
        hotel2.hotelName = "Giza Hotel";
        hotel2.latitude = 29.9770;
        hotel2.longitude = 31.1330;
        hotel2.rating = 4.0;
        hotel2.description = "Hotel in Giza";
        hotel2.rooms = new ArrayList<>();

        room1 = new HotelRoom();
        room1.roomID = 4;
        room1.roomType = "Single";
        room1.roomNumber = 1;
        room1.price = 120;
        room1.isBooked = false;
        room1.hotelID = hotel2.hotelID;
        hotel2.rooms.add(room1);

        room2 = new HotelRoom();
        room2.roomID = 5;
        room2.roomType = "Double";
        room2.roomNumber = 2;
        room2.price = 250;
        room2.isBooked = false;
        room2.hotelID = hotel2.hotelID;
        hotel2.rooms.add(room2);

        room3 = new HotelRoom();
        room3.roomID = 6;
        room3.roomType = "Single";
        room3.roomNumber = 3;
        room3.price = 100;
        room3.isBooked = false;
        room3.hotelID = hotel2.hotelID;
        hotel2.rooms.add(room3);

        hotels.add(hotel2);
    }
    public static ExternalHotelProviderRepoAPI getInstance() {
        if (externalHotelProviderRepoAPI == null) {
            externalHotelProviderRepoAPI = new ExternalHotelProviderRepoAPI();
        }
        return externalHotelProviderRepoAPI;
    }
    public ArrayList<Hotel> getAllHotels(){
        return hotels;
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        ArrayList<HotelRoom> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            result.addAll(hotel.rooms);
        }
        return result;
    }
    public boolean bookHotelRoom(BookedHotelRoom hotelRoom) {
        for (Hotel hotel : hotels) {
            for (HotelRoom room : hotel.rooms) {
                if (room.roomID == hotelRoom.roomID && !room.isBooked) {
                    room.isBooked = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean cancelBooking(BookedHotelRoom hotelRoom) {
        for (Hotel hotel : hotels) {
            for (HotelRoom room : hotel.rooms) {
                if (room.roomID == hotelRoom.roomID && room.isBooked) {
                    room.isBooked = false;
                    return true;
                }
            }
        }
        return false;
    }
}
