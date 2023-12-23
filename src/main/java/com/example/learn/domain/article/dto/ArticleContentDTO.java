package com.example.learn.domain.article.dto;

import com.example.learn.domain.article.entity.ArticleContent;

public record ArticleContentDTO(
        int aid,
        int wid,
        String writer,
        String title,
        String content
) {
//    public static ArticleContentDTO from(ArticleContent articleContent) {
//        return new ArticleContentDTO(
//                articleContent.getAid(),
//                articleContent.getWid(),
//                articleContent.getWriter(),
//                articleContent.getTitle(),
//                articleContent.getContent()
//        );
//    }
}
