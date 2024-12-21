package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;

import java.util.ArrayList;

//1. authenticate user
//2. generate unique id
//3. save user into db
//4. notify him that he has successfully been registered

public class RegistrationProcessMaker
{
    private RegistrationFieldsValidator validator;
    private RegistrationTemplate registrationTemplate;
    private RegistrationNotificationManager notificationManager;
    private int generateID()
    {
        return java.util.UUID.randomUUID().hashCode();
    }

    public RegistrationProcessMaker()
    {
        validator = new RegistrationFieldsValidator();
        notificationManager = new RegistrationNotificationManager();
        registrationTemplate = new RegistrationTemplate(1, "%");
    }

    public void registerUser(UserPersonalInfo userInfo, int language)
    {


        if (validator.RegistrationFieldsValidator(userInfo))
        {
            userInfo.setUserID(generateID());
            saveUserToDatabase(userInfo);

            ArrayList<String> input = new ArrayList<>();
            input.add(userInfo.getName());
            notificationManager.sendNotification(
                    registrationTemplate, input, language, userInfo.getUserID(), userInfo.getEmail(), 0
            );
        } else {
            throw new IllegalArgumentException("Invalid registration data");
        }
    }

    private void saveUserToDatabase(UserPersonalInfo userInfo) {
        System.out.println("User " + userInfo.getName() + " saved to database with ID: " + userInfo.getUserID());
    }


}
