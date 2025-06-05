package com.devlucasrezende.gnews.api_client.dto;

import java.time.Instant;
import lombok.Data;

@Data
public class ArticleDTO {

    private String title;
    private String description;
    private String content;
    private String url;
    private String image;
    private Instant publishedAt;
    private SourceDTO source;

}
