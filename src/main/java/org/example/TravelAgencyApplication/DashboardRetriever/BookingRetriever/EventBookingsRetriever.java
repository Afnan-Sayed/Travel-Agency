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
        portal = EventPortal.getInstance();
    }





    //retriever Logic
    public ArrayList<EventTicket> retrieveAllEventTickets() {
        return portal.getFilteredEventTickets(userID,

                null,null, null,null,
                null, null,null,
                null, null,
                null);
    }

    //filtered
    public ArrayList<EventTicket> retrieveArchivedOrUpcomingTickets(boolean archived) {
        ArrayList<EventTicket> eventBookings = retrieveAllEventTickets();

        Date now = new Date();

        for (int i=0; i<eventBookings.size(); i++) {
            Event event = eventBookings.get(i).event;
            if (event.date.before(now) && !archived){
                eventBookings.remove(i--);
            }
            else if (archived){
                eventBookings.remove(i--);
            }
        }
        return eventBookings;
    }//archived: true means past events, false means upcoming events


    //booking retriever
    public ArrayList<EventBooking> retrieveEventBookings(ArrayList<EventTicket> eventTickets){
        ArrayList<EventBooking> bookings = new ArrayList<>();
        for (int i=0; i<eventTickets.size(); i++) {
            Event event = eventTickets.get(i).event;
            ArrayList<EventTicketInfo> tickets = new ArrayList<>();
            for (int j=i+1; j<eventTickets.size(); j++) { //remove and put bookings with same ID in one booking
                if (eventTickets.get(j).bookingID == eventTickets.get(i).bookingID){
                    EventTicket ticket = eventTickets.remove(j--);
                    tickets.add(new EventTicketInfo(ticket.eventTicketID, ticket.ticketNum));
                }
            }
            bookings.add(new EventBooking(event,tickets));

        }
        return bookings;
    }

}
