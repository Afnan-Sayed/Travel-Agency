package org.example.TravelAgencyController.UserManagementInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{

    @Autowired
    private NormalUserSessionIdInterceptor normalUserSessionIdInterceptor;
    @Autowired
    private AdminUserSessionIdInterceptor adminUserSessionIdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        // event/hotel booking
        registry.addInterceptor(normalUserSessionIdInterceptor)
                .addPathPatterns("/*/book/*");

        // event/hotel cancellation
        registry.addInterceptor(normalUserSessionIdInterceptor)
                .addPathPatterns("/*/cancel/*");

        // dashboard
        registry.addInterceptor(normalUserSessionIdInterceptor)
                .addPathPatterns("/dashboard/**");

        // notification data & statistics
        registry.addInterceptor(adminUserSessionIdInterceptor)
                .addPathPatterns("/notifications/**");
    }
}