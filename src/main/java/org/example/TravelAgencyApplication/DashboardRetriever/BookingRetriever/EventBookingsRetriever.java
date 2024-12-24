package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.EventPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.example.TravelAgencyPersistence.BookingStore.UserEventProvider.EventTicket;

import java.util.ArrayList;
import java.util.Date;

public class EventBookingsRetriever {
    private EventPortal portal;

    public EventBookingsRetriever() {
        portal = EventPortal.getInstance();
    }


    //retriever Logic
    public ArrayList<EventTicket> retrieveAllEventTickets(int userID) {
        return portal.getFilteredEventTickets(userID,

                null,null, null,null,
                null, null,null,
                null, null,
                null);
    }

    //filtered
    public ArrayList<EventTicket> retrieveArchivedOrUpcomingTickets(int userID,boolean archived) {
        ArrayList<EventTicket> eventBookings = retrieveAllEventTickets(userID);

        Date now = new Date();

        for (int i=0; i<eventBookings.size(); i++) {
            Event event = eventBookings.get(i).event;
            if (event.date.before(now) && !archived){
                eventBookings.remove(i--);
            }
            else if ((event.date.equals(now) || event.date.after(now)) && archived){
                eventBookings.remove(i--);
            }
        }
        return eventBookings;
    }//archived: true means past events, false means upcoming events


    //booking retriever
    public ArrayList<EventBooking> retrieveEventBookings(ArrayList<EventTicket> eventTickets){
        ArrayList<EventBooking> bookings = new ArrayList<>();
        while (!eventTickets.isEmpty()) {
            Event event = eventTickets.getFirst().event;
            int bookingID = eventTickets.getFirst().bookingID;
            ArrayList<EventTicketInfo> tickets = new ArrayList<>();
            for (int j=0; j<eventTickets.size(); j++) { //remove and put bookings with same ID in one booking
                if (eventTickets.get(j).bookingID == bookingID){
                    EventTicket ticket = eventTickets.remove(j--);
                    tickets.add(new EventTicketInfo(ticket.eventTicketID, ticket.ticketNum));
                }
            }
            bookings.add(new EventBooking(event,tickets));
            bookings.getLast().bookingID=bookingID;
        }
        return bookings;
    }

}
