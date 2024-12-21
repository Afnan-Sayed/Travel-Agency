package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.util.ArrayList;

public class AuthenticationTemplate extends Template
{
    public AuthenticationTemplate()
    {
        super(1, "###");
        this.messages = new ArrayList<>();

        this.messages.add("Enter the following verification code - Code: " + getSpecialCharacter());
        this.messages.add(getSpecialCharacter()+ "أدخل رمز التحقق التالي  - الرمز: " );
        this.messages.add("Entrez le code de vérification suivant - Code: " + getSpecialCharacter());
        this.messages.add("Geben Sie den folgenden Bestätigungscode ein - Code: " + getSpecialCharacter());
    }
}