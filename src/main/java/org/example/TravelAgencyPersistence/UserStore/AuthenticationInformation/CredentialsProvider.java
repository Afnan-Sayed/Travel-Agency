package org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


@Repository
public class CredentialsProvider
{
    private final CredentialsRepository credentialsRepo;

    public CredentialsProvider(CredentialsRepository credentialsRepo)
    {
        this.credentialsRepo = credentialsRepo;
    }

    public HashMap<Integer, AuthenticationCredentials> getCredentialsOfAllUsers()
    {
        return credentialsRepo.getCredentialsOfAllUsers();
    }

    public AuthenticationCredentials getCredentialsByUserID(int userID)
    {
        AuthenticationCredentials credentials = credentialsRepo.getCredentialsByUserID(userID);
        if (credentials == null) {
            throw new IllegalArgumentException("User not found");
        }
        return credentials;
    }

    public ArrayList<AuthenticationCredentials> getCredentialsByUsername(String username) {
        return filterCredentialsByField("username", username);
    }

    public ArrayList<AuthenticationCredentials> getCredentialsByEmail(String email) {
        return filterCredentialsByField("email", email);
    }

    public ArrayList<AuthenticationCredentials> getCredentialsByPhoneNumber(String phoneNumber) {
        return filterCredentialsByField("phoneNumber", phoneNumber);
    }

    public void addCredentials(AuthenticationCredentials credentials)
    {
        validateUniqueFields(credentials);

        if ((credentials.getEmail() == null || credentials.getEmail().isEmpty()) &&
                (credentials.getPhoneNumber() == null || credentials.getPhoneNumber().isEmpty())) {
            throw new IllegalArgumentException("At least one contact method (email or phone number) must be provided");
        }

        credentialsRepo.addCredentials(credentials);
    }
    public void updateCredentials(int userID, AuthenticationCredentials newCredentials)
    {
        AuthenticationCredentials existing = credentialsRepo.getCredentialsByUserID(userID);
        if (existing == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (newCredentials.getEmail() != null && !newCredentials.getEmail().equals(existing.getEmail())) {
            if (!getCredentialsByEmail(newCredentials.getEmail()).isEmpty()) {
                throw new IllegalArgumentException("Email already taken");
            }
        }

        if (newCredentials.getPhoneNumber() != null && !newCredentials.getPhoneNumber().equals(existing.getPhoneNumber())) {
            if (!getCredentialsByPhoneNumber(newCredentials.getPhoneNumber()).isEmpty()) {
                throw new IllegalArgumentException("Phone number already taken");
            }
        }

        if (newCredentials.getPassword() != null) {
            existing.setPassword(newCredentials.getPassword());
        }

        if (newCredentials.getEmail() != null) {
            existing.setEmail(newCredentials.getEmail());
        }

        if (newCredentials.getPhoneNumber() != null) {
            existing.setPhoneNumber(newCredentials.getPhoneNumber());
        }

        if (newCredentials.getAccountStatus() <= 3 && newCredentials.getAccountStatus() >= 0) {
            existing.setAccountStatus(newCredentials.getAccountStatus());
        }

        credentialsRepo.updateCredentials(userID, existing);
    }

    private void validateUniqueFields(AuthenticationCredentials credentials)
    {
        if (!getCredentialsByUsername(credentials.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("Username already taken");
        }

        if (!getCredentialsByEmail(credentials.getEmail()).isEmpty()) {
            throw new IllegalArgumentException("Email already taken");
        }

        if (!getCredentialsByPhoneNumber(credentials.getPhoneNumber()).isEmpty()) {
            throw new IllegalArgumentException("Phone number already taken");
        }
    }

    private ArrayList<AuthenticationCredentials> filterCredentialsByField(String field, String value)
    {
        return getCredentialsOfAllUsers()
                .values()
                .stream()
                .filter(credentials ->
                {
                    switch (field)
                    {
                        case "username":
                            return credentials.getUsername().equalsIgnoreCase(value);
                        case "email":
                            return credentials.getEmail().equalsIgnoreCase(value);
                        case "phoneNumber":
                            return credentials.getPhoneNumber().equalsIgnoreCase(value);
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }
}