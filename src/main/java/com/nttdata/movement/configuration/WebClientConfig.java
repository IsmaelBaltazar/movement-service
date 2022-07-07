package com.nttdata.movement.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @LoadBalanced
    @Bean
    public WebClient.Builder webclient(){
        return WebClient.builder().baseUrl("lb://account-service");
    }
}
