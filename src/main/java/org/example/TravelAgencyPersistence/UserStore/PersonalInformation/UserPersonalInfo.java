package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

public class UserPersonalInfo
{
    private int userId;
    private String name;
    private String address;
    private String dateOfBirth;
    private int LanguageID;


    public UserPersonalInfo(int userId, String name, String address, String dateOfBirth)
    {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

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
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
