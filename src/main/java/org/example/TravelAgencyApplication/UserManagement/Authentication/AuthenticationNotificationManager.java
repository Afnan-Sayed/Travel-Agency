package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyApplication.UserManagement.NotificationManagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
//INHERITANCE WITH NotificationManagement
//ASSOCIATION WITH Authenticator
public class AuthenticationNotificationManager extends NotificationManagement
{
    private Authenticator authenticator;
    public AuthenticationNotificationManager() {}
    @Override
    protected ArrayList<String> handleSpecialCharReplacement(int userID)
    {
        ArrayList<String> input = new ArrayList<>();
        String specialCharReplacement = authenticator.generateVerificationCode();
        input.add(specialCharReplacement);
        return input;
    }
}