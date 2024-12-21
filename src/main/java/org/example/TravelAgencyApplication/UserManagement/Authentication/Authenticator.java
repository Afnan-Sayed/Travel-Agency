package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.HashMap;
import java.util.Random;

public class Authenticator
{
    private UserProvider userProvider;
    private AuthenticationNotificationManager authNotifier;
    private String userInput;
    private final HashMap<Integer, String>verificationCode;

    public String generateVerificationCode()
    {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    //constructor
    public Authenticator()
    {
        this.userProvider = userProvider.getInstance();
        this.authNotifier= new AuthenticationNotificationManager();
        this.verificationCode = new HashMap<>();
    }

    private void sendVerificationCode(int userID)
    {
        String code = generateVerificationCode();
        verificationCode.put(userID, code);
        authNotifier.sendNotification(userID);
    }
    private String getUserInput()
    {
        return userInput;
    }

    //testing
    public void setUserInput(String userInput)
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
                return true;
            }
        }
        return false;
    }
}