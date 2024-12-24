//package org.example.TravelAgencyController.UserManagementInterface.LoginInterface;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer
//{
//
//    @Autowired
//    private SessionIdInterceptor sessionIdInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // Admin-only paths
//        registry.addInterceptor(sessionIdInterceptor)
//                .addPathPatterns("/admin/**");
//
//        // User-only paths
//        registry.addInterceptor(sessionIdInterceptor)
//                .addPathPatterns("/user/**");
//    }
//}