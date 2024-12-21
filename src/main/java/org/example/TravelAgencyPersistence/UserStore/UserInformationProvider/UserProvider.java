package org.example.TravelAgencyPersistence.UserStore.UserInformationProvider;

import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.CredentialsProvider;
import org.example.TravelAgencyPersistence.UserStore.AuthenticationInformation.CredentialsRepository;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoProvider;
import org.example.TravelAgencyPersistence.UserStore.PersonalInformation.UserPersonalInfoRepository;

public class UserProvider
{
    private static UserProvider provider;
    private final AuthenticationCredentialsProvider authProvider;
    private final PersonalInfoProvider perProvider;

    private UserProvider()
    {
        CredentialsRepository CredRepo = new CredentialsRepository();
        UserPersonalInfoRepository PerRepo = new UserPersonalInfoRepository();

        CredentialsProvider CP = new CredentialsProvider(CredRepo, PerRepo);
        UserPersonalInfoProvider PP = new UserPersonalInfoProvider(PerRepo);

        authProvider = new AuthenticationCredentialsProvider(CP);
        perProvider = new PersonalInfoProvider(PP);
    }

    public AuthenticationCredentialsProvider getCredentialsProvider()
    {
        return authProvider;
    }
    public PersonalInfoProvider getPersonalInfoProvider()
    {
        return perProvider;
    }

    public static synchronized UserProvider getInstance()
    {
        if (provider == null)
            provider = new UserProvider();
        return provider;
    }
}