package com.example.learn.domain.article;

import com.example.learn.domain.article.entity.Article;
import com.example.learn.domain.article.entity.ArticleContent;
import com.example.learn.global.page.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    List<Article> getAllArticles();
    List<Article> getAllArticlesByPagination(Pagination pagination);

    void insertArticle(Article article);

    void insertArticleContent(ArticleContent articleContent);

}
