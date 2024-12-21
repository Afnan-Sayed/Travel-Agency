package org.example.TravelAgencyApplication.BookingManagement.EventBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class EventCancellationTemplate extends Template {
    public EventCancellationTemplate() {
        super(11, "###");
        messages = new ArrayList<>();

        messages.add("Your ticket for event X has been cancelled.");
        messages.add("لقد تم إلغاء تذكرتك ل" + getSpecialCharacter() + ".");
        messages.add("Votre billet pour l'événement " + getSpecialCharacter() + " a été annulé.");
        messages.add("Ihr Ticket für Veranstaltung " + getSpecialCharacter() + " wurde storniert.");
    }
}
