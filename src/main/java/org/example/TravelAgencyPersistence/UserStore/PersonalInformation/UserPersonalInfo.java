package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

import org.springframework.stereotype.Repository;

@Repository
public class UserPersonalInfo
{
    private int userId;
    private String name;
    private String address;
    private String dateOfBirth;
    private int LanguageID;
    private int notificationReceiverType;


    public UserPersonalInfo(int userId, String name, String address, String dateOfBirth, int LanguageID, int notificationReceiverType)
    {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.LanguageID=LanguageID;
        this.notificationReceiverType=notificationReceiverType;
    }
    public UserPersonalInfo(){};

    //setters
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setLanguageID(int languageID) {
        LanguageID = languageID;
    }
    public void setNotificationReceiverType(int notificationReceiverType) {
        this.notificationReceiverType = notificationReceiverType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //getters
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getAddress() {
        return address;
    }
    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public int getLanguageID() {
        return LanguageID;
    }
    public int getNotificationReceiverType() {
        return notificationReceiverType;
    }
}