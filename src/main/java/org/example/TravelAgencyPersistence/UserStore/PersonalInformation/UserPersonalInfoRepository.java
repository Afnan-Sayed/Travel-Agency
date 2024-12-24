package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserPersonalInfoRepository
{

    private HashMap<Integer, ArrayList<UserPersonalInfo>> userMap;

    public UserPersonalInfoRepository() {
        userMap = new HashMap<>();
    }

    ////////////////////////////////////////////////////////////////////////
    //C
    public void addPersonalInfo(UserPersonalInfo userPersonalInfo)
    {
        int userID = userPersonalInfo.getUserId();
        if (userMap.containsKey(userID)) {
            throw new IllegalArgumentException("User's info already exists");
        }

        userMap.putIfAbsent(userID , new ArrayList<>());
        userMap.get(userID).add(userPersonalInfo);
    }

    //R
    //get Personal Info by userID
    public ArrayList<UserPersonalInfo> getPersonalInfoByUserID(int userId) {
        return userMap.get(userId);
    }


    //R
    //this returns each user with their personal info
    public HashMap<Integer, ArrayList<UserPersonalInfo>> getPersonalInfoOfAllUsers() {
        return userMap;
    }

    //U
    public void updatePersonalInfo(int userId, UserPersonalInfo newUserPersonalInfo)
    {
        checkUserExistence(userId);

        userMap.putIfAbsent(userId , new ArrayList<>());
        userMap.get(userId).add(newUserPersonalInfo);
    }

    private void checkUserExistence(int userId)
    {
        if (!userMap.containsKey(userId))
            throw new IllegalArgumentException("User ID not found");
    }
}