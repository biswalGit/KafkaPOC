package com.pit.auditms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public StringJsonMessageConverter jsonMessageConverter() {
        return new StringJsonMessageConverter();
    }
}
