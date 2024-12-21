package org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProviderRepoAPI;

import java.util.ArrayList;

public class HotelRoomProvider {
    private ExternalHotelProviderRepoAPI repo;
    public HotelRoomProvider() {
        repo = new ExternalHotelProviderRepoAPI();
    }
    public ArrayList<HotelRoom> getHotelRoomsByHotelID(int roomID) {
        return repo.getHotelRoomsByHotelID(roomID);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return repo.getAllHotelRooms();
    }
}
