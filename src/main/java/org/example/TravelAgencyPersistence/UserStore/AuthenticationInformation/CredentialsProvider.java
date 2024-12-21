package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;

import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

//ASSOCIATION WITH CredentialsRepository CLASS
//DEPENDENCY WITH AuthenticationCredentials CLASS
//DEPENDENCY WITH USER CLASS

public class CredentialsProvider
{
    private CredentialsRepository credentialsRepo;
    private UserPersonalInfoRepository personalInfoRepo;

    //constructor
    public CredentialsProvider(CredentialsRepository credentialsRepo, UserPersonalInfoRepository personalInfoRepo)
    {
        this.credentialsRepo = credentialsRepo;
        this.personalInfoRepo = personalInfoRepo;
    }


    //retrieves each user with their authentication credentials
    public HashMap<Integer, AuthenticationCredentials> getCredentialsOfAllUsers()
    {
        return credentialsRepo.getCredentialsOfAllUsers();
    }

    //gets credentials by user ID
    public AuthenticationCredentials getCredentialsByUserID(int userID)
    {
        return credentialsRepo.getCredentialsByUserID(userID);
    }

    //gets credentials by username
    public ArrayList<AuthenticationCredentials> getCredentialsByUsername(String username)
    {
        return getCredentialsOfAllUsers()
                .values()
                .stream()
                .filter(credentials -> credentials.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    //gets credentials by email
    public ArrayList<AuthenticationCredentials> getCredentialsByEmail(String email)
    {
        return getCredentialsOfAllUsers()
                .values()
                .stream()
                .filter(credentials -> credentials.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //gets credentials by phone number
    public ArrayList<AuthenticationCredentials> getCredentialsByPhoneNumber(String phoneNumber)
    {
        return getCredentialsOfAllUsers()
                .values()
                .stream()
                .filter(credentials -> credentials.getPhoneNumber().equalsIgnoreCase(phoneNumber))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Add new credentials
    public void addCredentials(UserPersonalInfo userPersonalInfo, AuthenticationCredentials credentials)
    {
        credentialsRepo.addCredentials(userPersonalInfo, credentials);
    }

    //update existing credentials
    public void updateCredentials(UserPersonalInfo userPersonalInfo, AuthenticationCredentials newCredentials)
    {
        credentialsRepo.updateCredentials(userPersonalInfo, newCredentials);
    }

    //assume cannot be deleted
    //delete credentials by user
//    public void deleteCredentials(UserPersonalInfo userPersonalInfo)
//    {
//        credentialsRepo.deleteCredentials(userPersonalInfo);
//    }
}