package com.shehnaz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //creating Rest Template Object
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
