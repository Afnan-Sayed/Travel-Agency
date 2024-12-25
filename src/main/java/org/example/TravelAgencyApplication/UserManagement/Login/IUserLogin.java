package org.example.TravelAgencyApplication.UserManagement.Login;

public interface IUserLogin
{
    String verifyToLogin(String enteredUsername, String enteredPassword);
    //String checkIfNotVerified(String username, boolean isNotFound, int isVerified);
}
