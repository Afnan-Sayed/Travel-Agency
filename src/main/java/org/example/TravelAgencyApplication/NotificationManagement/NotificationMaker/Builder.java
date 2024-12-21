package org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker;

import org.example.TravelAgencyApplication.NotificationManagement.NotificationQueue.QueueManager;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfo;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoProvider;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.ArrayList;

public class Builder {

    private QueueManager queueManager;
    UserProvider provider;
    Builder()
    {
        provider = UserProvider.getInstance();
    }
    public void makeNotification(Template template, ArrayList<String> input, int language, int userID, String receiver, int notificationReceiverType) {

        // Supported language indices:
        // 0: English
        // 1: Arabic
        // 2: French
        // 3: German
        if(provider.getPersonalInfoProvider().getPersonalInfoByUserID(userID).isEmpty())
            throw new IllegalArgumentException("This user's ID is invalid");
        //validation
        if (language < 0 || language > 3) {throw new IllegalArgumentException("Invalid language index. Supported indices: 0 (Eng), 1 (Arabic), 2 (French), 3 (German).");}
        String messageTemplate = template.messages.get(language);
        if (messageTemplate == null || messageTemplate.isEmpty()) {throw new IllegalArgumentException("Template message for the selected language is missing.");}

        //filling
        String specialCharacter = template.getSpecialCharacter();
        String finalMessage = replaceSpecialCharacters(messageTemplate, input, specialCharacter, language);

        queueManager.sendNotification(finalMessage, userID, receiver, notificationReceiverType, template.getID());

    }

    private String replaceLast(String text, String target, String replacement) {
        int lastIndex = text.lastIndexOf(target);
        if (lastIndex == -1) {
            return text; // not found
        }

        String beforeLast = text.substring(0, lastIndex);
        String afterLast = text.substring(lastIndex + target.length());

        return beforeLast + replacement + afterLast;
    }

    private String replaceSpecialCharacters(String template, ArrayList<String> input, String specialCharacter, int lang) {
        String result = template;

        if(lang != 1)
            for (String value : input) {
                result = result.replaceFirst(specialCharacter, value);
            }
        else {
            for (String value : input) {
                result = replaceLast(result, specialCharacter, value);
            }
        }

        return result;
    }

}
