package org.example.TravelAgencyApplication.UserManagement;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Builder;
import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
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


    public final void sendNotification(Template template,int userID)
    {
        builder.makeNotification(template, handleSpecialCharReplacement(userID), userID);
    }
}