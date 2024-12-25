package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;

import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class CredentialsRepository
{
    private HashMap<Integer, AuthenticationCredentials> credentialsMap;

    private static CredentialsRepository instance;
    public static CredentialsRepository getInstance() {
        if (instance == null) instance = new CredentialsRepository();
        return instance;
    }

    private CredentialsRepository() {
        credentialsMap = new HashMap<>();
        //hardwired admin account
        AuthenticationCredentials adminCredentials = new AuthenticationCredentials("admin", "admin", "admin@gmail.com", "010", 1, 1, true);
        credentialsMap.put(1, adminCredentials);
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