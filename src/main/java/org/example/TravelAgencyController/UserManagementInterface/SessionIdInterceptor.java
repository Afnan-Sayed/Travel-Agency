package org.example.TravelAgencyController.UserManagementInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Retrieve sessionId from the request parameters
        String sessionId = request.getParameter("sessionId");

        // Validate sessionId
        if (sessionId == null || !isValidSessionId(sessionId)) {
            response.setStatus(401); // Set HTTP 401 Unauthorized
            response.getWriter().write("Invalid or missing sessionId");
            return false; // Stop further processing
        }

        // SessionId is valid; continue with the request
        return true;
    }

    private boolean isValidSessionId(String sessionId) {
        // Your validation logic for sessionId goes here
        return "valid-session-id".equals(sessionId); // Example hardcoded validation
    }
}
