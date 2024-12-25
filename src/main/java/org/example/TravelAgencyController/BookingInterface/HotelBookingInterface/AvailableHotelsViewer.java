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
    public ArrayList<HotelRoom> getFilteredHotelRooms(@RequestParam(required = false) Integer roomID,
                                                      @RequestParam(required = false) String roomType,
                                                      @RequestParam(required = false) Integer roomNumber,
                                                      @RequestParam(required = false) Integer minPrice,
                                                      @RequestParam(required = false) Integer maxPrice,
                                                      @RequestParam(required = false) Boolean isBooked,
                                                      @RequestParam(required = false) Integer hotelID) {
        return hotelRetriever.getFilteredHotelRooms(roomID, roomType, roomNumber, minPrice, maxPrice, isBooked, hotelID);
    }
}
