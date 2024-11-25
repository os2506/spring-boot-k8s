package com.oss.demo.entity;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Setter
@Getter
public class CreateArticleRequest {
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotEmpty(message = "Url should not be empty")
    private String url;
}
