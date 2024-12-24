package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.HotelBooking.HotelBooker;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/hotels")
public class HotelBookerViewer {
    private static HotelBookerViewer hotelBookerViewer;
    HotelBooker hotelBooker;
    private HotelBookerViewer() {
    }
    public static HotelBookerViewer getInstance() {
        if (hotelBookerViewer == null) {
            hotelBookerViewer = new HotelBookerViewer();
        }
        return hotelBookerViewer;
    }
    @GetMapping("/book/{hotelID}")
    public boolean bookHotelRoom(@PathVariable Integer hotelID, @RequestParam Integer userID, @RequestParam Date date, @RequestParam Integer nights, @RequestParam Integer roomNumber, @RequestParam Integer bookingID) {
        return hotelBooker.bookHotelRoom(hotelID, roomNumber, userID, bookingID, date, nights);
    }
    @GetMapping("/cancel/{hotelID}")
    public boolean cancelHotelRoom(@PathVariable Integer hotelID, @RequestParam Integer userID, @RequestParam Integer bookingID) {
        return hotelBooker.cancelHotelRoom(userID, hotelID, bookingID);
    }
}
