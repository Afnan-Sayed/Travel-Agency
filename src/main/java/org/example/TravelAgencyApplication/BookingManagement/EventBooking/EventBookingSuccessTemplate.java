package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class EventBookingSuccessTemplate extends Template {
    public EventBookingSuccessTemplate() {
        super(11, "###");
        messages = new ArrayList<>();

        messages.add("You have successfully booked a ticket for event X!");
        messages.add("لقد قمت بحجز تذكرة ل" + getSpecialCharacter() + "بنجاح!");
        messages.add("Vous avez réservé avec succès un billet pour l'événement " + getSpecialCharacter() + " !");
        messages.add("Sie haben erfolgreich ein Ticket für Veranstaltung " + getSpecialCharacter() + " gebucht!");
    }
}
