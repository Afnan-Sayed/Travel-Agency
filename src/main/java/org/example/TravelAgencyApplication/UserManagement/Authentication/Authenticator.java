package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;

import java.util.HashMap;
import java.util.Random;

//AGGREGATION WITH:
//IUserProvider, AuthenticationNotificationManager
public class Authenticator
{
    private final IUserProvider userProvider;
    private final AuthenticationNotificationManager authNotifier;
    private final HashMap<Integer, String>verificationCode;
    private String userInput;

    //constructor
    public Authenticator(IUserProvider userProvider, AuthenticationNotificationManager authNotifier)
    {
        this.userProvider = userProvider;
        this.authNotifier = authNotifier;
        this.verificationCode = new HashMap<>();
    }


    public String generateVerificationCode()
    {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }


    private void sendVerificationCode(int userID)
    {
        String code = generateVerificationCode();
        verificationCode.put(userID, code);
        AuthenticationTemplate template = new AuthenticationTemplate();
        authNotifier.sendNotification(template, userID);
    }
    private String getUserInput()
    {
        return userInput;
    }

    //for testing
    public void setEnteredCode(String userInput)
    {
       this.userInput=userInput;
    }

    public boolean verifyUser(int userID)
    {
        sendVerificationCode(userID);
        String input= getUserInput();
        if (verificationCode.containsKey(userID))
        {
            String correctCode = verificationCode.get(userID);
            if (correctCode.equals(input))
            {
                verificationCode.remove(userID);

                //change acc status
                userProvider.updateAccountStatusByID(userID,1);
                return true;
            }
        }
        return false;
    }
}