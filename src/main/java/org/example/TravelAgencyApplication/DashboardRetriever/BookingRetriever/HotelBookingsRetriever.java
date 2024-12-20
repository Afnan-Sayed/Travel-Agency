package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class HotelBookingsRetriever {
    private int userID;
    private HotelPortal portal;

    public HotelBookingsRetriever(int userID) {
        this.userID = userID;
        portal = new HotelPortal();
    }

    //TODO public ArrayList<BookedHotelRoom> retrieveHotelBookings(){}

    //logic for reservation id, return an array of a reservation array of booked hotel rooms,
    // or just an array of hotel rooms


    //filter for archived and upcoming bookings
    //public ArrayList<EventTicket> retrieveHotelBookings(boolean archived) {}


}
