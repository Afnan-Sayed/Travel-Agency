//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.TravelAgencyPersistence.UserStore.UserInformationProvider.IUserProvider;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class SessionIdInterceptor implements HandlerInterceptor
//{
//
//    private final IUserProvider userProvider;
//    public SessionIdInterceptor(IUserProvider userProvider) {
//        this.userProvider = userProvider;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception
//    {
//        // Retrieve sessionId from the request parameters
//        String sessionId = request.getParameter("sessionId");
//        if (sessionId == null)
//        {
//            response.setStatus(401); // Unauthorized
//            response.getWriter().write("Missing sessionId");
//            return false; // Stop further processing
//        }
//
//        // Retrieve the userId or role from session or database based on sessionId
//        Integer role = userService.getRoleBySessionId(sessionId);
//        if (role == null) {
//            response.setStatus(401); // Unauthorized
//            response.getWriter().write("Invalid sessionId");
//            return false; // Stop further processing
//        }
//
//        // Validate sessionId and role
//        if (!isValidSessionId(sessionId, role)) {
//            response.setStatus(401); // Unauthorized
//            response.getWriter().write("Invalid sessionId/role");
//            return false; // Stop further processing
//        }
//
//        // SessionId is valid; continue with the request
//        return true;
//    }
//
//    private boolean isValidSessionId(String sessionId, int role) {
//        // Replace this logic with actual session validation
//        if ("valid-session-id".equals(sessionId)) {
//            // Check if the role matches the session ID (0 for normal user, 1 for admin)
//            return (role == 1 || role == 0);
//        }
//        return false;
//    }
//}
