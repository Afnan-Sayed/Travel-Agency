package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;

import org.example.TravelAgencyApplication.UserManagement.Login.AdminUserLogin;
import org.example.TravelAgencyApplication.UserManagement.Login.NormalUserLogin;
import org.example.TravelAgencyApplication.UserManagement.Login.UserLogin;
import org.example.TravelAgencyApplication.UserManagement.ResetPassword.ResetPasswordMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController
{

    @Autowired
    private NormalUserLogin normalUserLogin;

    @Autowired
    private AdminUserLogin adminUserLogin;

    @Autowired
    private ResetPasswordMaker resetPasswordMaker;


    @PostMapping("/normal")
    public ResponseEntity<String> normalUserLogin(@RequestParam String username, @RequestParam String password)
    {
        try
        {
            normalUserLogin.verifyToLogin(username, password);
            return ResponseEntity.ok("Normal user logged in successfully.");
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


    @PostMapping("/admin")
    public ResponseEntity<String> adminUserLogin(@RequestParam String username, @RequestParam String password)
    {
        try
        {
            adminUserLogin.verifyToLogin(username, password);
            return ResponseEntity.ok("Admin user logged in successfully.");
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


    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String username, @RequestParam String newPassword)
    {
        try
        {
            resetPasswordMaker.resetPassword(username, newPassword);
            return ResponseEntity.ok("Password reset successfully. User has been logged out.");
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
