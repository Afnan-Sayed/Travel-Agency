package org.example.TravelAgencyController.UserManagementInterface.RegistrationInterface;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{

    @Autowired
    private Authenticator authenticator;

    @PostMapping("/send-code")
    public ResponseEntity<String> sendVerificationCode(@RequestParam int userID)
    {
        try
        {
            authenticator.verifyUser(userID);
            return ResponseEntity.ok("Verification code sent successfully.");
        }
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }


    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestParam int userID, @RequestParam String enteredCode)
    {
        try
        {
            authenticator.setEnteredCode(enteredCode);
            boolean isVerified = authenticator.verifyUser(userID);
            if (isVerified)
            {
                return ResponseEntity.ok("User verified successfully.");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Verification failed. Invalid code.");
            }
        }
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}
