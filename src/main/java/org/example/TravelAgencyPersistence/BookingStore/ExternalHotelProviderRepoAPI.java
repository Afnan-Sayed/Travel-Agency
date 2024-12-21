package org.example.TravelAgencyPersistence.BookingStore;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;

import java.util.ArrayList;

public class ExternalHotelProviderRepoAPI {
    private ArrayList<HotelRoom> hotelRooms;
    public ExternalHotelProviderRepoAPI() {
        hotelRooms = new ArrayList<>();
        HotelRoom room1 = new HotelRoom();
        room1.roomID = 1;
        room1.roomType = "Single";
        room1.roomNumber = 101;
        room1.price = 100;
        room1.isBooked = false;
        hotelRooms.add(room1);

        HotelRoom room2 = new HotelRoom();
        room2.roomID = 2;
        room2.roomType = "Single";
        room2.roomNumber = 102;
        room2.price = 100;
        room2.isBooked = false;
        hotelRooms.add(room2);

        HotelRoom room3 = new HotelRoom();
        room3.roomID = 3;
        room3.roomType = "Double";
        room3.roomNumber = 201;
        room3.price = 200;
        room3.isBooked = false;
        hotelRooms.add(room3);

        HotelRoom room4 = new HotelRoom();
        room4.roomID = 4;
        room4.roomType = "Double";
        room4.roomNumber = 202;
        room4.price = 200;
        room4.isBooked = false;
        hotelRooms.add(room4);

        HotelRoom room5 = new HotelRoom();
        room5.roomID = 5;
        room5.roomType = "Family";
        room5.roomNumber = 301;
        room5.price = 500;
        room5.isBooked = false;
        hotelRooms.add(room5);

        HotelRoom room6 = new HotelRoom();
        room6.roomID = 6;
        room6.roomType = "Family";
        room6.roomNumber = 302;
        room6.price = 500;
        room6.isBooked = false;
        hotelRooms.add(room6);

        HotelRoom room7 = new HotelRoom();
        room7.roomID = 7;
        room7.roomType = "Family";
        room7.roomNumber = 303;
        room7.price = 500;
        room7.isBooked = false;
        hotelRooms.add(room7);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return hotelRooms;
    }
    public HotelRoom getHotelRoomByID(int roomID) {
        for (HotelRoom hotelRoom : hotelRooms) {
            if (hotelRoom.roomID == roomID) {
                return hotelRoom;
            }
        }
        return null;
    }
}
