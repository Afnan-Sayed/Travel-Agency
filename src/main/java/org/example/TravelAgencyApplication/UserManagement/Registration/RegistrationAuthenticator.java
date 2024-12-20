package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;

public class RegistrationFieldsValidator
    //checks enno filled kol el required fields correctly
{
    public boolean RegistrationFieldsValidator(UserPersonalInfo userInfo)
    {
        if (userInfo.name== null || userInfo.name.isEmpty())
        {
            return false;
        }
        if (userInfo.email == null || !userInfo.email.contains("@"))
        {
            return false;
        }
        if (userInfo.getPhoneNumber() == null || userInfo.getPhoneNumber().length() != 10)
        {
            return false;
        }
        return true;
    }
}
