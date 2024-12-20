package org.example.TravelAgencyPersistence.UserStore.UserInformationProvider;

import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoProvider;

import java.util.ArrayList;
import java.util.HashMap;


public class PersonalInfoProvider
{
    private UserPersonalInfoProvider personalInfoProvider;

        //constructor
        protected PersonalInfoProvider(UserPersonalInfoProvider personalInfoProvider)
        {
            this.personalInfoProvider = personalInfoProvider;
        }

        //retrieves each user with their authentication credentials
        public HashMap<Integer, ArrayList<UserPersonalInfo>> getPersonalInfoOfAllUsers()
        {
            return personalInfoProvider.getPersonalInfoOfAllUsers();
        }

        //gets credentials by user ID
        public ArrayList<UserPersonalInfo> getPersonalInfoByUserID(int userID)
        {
            return personalInfoProvider.getPersonalInfoByUserID(userID);
        }

        public void addPersonalInfo(UserPersonalInfo PersonalInfo)
        {
            personalInfoProvider.addPersonalInfo(PersonalInfo);
        }

        //update existing Personal Info
        public void updatePersonalInfo(UserPersonalInfo newPersonalInfo)
        {
            personalInfoProvider.updatePersonalInfo(newPersonalInfo);
        }
    }