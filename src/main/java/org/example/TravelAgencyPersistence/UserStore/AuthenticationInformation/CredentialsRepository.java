package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;

import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class CredentialsRepository
{
    private HashMap<Integer, AuthenticationCredentials> credentialsMap;

    public CredentialsRepository()
    {
        credentialsMap = new HashMap<>();
    }

    public void addCredentials(AuthenticationCredentials credentials)
    {
        int userID = credentials.getUserID();
        if (credentialsMap.containsKey(userID))
        {
            throw new IllegalArgumentException("Credentials for this UserID already exist");
        }
        credentialsMap.put(userID, credentials);
    }

    public HashMap<Integer, AuthenticationCredentials> getCredentialsOfAllUsers()
    {
        return credentialsMap;
    }

    public AuthenticationCredentials getCredentialsByUserID(int userID)
    {
        checkUserExistence(userID);
        return credentialsMap.get(userID);
    }

    public void updateCredentials(int userId, AuthenticationCredentials newCredentials)
    {
        checkUserExistence(userId);
        credentialsMap.put(userId, newCredentials);
    }

    private void checkUserExistence(int userId)
    {
        if (!credentialsMap.containsKey(userId))
            throw new IllegalArgumentException("User ID not found");
    }
}