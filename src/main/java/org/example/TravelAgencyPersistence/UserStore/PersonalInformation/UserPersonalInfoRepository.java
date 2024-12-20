package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import java.util.HashMap;

public class UserPersonalInfoRepository
{
    private HashMap<Integer, UserPersonalInfo> userMap;
    private void checkNullUser (UserPersonalInfo userPersonalInfo)
    {
        if (userPersonalInfo == null)
            throw new IllegalArgumentException("User cannot be null");
    }
    private void checkUserExistence (int userId)
    {
        if (!userMap.containsKey(userId))
            throw new IllegalArgumentException("User ID not found");
    }
    public UserPersonalInfoRepository()
    {
        userMap = new HashMap<>();
    }
////////////////////////////////////////////////////////////////////////
    //C
    public void addPersonalInfo(UserPersonalInfo userPersonalInfo)
    {
        if (userMap.containsKey(userPersonalInfo.getUserId()))
             throw new IllegalArgumentException("User ID already exists");

         userMap.put(userPersonalInfo.getUserId(), userPersonalInfo);
    }

    //R
    //get Personal Info by userID
    public UserPersonalInfo getPersonalInfoByUserID(int userId)
    {
        return userMap.get(userId);
    }

    //R
    //this returns each user with their personal info
    public HashMap<Integer, UserPersonalInfo> getPersonalInfoOfAllUsers()
    {
        return userMap;
    }

    //U
    public void updatePersonalInfo (UserPersonalInfo newuserPersonalInfo)
    {
        checkNullUser (newuserPersonalInfo);

        int userId = newuserPersonalInfo.getUserId();

        checkUserExistence (userId);

        UserPersonalInfo existingInfo = userMap.get(userId);

        if (newuserPersonalInfo.getName() != null)
            existingInfo.setName(newuserPersonalInfo.getName());

        if (newuserPersonalInfo.getAddress() != null)
            existingInfo.setAddress(newuserPersonalInfo.getAddress());

        if (newuserPersonalInfo.getDateOfBirth() != null)
            existingInfo.setDateOfBirth(newuserPersonalInfo.getDateOfBirth());
    }
}
