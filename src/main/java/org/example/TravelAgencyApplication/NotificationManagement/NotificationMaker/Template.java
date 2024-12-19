package org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker;

import java.util.ArrayList;

public class Template {
    private int ID; //set in constructor
    private String specialCharacter; // set in constructor
    public ArrayList<String> messages;
    //index 0:English
    //index 1:Arabic
    //index 2:French
    //index 3:German
    public int getID() {
        return ID;
    }

    public String getSpecialCharacter() {
        return specialCharacter;
    }
}
