package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.HashMap;
import java.util.Random;

//DEPENDENCY WITH:
//UserProvider, AuthenticationNotificationManager,
public class Authenticator
{
    private UserProvider userProvider;
    private AuthenticationNotificationManager authNotifier;
    private final HashMap<Integer, String>verificationCode;
    private String userInput;

    public String generateVerificationCode()
    {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    //constructor
    public Authenticator()
    {
        this.verificationCode = new HashMap<>();
    }

    //using lazy instantiation to avoid being tightly coupled
    private UserProvider getUserProvider()
    {
        if (userProvider == null)
            userProvider = UserProvider.getInstance();
        return userProvider;
    }

    //using lazy instantiation to avoid being tightly coupled
    private AuthenticationNotificationManager getAuthNotifier()
    {
        if (authNotifier == null)
            authNotifier = new AuthenticationNotificationManager();
        return authNotifier;
    }


    private void sendVerificationCode(int userID)
    {
        String code = generateVerificationCode();
        verificationCode.put(userID, code);
        AuthenticationTemplate template = new AuthenticationTemplate();
        getAuthNotifier().sendNotification(template, userID);
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
                System.out.println("Your account has been verified");

                //change acc status
                getUserProvider().getCredentialsProvider()
                            .getCredentialsByUserID(userID)
                            .setAccountStatus(1);

                return true;
            }
            else
                System.out.println("sorry, your account is still not verified");
        }
        return false;
    }
}