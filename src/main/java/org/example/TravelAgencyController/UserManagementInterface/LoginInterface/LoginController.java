package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;

import org.example.TravelAgencyApplication.UserManagement.Login.AdminUserLogin;
import org.example.TravelAgencyApplication.UserManagement.Login.NormalUserLogin;
import org.example.TravelAgencyController.UserManagementInterface.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private NormalUserLogin normalUserLogin;

    @Autowired
    private AdminUserLogin adminUserLogin;

    @PostMapping("/normal")
    public ResponseEntity<Response> normalUserLogin(@RequestParam String username, @RequestParam String password) {
        try {
            boolean loginSuccessful = normalUserLogin.verifyToLogin(username, password);
            Response response = new Response();
            response.setStatus(loginSuccessful);

            if (loginSuccessful) {
                response.setMessage("Normal user logged in successfully.");
            } else {
                response.setMessage("Login failed. Either your account is not verified or credentials are incorrect.");
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(false, "An unexpected error occurred."));
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<Response> adminUserLogin(@RequestParam String username, @RequestParam String password) {
        try {
            boolean loginSuccessful = adminUserLogin.verifyToLogin(username, password);
            Response response = new Response();
            response.setStatus(loginSuccessful);

            if (loginSuccessful) {
                response.setMessage("Admin user logged in successfully.");
            } else {
                response.setMessage("Login failed. Either your account is no longer an admin or credentials are incorrect.");
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(false, "An unexpected error occurred."));
        }
    }
}
