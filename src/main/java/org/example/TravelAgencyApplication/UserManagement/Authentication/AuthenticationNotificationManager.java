package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyApplication.UserManagement.NotificationManagement;

import java.util.ArrayList;

public class AuthenticationNotificationManager extends NotificationManagement
{
    private Authenticator authenticator;
    public AuthenticationNotificationManager()
    {
        this.authenticator=new Authenticator();
    }
    @Override
    protected ArrayList<String> handleSpecialCharReplacement(int userID)
    {
        ArrayList<String> input = new ArrayList<>();
        String specialCharReplacement = authenticator.generateVerificationCode();
        input.add(specialCharReplacement);
        return input;
    }
}