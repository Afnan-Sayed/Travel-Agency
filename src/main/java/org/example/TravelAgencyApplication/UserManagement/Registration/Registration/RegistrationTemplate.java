package org.example.TravelAgencyApplication.UserManagement.Registration.Registration;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class RegistrationTemplate extends Template
{
    public RegistrationTemplate()
    {
        super(2, "@@@");
        this.messages = new ArrayList<>();

        this.messages.add("Dear " + getSpecialCharacter() + ", Thank you for joining us! Start planning your next trip.");
        this.messages.add( "، شكراً لانضمامك إلينا! ابدأ بتخطيط رحلتك القادمة."+ getSpecialCharacter() +  "عزيزي/عزيزتي ");
        this.messages.add("Cher/Chère " + getSpecialCharacter() + ", Merci de nous avoir rejoints ! Commencez à planifier votre prochain voyage.");
        this.messages.add("Sehr geehrte/r " + getSpecialCharacter() + ", Vielen Dank, dass Sie sich uns angeschlossen haben! Beginnen Sie mit der Planung Ihrer nächsten Reise.");
    }
}