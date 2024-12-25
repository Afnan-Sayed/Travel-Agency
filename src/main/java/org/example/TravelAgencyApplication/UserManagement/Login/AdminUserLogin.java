package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;


@Service
public class AdminUserLogin extends UserLogin
{
    public AdminUserLogin(IUserProvider userProvider, Authenticator authenticator) {
        super(userProvider, authenticator);
    }
    public String checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0)) {
            return "Your account is no longer marked as an admin";
        }
        return "Either username or password is incorrect";
    }
}