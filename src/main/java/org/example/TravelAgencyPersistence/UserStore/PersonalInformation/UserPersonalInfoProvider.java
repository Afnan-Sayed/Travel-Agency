package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import java.util.ArrayList;
import java.util.HashMap;

//ASSOCIATION WITH UserPersonalInfoRepository CLASS
//DEPENDENCY WITH UserPersonalInfo


public class UserPersonalInfoProvider
{
    private UserPersonalInfoRepository PersonalInfoRepo;

    //constructor
    public UserPersonalInfoProvider(UserPersonalInfoRepository PersonalInfoRepo)
    {
        this.PersonalInfoRepo = PersonalInfoRepo;
    }

    //retrieves each user with their authentication credentials
    public HashMap<Integer, ArrayList<UserPersonalInfo>> getPersonalInfoOfAllUsers()
    {
        return PersonalInfoRepo.getPersonalInfoOfAllUsers();
    }

    //gets credentials by user ID
    public ArrayList<UserPersonalInfo> getPersonalInfoByUserID(int userID)
    {
        return PersonalInfoRepo.getPersonalInfoByUserID(userID);
    }

    public void addPersonalInfo(UserPersonalInfo PersonalInfo)
    {
        PersonalInfoRepo.addPersonalInfo(PersonalInfo);
    }

    //update existing Personal Info
    public void updatePersonalInfo(UserPersonalInfo newPersonalInfo)
    {
        PersonalInfoRepo.updatePersonalInfo(newPersonalInfo);
    }
}
