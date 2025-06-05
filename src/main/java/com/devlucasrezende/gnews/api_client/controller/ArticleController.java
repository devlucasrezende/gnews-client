package com.devlucasrezende.gnews.api_client.controller;

import com.devlucasrezende.gnews.api_client.dto.ArticleDTO;
import com.devlucasrezende.gnews.api_client.dto.GNewsApiResponseDTO;
import com.devlucasrezende.gnews.api_client.service.GNewsService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/news")
public class ArticleController {

    private final GNewsService gNewsService;

    public ArticleController(GNewsService gNewsService) {
        this.gNewsService = gNewsService;
    }

    @GetMapping("/search")
    private Mono<List<ArticleDTO>> searchNews(@RequestParam String q) {
        return gNewsService.searchArticles(q).map(GNewsApiResponseDTO::getArticles);
    }
}
