package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;

@Service
// AGGREGATION WITH:
// IUserProvider, VerificationCodeSender

public class Authenticator
{
    private final IUserProvider userProvider;
    private final VerificationCodeSender codeSender;
    private String userInput;

    //constructor
    public Authenticator(IUserProvider userProvider, VerificationCodeSender codeSender)
    {
        this.userProvider = userProvider;
        this.codeSender = codeSender;
    }

    public void setEnteredCode(String userInput) {
        this.userInput=userInput;
    }
    //verify the user by comparing the input with the stored code
    public boolean verifyUser(String username)
    {
        int userID=userProvider.getUserIDByUsername(username);
        codeSender.sendVerificationCode(userID);

        String input = getUserInput();

        String correctCode = codeSender.getVerificationCode(userID);

        if (correctCode != null && correctCode.equals(input))
        {
            //if the code matches, update the account status
            userProvider.updateAccountStatusByID(userID, 1);
            return true;
        }
        return false;
    }

    private String getUserInput() {
        return userInput;
    }
}