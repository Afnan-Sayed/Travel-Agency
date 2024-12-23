package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

public class HotelBookingCancellationTemplate extends Template {
    public HotelBookingCancellationTemplate() {
        super(1,"###");
        this.messages.add(0, "Hello, your hotel booking in "+getSpecialCharacter()+" has been cancelled. We hope to see you again soon.");
        this.messages.add(1, "مرحبًا ، تم إلغاء حجز الفندق الخاص بك في "+getSpecialCharacter()+" . نأمل أن نراك مرة أخرى قريبًا.");
        this.messages.add(2, "Bonjour, votre réservation d'hôtel à "+getSpecialCharacter()+" a été annulée. Nous espérons vous revoir bientôt.");
        this.messages.add(3, "Hallo, Ihre Hotelbuchung in "+getSpecialCharacter()+" wurde storniert. Wir hoffen, Sie bald wiederzusehen.");
    }
}
