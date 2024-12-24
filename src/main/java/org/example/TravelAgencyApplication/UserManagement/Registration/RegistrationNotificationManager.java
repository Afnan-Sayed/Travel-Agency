package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyApplication.UserManagement.NotificationManagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistrationNotificationManager extends NotificationManagement
{
    @Override
    protected ArrayList<String> handleSpecialCharReplacement(int userID)
    {
        ArrayList<String> input = new ArrayList<>();
        String specialCharReplacement = userProvider.getPersonalInfoProvider()
                .getPersonalInfoByUserID(userID)
                .getLast()
                .getName();
        input.add(specialCharReplacement);
        return input;
    }
}