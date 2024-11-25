package com.oss.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.oss.demo.entity.ArticleDTO;
import com.oss.demo.entity.ArticlesDTO;
import com.oss.demo.entity.CreateArticleRequest;
import com.oss.demo.service.ArticleService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class MyController {

	private final ArticleService articleService;

	@GetMapping("/test")
	public String testAPI() {
		return "Hello, World!";
	}

	@GetMapping
	public ArticlesDTO getArticles(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "") String query) {
		if (query == null || query.trim().length() == 0) {
			return articleService.getArticles(page);
		}
		return articleService.searchArticles(query, page);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ArticleDTO createArticle(@RequestBody @Valid CreateArticleRequest request) {
		return articleService.createArticle(request);
	}

}
