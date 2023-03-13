package org.example.Config;

import org.example.beans.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example","another.world"})
public class AppConfig {

    @Bean("cartService1")
    public CartService cartService(){
        return new CartService();
    }
}
