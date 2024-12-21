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


    //retriever Logic
    public ArrayList<EventTicket> retrieveEventTickets() {
        return portal.getEventTicketsByUserID(userID);
    }

    public ArrayList<EventTicket> retrieveEventTickets(boolean archived) {
        ArrayList<EventTicket> eventBookings = retrieveEventTickets();

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



    public ArrayList<EventBooking> retrieveEventBookings(ArrayList<EventTicket> eventTickets){
        ArrayList<EventBooking> bookings = new ArrayList<>();
        for (int i=0; i<eventTickets.size(); i++) {
            Event event = portal.getEventByID(eventTickets.get(i).eventID);
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
