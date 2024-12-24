package org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider;
import org.example.TravelAgencyPersistence.BookingStore.BookedHotelRoomRepo;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProviderRepoAPI;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelRoomProvider {
    private static HotelRoomProvider hotelRoomProvider;
    private ExternalHotelProviderRepoAPI repo;
    private HotelRoomProvider() {
        repo = ExternalHotelProviderRepoAPI.getInstance();
    }
    public static HotelRoomProvider getInstance() {
        if (hotelRoomProvider == null) {
            hotelRoomProvider = new HotelRoomProvider();
        }
        return hotelRoomProvider;
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return repo.getAllHotelRooms();
    }
    public ArrayList<Hotel> getAllHotels() {
        return repo.getAllHotels();
    }
    public boolean bookHotelRoom(BookedHotelRoom hotelRoom) {
        return repo.bookHotelRoom(hotelRoom);
    }
    public boolean cancelBooking(BookedHotelRoom hotelRoom) {
        return repo.cancelBooking(hotelRoom);
    }
    public Predicate<HotelRoom> getHotelRoomByRoomID(int roomID) {
        return hotelRoom -> hotelRoom.roomID == roomID;
    }
    public Predicate<HotelRoom> getHotelRoomByRoomType(String roomType) {
        return hotelRoom -> Objects.equals(hotelRoom.roomType, roomType);
    }
    public Predicate<HotelRoom> getHotelRoomByRoomNumber(int roomNumber) {
        return hotelRoom -> hotelRoom.roomNumber == roomNumber;
    }
    public Predicate<HotelRoom> getHotelRoomByPrice(int price) {
        return hotelRoom -> hotelRoom.price == price;
    }
    public Predicate<HotelRoom> getHotelRoomByIsBooked(boolean isBooked) {
        return hotelRoom -> hotelRoom.isBooked == isBooked;
    }
    public Predicate<HotelRoom> getHotelRoomByHotelID(int hotelID) {
        return hotelRoom -> hotelRoom.hotelID == hotelID;
    }
    public ArrayList<HotelRoom> getFilteredHotelRooms(Integer roomID, String roomType, Integer roomNumber, Integer price, Boolean isBooked, Integer hotelID) {
        ArrayList<Predicate<HotelRoom>> filters = new ArrayList<>();
        if (roomID != null) {
            filters.add(getHotelRoomByRoomID(roomID));
        }
        if (roomType != null) {
            filters.add(getHotelRoomByRoomType(roomType));
        }
        if (roomNumber != null) {
            filters.add(getHotelRoomByRoomNumber(roomNumber));
        }
        if (price != null) {
            filters.add(getHotelRoomByPrice(price));
        }
        if (isBooked != null) {
            filters.add(getHotelRoomByIsBooked(isBooked));
        }
        if (hotelID != null) {
            filters.add(getHotelRoomByHotelID(hotelID));
        }
        return (ArrayList<HotelRoom>) repo.getAllHotelRooms()
                .stream()
                .filter(filters.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
    }
}
