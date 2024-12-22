package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.AuthenticationCredentials;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;


//1. generate unique id and save user temporarily
//2. authenticate user
//3. change acc state
//4. notify him that he has successfully been registered

public class RegistrationMaker
{
    private Authenticator authenticator;
    private UserProvider userProvider;
    private RegistrationNotificationManager notificationManager;
    private IDGenerator idGenerator;

    //generate random id
    private int generateID()
    {
        int ID= idGenerator.generateID();
        return ID;
    }

    public RegistrationMaker()
    {
        notificationManager = new RegistrationNotificationManager();
        authenticator=new Authenticator();
        idGenerator=new IDGenerator();
        this.userProvider= userProvider.getInstance();
    }


    private int saveUserToDB(String username, String password,
                      String email, String phoneNumber,String name
                      , String address, String dateOfBirth, int LanguageID, int notificationReceiverType)
    {
        int userID= generateID();

        UserPersonalInfo personalInfo= new UserPersonalInfo(userID, name, address, dateOfBirth, LanguageID, notificationReceiverType);
        userProvider.getPersonalInfoProvider().addPersonalInfo(personalInfo);

        //user account status will be initialized to be not verified yet -> 0
        AuthenticationCredentials authCred=new AuthenticationCredentials(username, password, email, phoneNumber, userID, 0,false);
        userProvider.getCredentialsProvider().addCredentials(personalInfo, authCred);
        return userID;
    }

    public void registerUser(String username, String password, String email, String phoneNumber,String name, String address, String dateOfBirth, int LanguageID, int notificationReceiverType)
    {
        //1. generate unique id and save user temporarily
       int userID= saveUserToDB(username, password, email, phoneNumber, name, address, dateOfBirth, LanguageID, notificationReceiverType);

        //2. authenticate user
        if (authenticator.verifyUser(userID))
        {
            //3. change acc state to be verified
            userProvider.getCredentialsProvider().getCredentialsByUserID(userID).setAccountStatus(1);

            //4. notify him that he has successfully been registered
            notificationManager.sendNotification(userID);
        }

        else
            throw new IllegalArgumentException("Invalid registration data");
    }
}
