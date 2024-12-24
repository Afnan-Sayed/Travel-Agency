package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;

@Service
public class NormalUserLogin extends UserLogin
{
    public NormalUserLogin(IUserProvider userProvider, Authenticator authenticator) {
        super(userProvider, authenticator);
    }

    public void checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0))
        {
            System.out.println("your acc hasn't been verified yet," +
                    "we have sent you a verification code to complete your registration," +
                    " please enter it: ");

            //get userID
            int userID = userProvider.getUserIDByUsername(username);

            authenticator.verifyUser(userID);
        }
        else
            System.out.println("either username or password is wrong");
    }
}