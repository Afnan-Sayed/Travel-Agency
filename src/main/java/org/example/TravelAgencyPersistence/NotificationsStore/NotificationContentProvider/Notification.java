package src.main.java.org.example.TravelAgencyPersistence.NotificationsStore.NotificationContentProvider;

import src.main.java.org.example.TravelAgencyApplication.NotificationManagement.NotificationMaker.Template;

import java.security.PublicKey;
import java.util.ArrayList;

public class Notification {
    public int templateID;
    public int receiverID;
    public String message;
    public String mail;
    public String phoneNumber;
    public int status;
}
