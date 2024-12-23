package org.example.TravelAgencyApplication.UserManagement.Login;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.Objects;

//DEPENDENCY WITH:
//UserProvider, Authenticator

public abstract class UserLogin
{
    protected UserProvider userProvider;
    protected Authenticator authenticator;

    public UserLogin() {}

    // Factory method for UserProvider
    protected UserProvider createUserProvider()
    {
        return UserProvider.getInstance();
    }

    // Factory method for Authenticator
    protected Authenticator createAuthenticator()
    {
        return new Authenticator();
    }

    protected UserProvider getUserProvider()
    {
        if (userProvider == null)
            userProvider = createUserProvider();
        return userProvider;
    }

    protected Authenticator getAuthenticator()
    {
        if (authenticator == null)
            authenticator = createAuthenticator();
        return authenticator;
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
        boolean isNotFound=
                 getUserProvider().getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .isEmpty();

        //get correct password
        String correctPassword=
                 getUserProvider().getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .getLast().getPassword();

        //passwords match?
        boolean passwordMatch=false;
        if(Objects.equals(enteredPassword, correctPassword))
            passwordMatch=true;


        //authenticated to be logged in?
        int isVerified=
                 getUserProvider().getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .getLast().getAccountStatus();


        //found user and is verified
        if(!isNotFound && (isVerified!=0) && passwordMatch)
        {
                    getUserProvider().getCredentialsProvider()
                    .getCredentialsByUsername(enteredUsername)
                    .getLast().setAccountStatus(2); //logged in
        }
        else
            checkIfNotVerified(enteredUsername, isNotFound, isVerified);
    }
}