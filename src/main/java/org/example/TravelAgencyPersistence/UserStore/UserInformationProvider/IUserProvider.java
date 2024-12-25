package org.example.TravelAgencyPersistence.UserStore.UserInformationProvider;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserProvider
{
    AuthenticationCredentialsProvider getCredentialsProvider();
    PersonalInfoProvider getPersonalInfoProvider();

    // Update account status by username
    void updateAccountStatusByUsername(String username, int status);

    // Update account status by id
    void updateAccountStatusByID(int id, int status);

    //update password by id
    void updatePassByID(int id, String newPass);

    // Get account status by username
    int getAccountStatusByUsername(String username);

    // Get userID by username
    int getUserIDByUsername(String username);

    // Check if user exists by username
    boolean doesUserExist(String username);

    // Get email by userID
    String getEmailByUserID(int userID);

    // Get phone number by userID
    String getPhoneNumberByUserID(int userID);

    // Get language ID by userID
    int getLanguageIDByUserID(int userID);

    // Get password by username
    String getPasswordByUsername(String username);

    // Get notification receiver type by userID
    int getNotificationReceiverTypeByUserID(int userID);
    void addAuthenticationCredentials(String username, String password, String email,String phoneNumber,
                                             int userID, int userAccountStatus, boolean isAdmin);
    void addPersonalInfo(int userId, String name, String address,
                                String dateOfBirth, int LanguageID,
                                int notificationReceiverType);
}