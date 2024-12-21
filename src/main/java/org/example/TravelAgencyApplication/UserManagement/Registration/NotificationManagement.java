package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Builder;
import org.example.TravelAgencyApplication.UserManagement.Registration.Registration.RegistrationTemplate;
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
        int language;
        int notificationReceiverType;
        String receiver;

        language = userProvider.getPersonalInfoProvider()
                .getPersonalInfoByUserID(userID)
                .getLast()
                .getLanguageID();

        notificationReceiverType = userProvider.getPersonalInfoProvider()
                .getPersonalInfoByUserID(userID)
                .getLast()
                .getNotificationReceiverType();


        if (notificationReceiverType == 1)
        {
            receiver = userProvider.getCredentialsProvider()
                    .getCredentialsByUserID(userID)
                    .getEmail();
        }
        else if (notificationReceiverType == 2)
        {
            receiver = userProvider.getCredentialsProvider()
                    .getCredentialsByUserID(userID)
                    .getPhoneNumber();
        }
        else
        {
            throw new IllegalArgumentException("Receiver type is not supported");
        }

        RegistrationTemplate template = new RegistrationTemplate();
        builder.makeNotification(template, handleSpecialCharReplacement(userID), language,
                userID, receiver, notificationReceiverType);
    }
}