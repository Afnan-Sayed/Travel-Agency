package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;
public class AuthenticationCredentials
{
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private int userID;
    private int userAccountStatus;
    private boolean isAdmin;

    public AuthenticationCredentials(String username, String password, String email, String phoneNumber,
                            int userID, int userAccountStatus, boolean isAdmin)
    {
        this.username=username;
        this.password=password;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.userID=userID;
        this.userAccountStatus=userAccountStatus;
        this.isAdmin=isAdmin;
    }
    public AuthenticationCredentials(){};
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
    public void setAccountStatus(int userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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
    public int getAccountStatus() {
        return userAccountStatus;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }
}