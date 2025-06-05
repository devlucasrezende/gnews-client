package com.devlucasrezende.gnews.api_client.dto;

import lombok.Data;
import java.util.List;

@Data
public class GNewsApiResponseDTO {
    private Integer totalArticles;
    private List<ArticleDTO> articles;
}