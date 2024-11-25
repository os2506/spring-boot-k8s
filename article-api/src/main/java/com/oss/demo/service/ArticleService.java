package com.oss.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oss.demo.entity.Article;
import com.oss.demo.entity.ArticleDTO;
import com.oss.demo.entity.ArticleMapper;
import com.oss.demo.entity.ArticlesDTO;
import com.oss.demo.entity.CreateArticleRequest;
import com.oss.demo.repository.ArticleRepository;
import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
    private final ArticleMapper articleMapper;

    @Transactional(readOnly = true)
    public ArticlesDTO getArticles(Integer page) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<ArticleDTO> articlePage = repository.findBy(pageable);
        return new ArticlesDTO(articlePage);
    }

    @Transactional(readOnly = true)
    public ArticlesDTO searchArticles(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        //Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query, pageable);
        Page<ArticleDTO> articlePage = repository.findByTitleContainsIgnoreCase(query, pageable);
        return new ArticlesDTO(articlePage);
    }

    public ArticleDTO createArticle(CreateArticleRequest request) {
        Article article = new Article(null, request.getTitle(), request.getUrl(), Instant.now());
        Article savedArticle = repository.save(article);
        return articleMapper.toDTO(savedArticle);
    }
}
