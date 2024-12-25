package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyApplication.UserManagement.Authentication.SessionManager;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;

//DEPENDENCY WITH:
//IUserProvider, Authenticator

@Service
public abstract class UserLogin implements IUserLogin
{
    protected IUserProvider userProvider;
    protected Authenticator authenticator;
    protected SessionManager sessionManager;

    public UserLogin(IUserProvider userProvider, Authenticator authenticator)
    {
        this.userProvider = userProvider;
        this.authenticator = authenticator;
        this.sessionManager = SessionManager.getInstance();
    }


    public abstract String checkIfNotVerified(String username, boolean isNotFound, int isVerified);

    /*
    Supported account status indices:
    not verified 0
    verified 1
    logged in 2
    logged out 3
    */
    public final String verifyToLogin(String enteredUsername, String enteredPassword)
    {
        //get correct password
        String correctPassword= userProvider.getPasswordByUsername(enteredUsername);

        //user doesn't exist so password is null
        if (correctPassword == null) {
            return null;
        }

        //passwords match?
        boolean passwordMatch=false;
        if(Objects.equals(enteredPassword, correctPassword))
            passwordMatch=true;

        //authenticated to be logged in?
        int isVerified= userProvider.getAccountStatusByUsername(enteredUsername);


        //found user and is verified
        if((isVerified!=0) && passwordMatch)
        {
            //update status to be logged-in
            userProvider.updateAccountStatusByUsername(enteredUsername, 2);
            String userID = ""+userProvider.getUserIDByUsername(enteredUsername);
            String sessionInfo = " Session ID: " + sessionManager.generateSessionID(userID) + " User ID: " + userID;
            return sessionInfo; //logged-in
        }
        return null; //failed
    }
}