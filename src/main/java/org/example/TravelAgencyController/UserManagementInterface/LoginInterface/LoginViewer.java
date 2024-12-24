package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyApplication.UserManagement.Login.AdminUserLogin;
import org.example.TravelAgencyApplication.UserManagement.Login.NormalUserLogin;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginViewer
{

    private final IUserProvider userProvider;
    private final Authenticator authenticator;

    // Constructor Injection
    @Autowired
    public LoginViewer(IUserProvider userProvider, Authenticator authenticator)
    {
        this.userProvider = userProvider;
        this.authenticator = authenticator;
    }

    // Login endpoint for Normal User
    @PostMapping("/normal")
    public ResponseEntity<String> normalUserLogin(@RequestParam String username, @RequestParam String password) {
        NormalUserLogin normalUserLogin = new NormalUserLogin(userProvider, authenticator);
        try {
            // Verify credentials and update login status
            normalUserLogin.verifyToLogin(username, password);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Return error if login fails
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Login endpoint for Admin User
    @PostMapping("/admin")
    public ResponseEntity<String> adminUserLogin(@RequestParam String username, @RequestParam String password) {
        AdminUserLogin adminUserLogin = new AdminUserLogin(userProvider, authenticator);
        try {
            // Verify credentials and update login status
            adminUserLogin.verifyToLogin(username, password);
            return new ResponseEntity<>("Admin login successful", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Return error if login fails
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
