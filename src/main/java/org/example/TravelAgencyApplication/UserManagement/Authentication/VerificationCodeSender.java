package org.example.TravelAgencyApplication.UserManagement.Authentication;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class VerificationCodeSender
{
    private final HashMap<Integer, String> verificationCode;
    private final AuthenticationNotificationManager authNotifier;

    //constructor
    public VerificationCodeSender(AuthenticationNotificationManager authNotifier) {
        this.authNotifier = authNotifier;
        this.verificationCode = new HashMap<>();
    }

    //generate and store the verification code
    public String generateVerificationCode(int userID) {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        String generatedCode = String.valueOf(code);

        //store the code in the verificationCode map
        verificationCode.put(userID, generatedCode);

        return generatedCode;
    }

    //expose the verification code for the given userID
    public String getVerificationCode(int userID) {
        return verificationCode.get(userID);
    }

    //send the verification code to the user
    public void sendVerificationCode(int userID) {
        String code = generateVerificationCode(userID);
        AuthenticationTemplate template = new AuthenticationTemplate();
        authNotifier.sendNotification(template, userID);
    }
}
