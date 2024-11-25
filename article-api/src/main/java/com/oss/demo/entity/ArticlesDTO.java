package com.oss.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import java.util.List;

@Setter
@Getter
public class ArticlesDTO {
    private List<ArticleDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public ArticlesDTO(Page<ArticleDTO> articlePage) {
        this.setData(articlePage.getContent());
        this.setTotalElements(articlePage.getTotalElements());
        this.setTotalPages(articlePage.getTotalPages());
        this.setCurrentPage(articlePage.getNumber() + 1);
        this.setFirst(articlePage.isFirst());
        this.setLast(articlePage.isLast());
        this.setHasNext(articlePage.hasNext());
        this.setHasPrevious(articlePage.hasPrevious());
    }
}
