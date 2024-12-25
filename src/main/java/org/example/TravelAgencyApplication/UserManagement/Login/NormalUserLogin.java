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

    @Override
    public String checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0))
        {
            //get userID
            int userID = userProvider.getUserIDByUsername(username);

            //trigger verification
            authenticator.verifyUser(userID);
            return "Your account hasn't been verified yet. " +
                    "A verification code has been sent to your registered contact.";

        }
        return "Either username or password is incorrect.";
    }
}