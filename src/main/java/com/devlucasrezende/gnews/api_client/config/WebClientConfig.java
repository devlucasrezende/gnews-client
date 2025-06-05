package com.devlucasrezende.gnews.api_client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gnews.base.url}")
    private String gnewsBaseUrl;

    @Bean
    public WebClient gnewsWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(gnewsBaseUrl).build();
    }
}