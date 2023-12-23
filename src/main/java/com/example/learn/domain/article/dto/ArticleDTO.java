package com.example.learn.domain.article.dto;

import com.example.learn.domain.article.entity.Article;

import java.time.LocalDateTime;

public record ArticleDTO(
        int aid,
        int wid,
        String writer,
        String title,
        LocalDateTime regdate,
        LocalDateTime moddate,
        int readCnt
) {
    public static ArticleDTO from(Article article) {
        return new ArticleDTO(
                article.getAid(),
                article.getWid(),
                article.getWriter(),
                article.getTitle(),
                article.getRegdate(),
                article.getModdate(),
                article.getReadCnt()
        );
    }
}
