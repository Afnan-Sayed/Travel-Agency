package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

public class HotelBookingFailureTemplate extends Template {
public HotelBookingFailureTemplate() {
        super(1,"###");
        this.messages.add(0, "Hello, your hotel booking in "+getSpecialCharacter()+" has failed. Please try again later.");
        this.messages.add(1, "مرحبًا ، فشل حجز الفندق الخاص بك في "+getSpecialCharacter()+" . يرجى المحاولة مرة أخرى في وقت لاحق.");
        this.messages.add(2, "Bonjour, votre réservation d'hôtel à "+getSpecialCharacter()+" a échoué. Veuillez réessayer plus tard.");
        this.messages.add(3, "Hallo, Ihre Hotelbuchung in "+getSpecialCharacter()+" ist fehlgeschlagen. Bitte versuchen Sie es später erneut.");
    }
}
