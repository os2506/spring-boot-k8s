package com.oss.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
}