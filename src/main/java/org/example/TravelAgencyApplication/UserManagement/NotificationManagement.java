package org.example.TravelAgencyApplication.UserManagement;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Builder;
import org.example.TravelAgencyApplication.UserManagement.Registration.RegistrationTemplate;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.ArrayList;

public abstract class NotificationManagement
{
    protected Builder builder;
    protected UserProvider userProvider;

    public NotificationManagement()
    {
        this.builder = new Builder();
        this.userProvider = UserProvider.getInstance();
    }

    protected abstract ArrayList<String> handleSpecialCharReplacement(int userID);


    public final void sendNotification(int userID)
    {
        RegistrationTemplate template = new RegistrationTemplate();
        builder.makeNotification(template, handleSpecialCharReplacement(userID), userID);
    }
}