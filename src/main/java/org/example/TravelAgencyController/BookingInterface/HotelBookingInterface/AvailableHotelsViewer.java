package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.HotelBooking.HotelRetriever;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.HotelRoom;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotels")
public class AvailableHotelsViewer {
    private static AvailableHotelsViewer availableHotelsViewer;
    private HotelRetriever hotelRetriever;
    private AvailableHotelsViewer() {
        hotelRetriever = HotelRetriever.getInstance();
    }
    public static AvailableHotelsViewer getInstance() {
        if (availableHotelsViewer == null) {
            availableHotelsViewer = new AvailableHotelsViewer();
        }
        return availableHotelsViewer;
    }
    @GetMapping({"","/"})
    public ArrayList<Hotel> getAllHotels() {
        return hotelRetriever.getAllHotels();
    }
    @GetMapping("/{hotelID}")
    public Hotel getHotelByID(@PathVariable Integer hotelID) {
        return hotelRetriever.getHotelByID(hotelID);
    }
    @GetMapping("/search")
    public ArrayList<HotelRoom> getFilteredHotelRooms(@RequestParam Integer roomID,@RequestParam String roomType,@RequestParam Integer roomNumber,@RequestParam Integer price,@RequestParam Boolean isBooked,@RequestParam Hotel hotel) {
        return hotelRetriever.getFilteredHotelRooms(roomID, roomType, roomNumber, price, isBooked, hotel);
    }
}
