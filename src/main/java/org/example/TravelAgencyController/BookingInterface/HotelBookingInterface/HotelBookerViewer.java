package org.example.TravelAgencyController.BookingInterface.HotelBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.HotelBooking.HotelBooker;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/hotels")
public class HotelBookerViewer {
    private static HotelBookerViewer hotelBookerViewer;
    HotelBooker hotelBooker;
    private HotelBookerViewer() {
        hotelBooker = HotelBooker.getInstance();
    }
    public static HotelBookerViewer getInstance() {
        if (hotelBookerViewer == null) {
            hotelBookerViewer = new HotelBookerViewer();
        }
        return hotelBookerViewer;
    }
    @PostMapping("/book/{hotelID}")
    public boolean bookHotelRoom(@PathVariable Integer hotelID, @RequestParam Integer userID, @RequestParam String date, @RequestParam Integer nights, @RequestParam Integer roomNumber, @RequestParam Integer bookingID) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return hotelBooker.bookHotelRoom(hotelID, roomNumber, userID, bookingID, dateFormat.parse(date), nights);
    }
    @DeleteMapping("/cancel/{hotelID}")
    public boolean cancelHotelRoom(@PathVariable Integer hotelID, @RequestParam Integer userID, @RequestParam Integer bookingID) {
        return hotelBooker.cancelHotelRoom(userID, hotelID, bookingID);
    }
}
