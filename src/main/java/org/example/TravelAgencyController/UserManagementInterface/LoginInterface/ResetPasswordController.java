package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;

import org.example.TravelAgencyApplication.UserManagement.ResetPassword.ResetPasswordMaker;
import org.example.TravelAgencyController.UserManagementInterface.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ResetPasswordController
{

    @Autowired
    private ResetPasswordMaker resetPasswordMaker;

    @PostMapping("/reset-password")
    public ResponseEntity<Response>
    resetPassword(@RequestParam String username, @RequestParam String newPassword)
    {
        try
        {
            String res = resetPasswordMaker.resetPassword(username, newPassword);
            Response response = new Response();

            if ("success".equals(res))
            {
                response.setStatus(true);
                response.setMessage("You have reset your password successfully, now try to log in.");
            }
            else if ("failed".equals(res))
            {
                response.setStatus(false);
                response.setMessage("Invalid resetting password process.");
            }
            else
            {
                response.setStatus(false);
                response.setMessage("You haven't been verified to be registered yet!");
            }

            return ResponseEntity.ok(response);

        }
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response(false, "Error: " + e.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(false, "An unexpected error occurred."));
        }
    }
}
