package org.example.TravelAgencyController.UserManagementInterface.RegistrationInterface;

import org.example.TravelAgencyApplication.UserManagement.Registration.RegistrationMaker;
import org.example.TravelAgencyController.UserManagementInterface.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController
{
    @Autowired
    private RegistrationMaker registrationMaker;

    @PostMapping
    public ResponseEntity<Response> registerUser
    (
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String dateOfBirth,
            @RequestParam int languageID,
            @RequestParam int notificationReceiverType
    )
    {
        try
        {
            // Register the user and get the result (true or false)
            boolean registrationSuccessful = registrationMaker.registerUser
            (
                  username, password, email, phoneNumber, name,
                  address, dateOfBirth, languageID, notificationReceiverType
            );

            Response response = new Response();
            response.setStatus(registrationSuccessful);

            if (registrationSuccessful) {
                response.setMessage("User registered successfully. A verification email has been sent");
            } else {
                response.setMessage("Registration failed. Invalid data provided");
            }

            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e)
        {
            Response response = new Response(false, "Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        catch (Exception e)
        {
            Response response = new Response(false, "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}