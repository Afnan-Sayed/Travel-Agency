package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Service;

@Service
//1. generate unique id and save user temporarily
//2. authenticate user
//3. notify him that he has successfully been registered

public class RegistrationMaker
{
    private Authenticator authenticator;
    private IUserProvider userProvider;
    private final UserSaver userSaver;
    private RegistrationNotificationManager notificationManager;


    public RegistrationMaker(UserSaver userSaver, IUserProvider userProvider, Authenticator authenticator,
                             RegistrationNotificationManager notificationManager)
    {
        this.userSaver = userSaver;
        this.authenticator=authenticator;
        this.userProvider= userProvider;
        this.notificationManager=notificationManager;
    }

    public Integer registerUser
            (
                    String username, String password,
                    String email, String phoneNumber,String name,
                    String address, String dateOfBirth, int LanguageID,
                    int notificationReceiverType
            )
    {
        Integer userID = userSaver.saveUserToDB(username, password, email,
                                            phoneNumber, name, address, dateOfBirth,
                                            LanguageID, notificationReceiverType);

        //2. authenticate user
        authenticator.sendVerificationCode(username);
        return userID;


    }
}