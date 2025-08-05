package com.ochwada.product.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * *******************************************************
 * Package: com.ochwada.product.config
 * File: SecurityConfig.java
 * Author: Ochwada
 * Date: Tuesday, 05.Aug.2025, 10:57 AM
 * Description: Configures Spring Security to protect all endpoints using OAuth2 with JWT tokens.
 * -  This setup is designed for applications acting as resource servers (e.g., for APIs secured by Auth0, Keycloak, etc.).
 * Objective:
 *  - Enforce authentication for every incoming HTTP request.
 *  - Accept and validate JWT tokens issued by a configured OAuth2 provider.
 *  - Provide a customizable security filter chain using Spring Security.
 * *******************************************************
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines the security filter chain for HTTP requests.
     *
     * @param httpSecurity HttpSecurity instance used to configure security rules.
     * @return A built SecurityFilterChain bean.
     * @throws Exception in case of configuration errors.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        // Uncomment the line below to allow public access to /home endpoint
                        //.requestMatchers("/home").permitAll()

                        // Require authentication for all other endpoints
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(
                        oauth2 -> oauth2
                                .jwt(jwtConfigurer -> {
                                    // Use default JWT decoder based on spring.security.oauth2.resourceserver.jwt.issuer-uri
                                    // You can add a custom converter/decoder here if needed
                                })
                );


        return httpSecurity.build();
    }
}
