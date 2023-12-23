package com.example.learn.domain.article;

import com.example.learn.domain.article.entity.Article;
import com.example.learn.domain.article.entity.ArticleContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    List<Article> getAllArticles();

    void insertArticle(Article article);

    void insertArticleContent(ArticleContent articleContent);

}
