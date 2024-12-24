package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

//AGGREGATION WITH UserPersonalInfoRepository
//DEPENDENCY WITH UserPersonalInfo

@Repository
public class UserPersonalInfoProvider
{
    private UserPersonalInfoRepository personalInfoRepo;

    //constructor
    public UserPersonalInfoProvider(UserPersonalInfoRepository PersonalInfoRepo)
    {
        this.personalInfoRepo = PersonalInfoRepo;
    }

    //retrieves each user with their authentication credentials
    public HashMap<Integer, ArrayList<UserPersonalInfo>> getPersonalInfoOfAllUsers()
    {
        return personalInfoRepo.getPersonalInfoOfAllUsers();
    }

    //gets credentials by user ID
    public ArrayList<UserPersonalInfo> getPersonalInfoByUserID(int userID)
    {
        return personalInfoRepo.getPersonalInfoByUserID(userID);
    }

    public void addPersonalInfo(UserPersonalInfo personalInfo)
    {
        validatePersonalInfo(personalInfo);
        personalInfoRepo.addPersonalInfo(personalInfo);
    }

    //update existing Personal Info
    public void updatePersonalInfo(int userID,UserPersonalInfo newPersonalInfo)
    {
        validatePersonalInfo(newPersonalInfo);
        personalInfoRepo.updatePersonalInfo(userID, newPersonalInfo);
    }

    //filters
    public ArrayList<UserPersonalInfo> filterByLanguageID(int languageID)
    {
        return personalInfoRepo.getPersonalInfoOfAllUsers()
                .values()
                .stream()
                .flatMap(ArrayList::stream)
                .filter(info -> info.getLanguageID() == languageID)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<UserPersonalInfo> filterByNotificationReceiverType(int notificationReceiverType)
    {
        return personalInfoRepo.getPersonalInfoOfAllUsers()
                .values()
                .stream()
                .flatMap(ArrayList::stream)
                .filter(info -> info.getNotificationReceiverType() == notificationReceiverType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void validatePersonalInfo(UserPersonalInfo personalInfo)
    {
        if (personalInfo == null) {
            throw new IllegalArgumentException("Personal Info cannot be null");
        }
        if (personalInfo.getName() == null || personalInfo.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (personalInfo.getLanguageID() == 0) {
            throw new IllegalArgumentException("LanguageID must be valid and not zero");
        }
        if (personalInfo.getNotificationReceiverType() == 0) {
            throw new IllegalArgumentException("NotificationReceiverType must be valid and not zero");
        }
    }
}