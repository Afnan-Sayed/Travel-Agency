package org.example.TravelAgencyPersistence.UserStore.UserInformationProvider;

import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.AuthenticationCredentials;
import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.CredentialsProvider;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class AuthenticationCredentialsProvider
{
    private CredentialsProvider credentialsProvider;

    protected AuthenticationCredentialsProvider(CredentialsProvider credentialsProvider)
    {
        this.credentialsProvider = credentialsProvider;
    }

    //retrieves each user with their authentication credentials
    public HashMap<Integer, AuthenticationCredentials> getCredentialsOfAllUsers()
    {
        return credentialsProvider.getCredentialsOfAllUsers();
    }

    //gets credentials by user ID
    public AuthenticationCredentials getCredentialsByUserID(int userID)
    {
        return credentialsProvider.getCredentialsByUserID(userID);
    }

    //gets credentials by username
    public ArrayList<AuthenticationCredentials> getCredentialsByUsername(String username)
    {
        return credentialsProvider.getCredentialsByUsername(username);
    }

    //gets credentials by email
    public ArrayList<AuthenticationCredentials> getCredentialsByEmail(String email)
    {
        return credentialsProvider.getCredentialsByEmail(email);
    }

    //gets credentials by phone number
    public ArrayList<AuthenticationCredentials> getCredentialsByPhoneNumber(String phoneNumber)
    {
        return credentialsProvider.getCredentialsByPhoneNumber(phoneNumber);
    }

    // Add new credentials
    public void addCredentials(AuthenticationCredentials credentials)
    {
        credentialsProvider.addCredentials(credentials);
    }

    //update existing credentials
    public void updateCredentials(int userID, AuthenticationCredentials newCredentials)
    {
        credentialsProvider.updateCredentials(userID, newCredentials);
    }
}

