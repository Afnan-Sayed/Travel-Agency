package org.example.TravelAgencyApplication.UserManagement.ResetPassword;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

//1. authenticate user
//2. reset password

public class ResetPasswordMaker
{
    private Authenticator authenticator;
    private UserProvider userProvider;

    public ResetPasswordMaker()
    {
        authenticator=new Authenticator();
        this.userProvider= userProvider.getInstance();
    }

    public void resetPassword(int userID, String newPass)
    {
            //1. authenticate user
        if (authenticator.verifyUser(userID))
        {
            //2. reset password
            userProvider.getCredentialsProvider()
                        .getCredentialsByUserID(userID)
                        .setPassword(newPass);

            //3. set status to be logged out
            userProvider.getCredentialsProvider()
                    .getCredentialsByUserID(userID)
                    .setAccountStatus(3);
        }

        else
            throw new IllegalArgumentException("Invalid resetting password process");
    }
}
