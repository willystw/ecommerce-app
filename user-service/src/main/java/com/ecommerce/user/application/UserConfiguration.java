package com.ecommerce.user.application;

import com.ecommerce.auth.filter.UserAuthenticatedHandlerInterceptor;
import com.ecommerce.user.api.AuthAPI;
import com.ecommerce.user.api.AuthAPIImpl;
import com.ecommerce.user.api.UserAPI;
import com.ecommerce.user.api.UserAPIImpl;
import com.ecommerce.user.security.UserDataService;
import com.ecommerce.user.security.UserDataServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
@Import({WebSecurityConfiguration.class})
public class UserConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder();
    }

    @Bean
    public UserDataService userDataService() {
        return new UserDataServiceImpl();
    }

    @Bean
    public AuthAPI authAPI() {
        return new AuthAPIImpl();
    }

    @Bean
    public UserAPI userAPI() {
        return new UserAPIImpl();
    }

    @Bean
    public MappedInterceptor authFilterHandlerInterceptor() {
        return new MappedInterceptor(null, new UserAuthenticatedHandlerInterceptor());
    }
}
