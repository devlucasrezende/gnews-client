package com.devlucasrezende.gnews.api_client.service;

import com.devlucasrezende.gnews.api_client.dto.GNewsApiResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class GNewsService {

    @Value("${gnews.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public GNewsService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<GNewsApiResponseDTO> searchArticles(String query) {
        return webClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("q", query)
                .queryParam("apikey", apiKey)
                .build())
                .retrieve()
                .bodyToMono(GNewsApiResponseDTO.class);
    }

}
