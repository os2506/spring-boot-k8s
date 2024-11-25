package com.oss.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.oss.demo.entity.Article;
import com.oss.demo.entity.ArticleDTO;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("""
    select new com.oss.demo.entity.ArticleDTO(a.id, a.title, a.url, a.createdAt) from Article a
    """)
    Page<ArticleDTO> findBy(Pageable pageable);

    @Query("""
    select new com.oss.demo.entity.ArticleDTO(a.id, a.title, a.url, a.createdAt) from Article a
    where lower(a.title) like lower(concat('%', :query, '%'))
    """)
    Page<ArticleDTO> searchArticles(String query, Pageable pageable);

    Page<ArticleDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);

    //Page<BookmarkVM> findByTitleContainsIgnoreCase(String query, Pageable pageable);

}