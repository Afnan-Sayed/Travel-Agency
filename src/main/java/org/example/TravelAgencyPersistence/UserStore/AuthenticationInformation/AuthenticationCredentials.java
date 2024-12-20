package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;
public class AuthenticationCredentials
{
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private int userID;
    private int userAccountStatus;

    public AuthenticationCredentials(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setUserState(int userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }


    //getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getUserID() {
        return userID;
    }
    public int getUserState() {
        return userAccountStatus;
    }
}