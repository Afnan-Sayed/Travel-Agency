package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import java.util.ArrayList;
import java.util.HashMap;

public class UserPersonalInfoRepository
{
    private HashMap<Integer, ArrayList<UserPersonalInfo>> userMap;

    private void checkNullUser(UserPersonalInfo userPersonalInfo) {
        if (userPersonalInfo == null)
            throw new IllegalArgumentException("User cannot be null");
    }

    private void checkUserExistence(int userId) {
        if (!userMap.containsKey(userId))
            throw new IllegalArgumentException("User ID not found");
    }

    public UserPersonalInfoRepository() {
        userMap = new HashMap<>();
    }

    ////////////////////////////////////////////////////////////////////////
    //C
    public void addPersonalInfo(UserPersonalInfo userPersonalInfo)
    {
        if (userMap.containsKey(userPersonalInfo.getUserId()))
            throw new IllegalArgumentException("User ID already exists");

        checkNullUser(userPersonalInfo);

        int userId = userPersonalInfo.getUserId();
        userMap.putIfAbsent(userId, new ArrayList<>());
        userMap.get(userId).add(userPersonalInfo);
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
    public void updatePersonalInfo(UserPersonalInfo newUserPersonalInfo)
    {
        checkNullUser(newUserPersonalInfo);

        int userId = newUserPersonalInfo.getUserId();
        checkUserExistence(userId);

        ArrayList<UserPersonalInfo> userInfoList = userMap.get(userId);

        if (!userInfoList.isEmpty())
        {
            UserPersonalInfo existingInfo = userInfoList.get(userInfoList.size() - 1);

            if (newUserPersonalInfo.getName() != null)
                existingInfo.setName(newUserPersonalInfo.getName());

            if (newUserPersonalInfo.getAddress() != null)
                existingInfo.setAddress(newUserPersonalInfo.getAddress());

            if (newUserPersonalInfo.getDateOfBirth() != null)
                existingInfo.setDateOfBirth(newUserPersonalInfo.getDateOfBirth());
        }
    }
}
