package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyApplication.UserManagement.Registration.RegistrationNotificationManager;
import org.example.TravelAgencyApplication.UserManagement.Registration.RegistrationTemplate;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;

@Service
// AGGREGATION WITH:
// IUserProvider, VerificationCodeSender

public class Authenticator
{
    private final IUserProvider userProvider;
    private final VerificationCodeSender codeSender;
    private final RegistrationNotificationManager notificationManager;

    //constructor
    public Authenticator(IUserProvider userProvider, VerificationCodeSender codeSender, RegistrationNotificationManager notificationManager)
    {
        this.userProvider = userProvider;
        this.codeSender = codeSender;
        this.notificationManager = notificationManager;
    }

    //verify the user by comparing the input with the stored code
    public boolean verifyUserCode(String username, String code)
    {
        int userID=userProvider.getUserIDByUsername(username);

        String correctCode = codeSender.getVerificationCode(userID);

        if (correctCode != null && correctCode.equals(code))
        {
            //if the code matches, update the account status
            userProvider.updateAccountStatusByID(userID, 1);

            //3. notify him that he has successfully been registered
            RegistrationTemplate template = new RegistrationTemplate();
            notificationManager.sendNotification(template, userID);
            return true;
        }
        return false;
    }

    public boolean isVerified(String username) {
        return userProvider.getAccountStatusByUsername(username) != 0;
    }

    public void sendVerificationCode(String username) {
        int userID=userProvider.getUserIDByUsername(username);
        codeSender.sendVerificationCode(userID);
    }
}