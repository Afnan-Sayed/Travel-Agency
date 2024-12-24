package org.example.TravelAgencyPersistence.UserStore.UserInformationProvider;

import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.AuthenticationCredentials;
import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.CredentialsProvider;
import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.CredentialsRepository;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoProvider;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserProvider implements IUserProvider
{
    private static UserProvider provider;
    private final AuthenticationCredentialsProvider authProvider;
    private final PersonalInfoProvider perProvider;

    private UserProvider()
    {
        CredentialsRepository CredRepo = new CredentialsRepository();
        UserPersonalInfoRepository PerRepo = new UserPersonalInfoRepository();

        CredentialsProvider CP = new CredentialsProvider(CredRepo);
        UserPersonalInfoProvider PP = new UserPersonalInfoProvider(PerRepo);

        authProvider = new AuthenticationCredentialsProvider(CP);
        perProvider = new PersonalInfoProvider(PP);
    }

    @Override
    public AuthenticationCredentialsProvider getCredentialsProvider() {
        return authProvider;
    }

    @Override
    public PersonalInfoProvider getPersonalInfoProvider()
    {
        return perProvider;
    }

    @Override
    public void updateAccountStatusByUsername(String username, int status)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUsername(username).get(0);
        credentials.setAccountStatus(status);
        authProvider.updateCredentials(credentials.getUserID(), credentials);
    }
    @Override
    public void updateAccountStatusByID(int id, int status)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUserID(id);
        credentials.setAccountStatus(status);
        authProvider.updateCredentials(credentials.getUserID(), credentials);
    }


    @Override
    public int getAccountStatusByUsername(String username)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUsername(username).get(0); // Assuming unique username
        return credentials.getAccountStatus();
    }


    @Override
    public int getUserIDByUsername(String username)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUsername(username).get(0); // Assuming unique username
        return credentials.getUserID();
    }


    @Override
    public boolean doesUserExist(String username)
    {
        return !authProvider.getCredentialsByUsername(username).isEmpty();
    }


    @Override
    public String getEmailByUserID(int userID)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUserID(userID);
        return credentials.getEmail();
    }


    @Override
    // Get phone number by userID
    public String getPhoneNumberByUserID(int userID)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUserID(userID);
        return credentials.getPhoneNumber();
    }


    @Override
    // Get language ID by userID
    public int getLanguageIDByUserID(int userID)
    {
        ArrayList<UserPersonalInfo> info = perProvider.getPersonalInfoByUserID(userID);
        return info.getFirst().getLanguageID();
    }


    @Override
    // Get password by username
    public String getPasswordByUsername(String username)
    {
        ArrayList<AuthenticationCredentials> credentials = authProvider.getCredentialsByUsername(username);
        return credentials.getFirst().getPassword();
    }

    @Override
    // Get notification receiver type by userID
    public int getNotificationReceiverTypeByUserID(int userID)
    {
        ArrayList<UserPersonalInfo> credentials = perProvider.getPersonalInfoByUserID(userID);
        return credentials.getFirst().getNotificationReceiverType();
    }

    @Override
    public void addAuthenticationCredentials(String username, String password, String email,String phoneNumber,
                                             int userID, int userAccountStatus, boolean isAdmin)
    {
        AuthenticationCredentials authCred = new AuthenticationCredentials(
                username, password, email, phoneNumber, userID, userAccountStatus, isAdmin
        );
        authProvider.addCredentials(authCred);
    }

    @Override
    public void addPersonalInfo(int userId, String name, String address,
                                String dateOfBirth, int LanguageID,
                                int notificationReceiverType)
    {
        UserPersonalInfo personalInfo = new UserPersonalInfo(
                userId, name, address, dateOfBirth, LanguageID, notificationReceiverType
        );

        perProvider.addPersonalInfo(personalInfo);
    }

    @Override
    public void updatePassByID(int id, String newPass)
    {
        AuthenticationCredentials credentials = authProvider.getCredentialsByUserID(id);
        credentials.setPassword(newPass);
        authProvider.updateCredentials(credentials.getUserID(), credentials);
    }
    public static synchronized UserProvider getInstance()
    {
        if (provider == null)
            provider = new UserProvider();
        return provider;
    }
}