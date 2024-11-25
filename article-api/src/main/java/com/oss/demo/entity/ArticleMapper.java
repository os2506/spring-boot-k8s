package com.oss.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDTO toDTO(Article article) {
        return new ArticleDTO(
        		article.getId(),
        		article.getTitle(),
        		article.getUrl(),
        		article.getCreatedAt()
        );
    }
}
