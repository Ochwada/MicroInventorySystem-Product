package com.ochwada.product.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.product.config
 * File: AppConfig.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 10:46 AM
 * Description: Configuration class for application-level beans.
 * Objective: Define and expose reusable Spring-managed components that can be injected into other parts of the application.
 * *******************************************************
 */

@Configuration
public class AppConfig {

    /**
     * Creates and registers a {@link RestTemplate} bean.
     *
     * @return a new instance of {@code RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
