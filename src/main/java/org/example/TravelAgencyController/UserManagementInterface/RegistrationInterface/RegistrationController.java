package org.example.TravelAgencyController.UserManagementInterface.RegistrationInterface;

import org.example.TravelAgencyApplication.UserManagement.Registration.RegistrationMaker;
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
    public ResponseEntity<String> registerUser(
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
            registrationMaker.registerUser(
                    username, password, email, phoneNumber, name, address, dateOfBirth, languageID, notificationReceiverType
            );
            return ResponseEntity.ok("User registered successfully. A verification email has been sent.");
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