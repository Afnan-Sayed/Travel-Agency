package org.example.TravelAgencyApplication.UserManagement.Authentication;

public interface IVerificationCodeProvider {
    String getVerificationCode(int userID);
}
