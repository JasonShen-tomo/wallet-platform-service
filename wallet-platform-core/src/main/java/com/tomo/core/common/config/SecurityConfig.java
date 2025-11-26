package com.tomo.core.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Configuration
 * Configure security policies and access control
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configure security filter chain
     * Currently permits all endpoints for development, add authentication later as needed
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF (for development, use with caution in production)
            .csrf(AbstractHttpConfigurer::disable)
            // Configure request authorization
            .authorizeHttpRequests(auth -> auth
                // Allow health check and welcome endpoints without authentication
                .requestMatchers("/api/health", "/api/welcome").permitAll()
                // Allow Actuator endpoints
                .requestMatchers("/actuator/**").permitAll()
                // Allow Swagger/Knife4j documentation access
                .requestMatchers("/doc.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                // Other requests require authentication (adjust as needed)
                .anyRequest().permitAll()  // Currently permit all, change to authenticated() later
            );

        return http.build();
    }
}

