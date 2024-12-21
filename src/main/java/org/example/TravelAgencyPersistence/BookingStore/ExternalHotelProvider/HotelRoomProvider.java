package org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProviderRepoAPI;

import java.util.ArrayList;

public class HotelRoomProvider {
    private ExternalHotelProviderRepoAPI repo;
    public HotelRoomProvider() {
        repo = new ExternalHotelProviderRepoAPI();
    }
    public HotelRoom getHotelRoomByID(int roomID) {
        return repo.getHotelRoomByID(roomID);
    }
    public ArrayList<HotelRoom> getAllHotelRooms() {
        return repo.getAllHotelRooms();
    }
}
