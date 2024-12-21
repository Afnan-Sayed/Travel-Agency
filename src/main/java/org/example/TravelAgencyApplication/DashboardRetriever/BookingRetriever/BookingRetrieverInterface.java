package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
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

    //Events
    public ArrayList<EventBooking> retrieveAllEventBookings(){
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveAllEventTickets());
    }
    public ArrayList<EventBooking> retrieveUpcomingEventBookings(){
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveArchivedOrUpcomingTickets(false));
    }
    public ArrayList<EventBooking> retrieveArchivedEventBookings() {
        return eventRetriever.retrieveEventBookings(eventRetriever.retrieveArchivedOrUpcomingTickets(true));
    }

    //Hotels
    public ArrayList<HotelBooking> retrieveAllHotelBookings(){
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveAllHotelRooms());
    }
    public ArrayList<HotelBooking> retrieveUpcomingHotelBookings(){
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveArchivedOrUpcomingHotelRooms(false));
    }
    public ArrayList<HotelBooking> retrieveArchivedHotelBookings() {
        return hotelRetriever.retrieveHotelBookings(hotelRetriever.retrieveArchivedOrUpcomingHotelRooms(true));
    }


}
