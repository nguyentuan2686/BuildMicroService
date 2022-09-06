package com.example.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Author TuanNA
 * @Date 06/06/2022 10:32 PM
 * @Version 1.0
 */
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
