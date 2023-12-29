package com.example.learn.domain.article;

import com.example.learn.domain.article.dto.ArticleDTO;
import com.example.learn.domain.article.dto.ArticleWriteRequest;
import com.example.learn.global.SecurityUtils;
import com.example.learn.global.page.Pagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("offset") Integer offset,
            @RequestParam("direction") String direction
    ) {
        Pagination pagination = Pagination.of(pageNo, offset, direction);
        return ResponseEntity.ok(articleService.getAllArticles(pagination));
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> insertArticle(
            HttpServletRequest request,
            @Valid @RequestBody ArticleWriteRequest articleWriteRequest) {
        int id = SecurityUtils.getAuthenticationOrThrow(request).getId();
        return ResponseEntity.ok(articleService.insertArticle(id, articleWriteRequest));
    }

}
