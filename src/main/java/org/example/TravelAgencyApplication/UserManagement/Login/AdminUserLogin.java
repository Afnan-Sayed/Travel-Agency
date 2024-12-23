package org.example.TravelAgencyApplication.UserManagement.Login;

import java.util.Objects;

public class AdminUserLogin extends UserLogin
{
    public AdminUserLogin() {}
    public void checkIfNotVerified(String username, boolean isNotFound, int isVerified)
    {
        if (!isNotFound && (isVerified == 0))
            System.out.println( "you are no longer an admin");
    }
}