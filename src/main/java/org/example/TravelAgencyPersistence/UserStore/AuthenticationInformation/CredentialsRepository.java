package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;

import java.util.HashMap;

//DEPENDENCY WITH UserPersonalInfo CLASS
//DEPENDENCY WITH AuthenticationCredentials CLASS

public class CredentialsRepository
{
    public HashMap<Integer, AuthenticationCredentials> credentialsMap;
    private void checkNullUser (UserPersonalInfo userPersonalInfo)
    {
        if (userPersonalInfo == null)
            throw new IllegalArgumentException("User cannot be null");
    }
    private void checkUserExistence (int userId)
    {
        if (!credentialsMap.containsKey(userId))
            throw new IllegalArgumentException("User ID not found");
    }
/////////////////////////////////////////////////////////////////////////////////

    //constructor
    public CredentialsRepository()
    {
        credentialsMap = new HashMap<>();
    }

    //C
    public void addCredentials(UserPersonalInfo userPersonalInfo, AuthenticationCredentials credentials)
    {
        checkNullUser (userPersonalInfo);
        int userId = userPersonalInfo.getUserId();

        if (credentialsMap.containsKey(userId))
            throw new IllegalArgumentException("Credentials for this UserID already exist");

        //ensure userId in credentials matches "join condition"
        if (credentials.userID != userId)
            throw new IllegalArgumentException
                    ("mismatch between UserID in AuthenticationCredentials and UserPersonalInfo");

        credentialsMap.put(userId, credentials);
    }

    //R
    //this returns each user with their authentication credentials
    public HashMap<Integer, AuthenticationCredentials> getCredentialsOfAllUsers()
    {
        return credentialsMap;
    }

    //R
    //get credentials by userID
    public AuthenticationCredentials getCredentialsByUserID(int userID)
    {
        checkUserExistence(userID);
        return credentialsMap.get(userID);
    }

    //U
    public void updateCredentials(UserPersonalInfo userPersonalInfo, AuthenticationCredentials newCredentials)
    {
        checkNullUser (userPersonalInfo);

        int userId = userPersonalInfo.getUserId();

        checkUserExistence (userId);

        AuthenticationCredentials existingCredentials = credentialsMap.get(userId);

        //ensure userId consistency if it's being updated
        if (newCredentials.userID != 0 && newCredentials.userID != userId)
            throw new IllegalArgumentException("Cannot update userId to a different value");

        if (newCredentials.username != null)
            existingCredentials.username = newCredentials.username;

        if (newCredentials.password != null)
            existingCredentials.password = newCredentials.password;

        if (newCredentials.email != null)
            existingCredentials.email = newCredentials.email;
    }


    //assume cannot be deleted
    //D
//    public void deleteCredentials(UserPersonalInfo userPersonalInfo)
//    {
//        checkNullUser (userPersonalInfo);
//
//        int userId = userPersonalInfo.userId;
//
//        checkUserExistence (userId);
//        credentialsMap.remove(userId);
//    }
}