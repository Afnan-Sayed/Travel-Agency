package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;
import java.util.Date;

public class EventBookingsRetriever {
    private int userID;
    private EventPortal portal;

    public EventBookingsRetriever(int userID) {
        this.userID = userID;
        portal = new EventPortal();
    }

    public ArrayList<EventTicket> retrieveEventBookings() {
        return portal.getEventTicketsByUserID(userID);
    }


    public ArrayList<EventTicket> retrieveEventBookings(boolean archived) {
        ArrayList<EventTicket> eventBookings = portal.getEventTicketsByUserID(userID);

        Date now = new Date();

        for (int i=0; i<eventBookings.size(); i++) {
            Event event = portal.getEventByID(eventBookings.get(i).eventID);
            if (event.date.before(now) && !archived){
                eventBookings.remove(i--);
            }
            else if (archived){
                eventBookings.remove(i--);
            }
        }
        return eventBookings;
    }//archived: true means past events, false means upcoming events

}
