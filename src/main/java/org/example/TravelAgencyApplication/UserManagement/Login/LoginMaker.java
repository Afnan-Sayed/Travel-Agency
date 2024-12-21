package org.example.TravelAgencyApplication.UserManagement.Login;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;

import java.util.Objects;

public class LoginMaker
{
    private UserProvider userProvider;

    public LoginMaker()
    {
        this.userProvider= userProvider.getInstance();
    }

    public void login(String enteredUsername, String enteredPassword)
    {
        //Supported account status indices:
        //not verified to register 0
        //verified to register 1
        //logged in 2
        //logged out 3

        boolean isNotFound=userProvider.getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .isEmpty();

        int isVerified=userProvider.getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .getLast().getAccountStatus();

        String correctPassword=userProvider.getCredentialsProvider()
                .getCredentialsByUsername(enteredUsername)
                .getLast().getPassword();

        boolean passwordMatch=false;
        if(Objects.equals(enteredPassword, correctPassword))
            passwordMatch=true;



        //found user and is verified
        if(!isNotFound && (isVerified!=0) && passwordMatch)
        {
            userProvider.getCredentialsProvider()
                    .getCredentialsByUsername(enteredUsername)
                    .getLast().setAccountStatus(2);
        }
        else if(!isNotFound && (isVerified==0))
            System.out.println("your acc hasn't been verified yet");
        else
            System.out.println("either username or password is wrong");
    }
}
