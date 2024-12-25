package org.example.TravelAgencyApplication.UserManagement.Authentication;

import java.util.HashMap;
import java.util.Random;

public class SessionManager {
    private HashMap<String, String> sessionMap;

    private static SessionManager instance;
    public static SessionManager getInstance() {
        if (instance == null) instance = new SessionManager();
        return instance;
    }

    private SessionManager() {
        sessionMap = new HashMap<>();
    }

    public String generateSessionID(String userID) {
        String sessionID = ""+new Random().nextInt(1, 1<<30);
        while (sessionMap.containsValue(sessionID)) sessionID = ""+new Random().nextInt(1, 1<<30);
        sessionMap.put(userID, sessionID);
        return sessionID;
    }

    public boolean correctID(String sessionID, String userID) {
        return sessionMap.containsKey(userID) && sessionMap.get(userID).equals(sessionID);
    }
}
