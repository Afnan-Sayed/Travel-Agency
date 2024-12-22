/*
package org.example.TravelAgencyApplication.UserManagement.Registration;

import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RegistrationAuthenticator
{
    private UserProvider userProvider;
    private AuthenticationNotificationManager authNotifier;
    private final HashMap<Integer, ArrayList<String> >verificationCodes;
    private ArrayList<String> generateVerificationCode()
    {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        ArrayList<String> verificationCodeList = new ArrayList<>();
        verificationCodeList.add(String.valueOf(code));
        return verificationCodeList;
    }

    //constructor
    public RegistrationAuthenticator()
    {
        this.userProvider = userProvider.getInstance();
        this.authNotifier= new AuthenticationNotificationManager();
        this.verificationCodes = new HashMap<>();
    }

    public void sendVerificationCode(int userID)
    {
        ArrayList<String> verificationCode = generateVerificationCode();
        authNotifier.sendAuthenticationNotification(verificationCode, userID);
        
        verificationCodes.put(userID, verificationCode);
    }

    public boolean verifyUser(int userID, String inputCode)
    {
        if (verificationCodes.containsKey(userID))
        {
            String correctCode = verificationCodes.get(userID);
            if (correctCode.equals(inputCode))
            {
//                verificationCodes.remove(userID);
                return true;
            }
        }
        return false;
    }
}*/
