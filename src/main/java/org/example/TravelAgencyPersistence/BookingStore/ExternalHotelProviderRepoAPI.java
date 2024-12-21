package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;

import java.util.ArrayList;

public class ExternalHotelProviderRepoAPI {
    private ArrayList<Hotel> hotels;
    public ExternalHotelProviderRepoAPI() {
        hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.hotelID = 1;
        hotel1.hotelName = "Hotel1";
        hotel1.latitude = 1.0;
        hotel1.longitude = 1.0;
        hotel1.rating = 4.5;
        hotel1.description = "Hotel1 description";
        hotel1.rooms = new ArrayList<>();

        HotelRoom room1 = new HotelRoom();
        room1.roomID = 1;
        room1.roomType = "Single";
        room1.roomNumber = 1;
        room1.price = 100;
        room1.isBooked = false;
        room1.hotel = hotel1;
        hotel1.rooms.add(room1);

        HotelRoom room2 = new HotelRoom();
        room2.roomID = 2;
        room2.roomType = "Double";
        room2.roomNumber = 2;
        room2.price = 200;
        room2.isBooked = false;
        room2.hotel = hotel1;
        hotel1.rooms.add(room2);

        HotelRoom room3 = new HotelRoom();
        room3.roomID = 3;
        room3.roomType = "Single";
        room3.roomNumber = 3;
        room3.price = 100;
        room3.isBooked = false;
        room3.hotel = hotel1;
        hotel1.rooms.add(room3);

        hotels.add(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.hotelID = 2;
        hotel2.hotelName = "Hotel2";
        hotel2.latitude = 2.0;
        hotel2.longitude = 2.0;
        hotel2.rating = 4.0;
        hotel2.description = "Hotel2 description";
        hotel2.rooms = new ArrayList<>();

        room1 = new HotelRoom();
        room1.roomID = 4;
        room1.roomType = "Single";
        room1.roomNumber = 1;
        room1.price = 100;
        room1.isBooked = false;
        room1.hotel = hotel2;
        hotel2.rooms.add(room1);

        room2 = new HotelRoom();
        room2.roomID = 5;
        room2.roomType = "Double";
        room2.roomNumber = 2;
        room2.price = 200;
        room2.isBooked = false;
        room2.hotel = hotel2;
        hotel2.rooms.add(room2);

        room3 = new HotelRoom();
        room3.roomID = 6;
        room3.roomType = "Single";
        room3.roomNumber = 3;
        room3.price = 100;
        room3.isBooked = false;
        room3.hotel = hotel2;
        hotel2.rooms.add(room3);

        hotels.add(hotel2);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        ArrayList<HotelRoom> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            result.addAll(hotel.rooms);
        }
        return result;
    }
    public ArrayList<HotelRoom> getHotelRoomsByHotelID(int hotelID) {
        for (Hotel hotel : hotels) {
            if (hotel.hotelID == hotelID) {
                return hotel.rooms;
            }
        }
        return null;
    }
}
