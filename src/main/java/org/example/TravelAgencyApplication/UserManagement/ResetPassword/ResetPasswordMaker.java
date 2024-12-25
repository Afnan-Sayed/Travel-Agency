package org.example.TravelAgencyApplication.UserManagement.ResetPassword;

import org.example.TravelAgencyApplication.UserManagement.Authentication.Authenticator;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
import org.springframework.stereotype.Service;

//1. authenticate user
//2. reset password

@Service
public class ResetPasswordMaker
{
    private Authenticator authenticator;
    private IUserProvider userProvider;

    public ResetPasswordMaker(Authenticator authenticator, IUserProvider userProvider)
    {
        this.authenticator=authenticator;
        this.userProvider= userProvider;
    }

    public String resetPassword(String username, String newPass)
    {
        int status=userProvider.getAccountStatusByUsername(username);
        if(status==1)
        {
            int userID = userProvider.getUserIDByUsername(username);
            //1. authenticate user
            if (authenticator.verifyUser(userID))
            {
                //2. reset password
                userProvider.updatePassByID(userID, newPass);

                //3. set status to be logged out
                userProvider.updateAccountStatusByID(userID, 3);
                return "success";
            }
            else return "failed";
        }
        return "not registered";
    }
}