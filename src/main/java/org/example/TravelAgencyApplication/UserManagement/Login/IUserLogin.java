package org.example.TravelAgencyApplication.UserManagement.Login;

public interface IUserLogin
{
    boolean verifyToLogin(String enteredUsername, String enteredPassword);
    //String checkIfNotVerified(String username, boolean isNotFound, int isVerified);
}