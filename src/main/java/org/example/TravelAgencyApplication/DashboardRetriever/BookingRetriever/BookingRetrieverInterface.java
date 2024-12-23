package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;

public class BookingRetrieverInterface {
    private EventBookingsRetriever eventRetriever;
    private HotelBookingsRetriever hotelRetriever;

    public BookingRetrieverInterface() {
        eventRetriever = new EventBookingsRetriever();
        hotelRetriever = new HotelBookingsRetriever();
    }

    //Events
    public ArrayList<EventBooking> retrieveAllEventBookings(int userID){
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveAllEventTickets(userID));
    }
    public ArrayList<EventBooking> retrieveUpcomingEventBookings(int userID){
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveArchivedOrUpcomingTickets(userID,false));
    }
    public ArrayList<EventBooking> retrieveArchivedEventBookings(int userID) {
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveArchivedOrUpcomingTickets(userID,true));
    }

    //Hotels
    public ArrayList<HotelBooking> retrieveAllHotelBookings(int userID){
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveAllHotelRooms(userID));
    }
    public ArrayList<HotelBooking> retrieveUpcomingHotelBookings(int userID){
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveArchivedOrUpcomingHotelRooms(userID,false));
    }
    public ArrayList<HotelBooking> retrieveArchivedHotelBookings(int userID) {
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveArchivedOrUpcomingHotelRooms(userID,true));
    }


}
