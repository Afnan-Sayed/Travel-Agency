package org.example.TravelAgencyApplication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.TravelAgencyApplication.UserManagement.Authentication.SessionManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class NormalUserSessionIdInterceptor implements HandlerInterceptor
{
    private final SessionManager sessionManager;
    public NormalUserSessionIdInterceptor() {
        this.sessionManager = SessionManager.getInstance();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        // Retrieve sessionId from the request parameters
        String sessionID = request.getParameter("sessionID");
        if (sessionID == null)
        {
            response.setStatus(401); // Unauthorized
            response.getWriter().write("Missing sessionID");
            return false; // Stop further processing
        }

        String userID = request.getParameter("userID");
        if (userID == null)
        {
            response.setStatus(401); // Unauthorized
            response.getWriter().write("Missing username");
            return false; // Stop further processing
        }

        // Validate sessionID
        if (!isValidSessionId(sessionID, userID)) {
            response.setStatus(401); // Unauthorized
            response.getWriter().write("Invalid sessionID");
            return false; // Stop further processing
        }

        // SessionId is valid; continue with the request
        return true;
    }

    private boolean isValidSessionId(String sessionID, String userID) {
        return sessionManager.correctID(sessionID, userID);
    }
}
