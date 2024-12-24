package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class IDGenerator
{
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Set<Integer> generatedIDs = new HashSet<>();

    public static int generateID()
    {
        int id;
        do
        {
            id = secureRandom.nextInt(Integer.MAX_VALUE); //generates a random +ve int
        }
        while (generatedIDs.contains(id)); //checks if ID already exists

        generatedIDs.add(id);
        return id;
    }
}