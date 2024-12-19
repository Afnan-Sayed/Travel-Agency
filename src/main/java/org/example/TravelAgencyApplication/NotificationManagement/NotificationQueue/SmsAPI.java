package org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue;

import java.util.Random;

public class SmsAPI {
    public int sendNotification(String message, String email)
    {
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        if(randomInt < 5)
            return 1;// simulation that something went wrong
        return 0;
    }
}
