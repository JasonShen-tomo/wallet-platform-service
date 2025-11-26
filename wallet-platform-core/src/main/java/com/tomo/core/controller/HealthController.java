package com.tomo.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Health Check Controller
 * Used to verify if the Spring Boot application is running properly
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    /**
     * Health check endpoint
     * @return Application status information
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "UP");
        result.put("application", "Wallet Platform Core");
        result.put("timestamp", LocalDateTime.now());
        result.put("message", "Spring Boot application is running successfully!");
        return result;
    }

    /**
     * Welcome endpoint
     * @return Welcome information
     */
    @GetMapping("/welcome")
    public Map<String, String> welcome() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "Welcome to Wallet Platform Core Service");
        result.put("version", "1.0.0");
        result.put("framework", "Spring Boot 3.2.0");
        return result;
    }
}

