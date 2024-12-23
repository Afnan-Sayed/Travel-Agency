package org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;

import java.util.ArrayList;
import java.util.Date;

public class BookedHotelRoom {
        public int roomID;
        public int userID;
        public int bookingID;
        public Hotel hotel;
        public Date date;
        public int nights;
        public int roomNum;
}
