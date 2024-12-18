package org.example.TravelAgencyPersistence.UserStore.PersonalInformation;

public class UserPersonalInfo
{
    public int userId;
    public String name;
    public String address;
    public String dateOfBirth;

    public UserPersonalInfo(int userId, String name, String address, String dateOfBirth)
    {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
}
