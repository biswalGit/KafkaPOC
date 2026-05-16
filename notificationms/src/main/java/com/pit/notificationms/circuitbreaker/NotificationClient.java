package com.pit.notificationms.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationClient {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "notification-service",
            fallbackMethod = "fallback")
    public String callNotificationService() {

        return restTemplate.getForObject(
                "http://localhost:8082/api",
                String.class);
    }

    public String fallback(Exception ex) {

        return "Fallback Response";
    }
}
