package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class EventBookingFailureTemplate extends Template {
    public EventBookingFailureTemplate() {
        super(2, "###");
        messages = new ArrayList<>();

        messages.add("The request to book event " + getSpecialCharacter() + " has failed.");
        messages.add("لقد فشل طلب حجز " + getSpecialCharacter() + ".");
        messages.add("la demande de réservation de l'événement " + getSpecialCharacter() + " a échoué.");
        messages.add("die Anfrage zur Buchung von Veranstaltung " + getSpecialCharacter() + " ist fehlgeschlagen.");
    }
}
