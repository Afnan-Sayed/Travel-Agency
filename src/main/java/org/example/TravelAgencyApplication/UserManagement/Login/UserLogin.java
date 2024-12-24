package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;

//DEPENDENCY WITH:
//IUserProvider, Authenticator

@Service
public abstract class UserLogin
{
    protected IUserProvider userProvider;
    protected Authenticator authenticator;

    public UserLogin(IUserProvider userProvider, Authenticator authenticator)
    {
        this.userProvider = userProvider;
        this.authenticator = authenticator;
    }


    public abstract void checkIfNotVerified(String username, boolean isNotFound, int isVerified);

    /*
    Supported account status indices:
    not verified 0
    verified 1
    logged in 2
    logged out 3
    */
    public final void verifyToLogin(String enteredUsername, String enteredPassword)
    {
        //acc with this username?
        boolean isNotFound = userProvider.doesUserExist(enteredUsername);

        //get correct password
        String correctPassword= userProvider.getPasswordByUsername(enteredUsername);

        //passwords match?
        boolean passwordMatch=false;
        if(Objects.equals(enteredPassword, correctPassword))
            passwordMatch=true;

        //authenticated to be logged in?
        int isVerified= userProvider.getAccountStatusByUsername(enteredUsername);


        //found user and is verified
        if(!isNotFound && (isVerified!=0) && passwordMatch)
        {
            //update status to be logged-in
            userProvider.updateAccountStatusByUsername(enteredUsername, 2);
            System.out.println("logged-in");
        }
        else
            checkIfNotVerified(enteredUsername, isNotFound, isVerified);
    }
}