package com.lcwd.core.config;

import com.lcwd.core.couple.Samosa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {

    // declaring the bean using @Bean
        	@Bean(name="samosa1")
        	//@Primary
        	public Samosa getSamosa1(){
        		return new Samosa("spicy");
        	}

        	@Bean(name="samosa2")
        	public Samosa getSamosa2(){
        		return new Samosa("katha");
        	}
}
