package org.example.TravelAgencyApplication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.TravelAgencyApplication.UserManagement.Authentication.SessionManager;
import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.UserProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminUserSessionIdInterceptor extends NormalUserSessionIdInterceptor
{
    private final UserProvider userProvider;
    public AdminUserSessionIdInterceptor() {
        this.userProvider = UserProvider.getInstance();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        if (!super.preHandle(request, response, handler)) return false;
        int userID = Integer.parseInt(request.getParameter("userID"));
        if (!userProvider.getCredentialsProvider().getCredentialsByUserID(userID).getIsAdmin()) {
            response.setStatus(401);
            response.getWriter().write("This action requires admin credentials.");
            return false;
        }
        return true;
    }
}
