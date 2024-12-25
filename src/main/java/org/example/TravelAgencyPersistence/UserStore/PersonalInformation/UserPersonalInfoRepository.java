package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserPersonalInfoRepository
{

    private HashMap<Integer, ArrayList<UserPersonalInfo>> userMap;

    private static UserPersonalInfoRepository instance;
    public static UserPersonalInfoRepository getInstance() {
        if (instance == null) instance = new UserPersonalInfoRepository();
        return instance;

    }

    private UserPersonalInfoRepository() {
        userMap = new HashMap<>();
        //hardwired admin account
        UserPersonalInfo adminPersonalInfo = new UserPersonalInfo(1, "Admin", "A", "1-1-2000", 0, 3);
        userMap.putIfAbsent(1, new ArrayList<>());
        userMap.get(1).add(adminPersonalInfo);
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