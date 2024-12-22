package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProviderRepoAPI;

import java.util.ArrayList;

public class AvailableHotelsViewer {
    private static AvailableHotelsViewer availableHotelsViewer;
    ExternalHotelProviderRepoAPI repo;
    private AvailableHotelsViewer() {
        repo = ExternalHotelProviderRepoAPI.getInstance();
    }
    public static AvailableHotelsViewer getInstance() {
        if (availableHotelsViewer == null) {
            availableHotelsViewer = new AvailableHotelsViewer();
        }
        return availableHotelsViewer;
    }
    public ArrayList<Hotel> getAvailableHotels() {
        return repo.getAllHotels();
    }

}
