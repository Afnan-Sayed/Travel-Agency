package org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker;

import java.util.ArrayList;

public abstract class Template {
    protected int ID; //set in constructor
    protected String specialCharacter; // set in constructor
    public ArrayList<String> messages;

    public Template(int id, String specialCharacter)
    {
        this.specialCharacter=specialCharacter;
        this.ID=id;
    }

    //index 0:English
    //index 1:Arabic
    //index 2:French
    //index 3:German
    //dear X, sdsafsd
    public int getID() {
        return ID;
    }
    public abstract String getSpecialCharacter();
}
