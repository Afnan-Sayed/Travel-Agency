package org.example.TravelAgencyApplication.BookingManagement.HotelBooking;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class HotelTemplate extends Template {
    public HotelTemplate() {
        super(1,"###");
        this.messages=new ArrayList<>();
        this.messages.add(0, "Hello, you have successfully booked a hotel room. Your booking ID is: "+getSpecialCharacter()+". Enjoy your stay!");
        this.messages.add(1, "مرحبًا ، لقد حجزت غرفة فندق بنجاح. رقم الحجز الخاص بك هو: "+getSpecialCharacter()+". استمتع بإقامتك!");
        this.messages.add(2, "Bonjour, vous avez réservé une chambre d'hôtel avec succès. Votre numéro de réservation est: "+getSpecialCharacter()+". Profitez de votre séjour!");
        this.messages.add(3, "Hallo, Sie haben erfolgreich ein Hotelzimmer gebucht. Ihre Buchungsnummer lautet: "+getSpecialCharacter()+". Genießen Sie Ihren Aufenthalt!");
    }
}
