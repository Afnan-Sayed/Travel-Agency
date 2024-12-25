package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;

import org.example.TravelAgencyApplication.UserManagement.Login.IUserLogin;
import org.example.TravelAgencyController.UserManagementInterface.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    @Qualifier("normalUserLogin")
    private IUserLogin normalUserLogin;

    @Autowired
    @Qualifier("adminUserLogin")
    private IUserLogin adminUserLogin;

    @PostMapping("/normal")
    public ResponseEntity<Response> normalUserLogin
            (
                    @RequestParam String username,
                    @RequestParam String password
            )
    {
        return handleLogin(normalUserLogin, username, password,
                "Normal user logged in successfully.",
                "Login failed. Either your account is not verified or credentials are incorrect.");
    }

    @PostMapping("/admin")
    public ResponseEntity<Response> adminUserLogin
            (
                    @RequestParam String username,
                    @RequestParam String password
            )
    {
        return handleLogin(adminUserLogin, username, password,
                "Admin user logged in successfully.",
                "Login failed. Either your account is no longer an admin or credentials are incorrect.");
    }

    private ResponseEntity<Response> handleLogin
            (
                    IUserLogin userLogin, String username, String password
                    ,String successMessage, String failureMessage
            )
    {
        try
        {
            String sessionInfo = userLogin.verifyToLogin(username, password);
            Response response = new Response();
            response.setStatus(sessionInfo != null);

            if (sessionInfo != null) {
                response.setMessage(successMessage + sessionInfo);
            } else {
                response.setMessage(failureMessage);
            }
            return ResponseEntity.ok(response);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(false, "An unexpected error occurred."));
        }
    }
}