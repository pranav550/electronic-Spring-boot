package org.example.Config;

import org.example.web.AuthController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    public AuthController authController(){
        return new AuthController();
    }
}
