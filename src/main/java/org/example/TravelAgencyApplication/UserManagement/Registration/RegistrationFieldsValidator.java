package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;

public class Validator {
    public boolean validate(UserPersonalInfo userInfo) {
        if (userInfo.getName() == null || userInfo.getName().isEmpty()) {
            return false;
        }
        if (userInfo.getEmail() == null || !userInfo.getEmail().contains("@")) {
            return false;
        }
        if (userInfo.getPhoneNumber() == null || userInfo.getPhoneNumber().length() != 10) {
            return false;
        }
        // Add more validation rules as needed
        return true;
    }
}
