package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;
public class AuthenticationCredentials
{
    public String username;
    public String password;
    public String email;
    public String phoneNumber;
    public int userID;

    public AuthenticationCredentials(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}