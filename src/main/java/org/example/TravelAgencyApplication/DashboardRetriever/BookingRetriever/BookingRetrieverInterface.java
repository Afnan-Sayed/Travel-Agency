package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class BookingRetrieverInterface {
    private EventBookingsRetriever eventRetriever;
    private HotelBookingsRetriever hotelRetriever;

    public BookingRetrieverInterface(int userID) {
        eventRetriever = new EventBookingsRetriever(userID);
        hotelRetriever = new HotelBookingsRetriever(userID);
    }

    public ArrayList<EventTicket> retrieveTickets(){
        return eventRetriever.retrieveEventBookings();
    }

    public ArrayList<EventTicket> retrieveTickets(boolean archived){ //true => past events, false => upcoming events
        return eventRetriever.retrieveEventBookings(archived);
    }

//    public ArrayList<BookedHotelRoom> retrieveHotelRooms(){
//        return hotelRetriever.retrieveHotelBookings();
//    }

}
