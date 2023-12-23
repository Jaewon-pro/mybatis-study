package com.example.learn.domain.article;

import com.example.learn.domain.article.dto.ArticleDTO;
import com.example.learn.domain.article.dto.ArticleWriteRequest;
import com.example.learn.domain.article.entity.Article;
import com.example.learn.domain.article.entity.ArticleContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleDAO articleDAO;

    public List<ArticleDTO> getAllArticles() {
        return articleDAO.getAllArticles()
                .stream()
                .map(ArticleDTO::from)
                .toList();
    }

    public ArticleDTO insertArticle(int writerId, ArticleWriteRequest articleWriteRequest) {
        Article article = Article.builder()
                .wid(writerId)
                .title(articleWriteRequest.title())
                .regdate(LocalDateTime.now())
                .build();
        ArticleContent articleContent = new ArticleContent(article.getAid(), articleWriteRequest.content());
        articleDAO.insertArticle(article);
        articleDAO.insertArticleContent(articleContent);
        return ArticleDTO.from(article);
    }

}
