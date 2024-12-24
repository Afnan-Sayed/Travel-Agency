package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Service;

@Service
public class UserSaver
{
    private final IUserProvider userProvider;
    private final IDGenerator idGenerator;

    public UserSaver(UserProvider userProvider, IDGenerator idGenerator)
    {
        this.userProvider = userProvider;
        this.idGenerator = idGenerator;
    }

    //generate random id
    private int generateID()
    {
        int ID= idGenerator.generateID();
        return ID;
    }
    public int saveUserToDB(String username, String password, String email,
                            String phoneNumber,String name, String address, String dateOfBirth,
                             int LanguageID, int notificationReceiverType)
    {
        int userID= generateID();

        userProvider.addPersonalInfo(userID, name, address, dateOfBirth,
                LanguageID, notificationReceiverType);

        //user account status will be initialized to be not verified yet -> 0
        userProvider.addAuthenticationCredentials(username, password, email, phoneNumber,
                userID, 0,false);
        return userID;
    }
}