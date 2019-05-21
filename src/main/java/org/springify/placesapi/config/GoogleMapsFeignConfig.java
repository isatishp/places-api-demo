package org.springify.placesapi.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleMapsFeignConfig {

    @Value("${googlemaps.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.query("key", apiKey);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
