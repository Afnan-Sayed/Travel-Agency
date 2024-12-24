package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminUserLogin extends UserLogin
{
    public AdminUserLogin(IUserProvider userProvider, Authenticator authenticator) {
        super(userProvider, authenticator);
    }
    public void checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0))
            System.out.println( "you are no longer an admin");
    }
}