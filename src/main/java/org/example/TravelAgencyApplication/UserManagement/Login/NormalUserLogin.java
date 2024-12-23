package org.example.TravelAgencyApplication.UserManagement.Login;

import java.util.Objects;

public class NormalUserLogin extends UserLogin
{
    public NormalUserLogin() {}
    public void checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0))
        {
            System.out.println("your acc hasn't been verified yet," +
                    "we have sent you a verification code to complete your registration," +
                    " please enter it: ");

            //get userID
            int userID =
                    getUserProvider().getCredentialsProvider()
                    .getCredentialsByUsername(username)
                    .getLast().getUserID();

            getAuthenticator().verifyUser(userID);
        }
        else
            System.out.println("either username or password is wrong");
    }
}