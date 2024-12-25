package org.example.TravelAgencyController.UserManagementInterface.RegistrationInterface;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyController.UserManagementInterface.Response;
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

    @PostMapping("/verify-code")
    public ResponseEntity<Response> verifyCode(@RequestParam String username, @RequestParam String enteredCode)
    {
        try
        {
            authenticator.setEnteredCode(enteredCode);
            boolean isVerified = authenticator.verifyUser(username);

            Response response = new Response();
            if (isVerified)
            {
                response.setStatus(true);
                response.setMessage("User verified successfully");
            }
            else
            {
                response.setStatus(false);
                response.setMessage("Verification failed. Invalid code.");
            }
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e)
        {
            Response response = new Response(false, "Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        catch (Exception e) {
            Response response = new Response(false, "An unexpected error occurred.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}