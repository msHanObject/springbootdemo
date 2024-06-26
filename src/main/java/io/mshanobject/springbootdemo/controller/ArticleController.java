package io.mshanobject.springbootdemo.controller;

import io.mshanobject.springbootdemo.model.Article;
import io.mshanobject.springbootdemo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleController {

    //@Autowired
    //field injection is not recommended
    private final ArticleService articleService;

    /* 생성자 기반 의존성 주입은 @RequiredArgsConstructor 사용으로 생략 가능
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }*/

    // 글 목록 가져오기
    @GetMapping("/articles")
    public List<Article> getArticles() {
        // 글 전체보기 요청이 왔을때 모든 글을 조회해서 응답해준다.
        log.debug("전체보기 요청이 와서 실행됨.");
        return articleService.getArticles();
    }

    // articleId 로 글 상세보기
    @GetMapping("/articles/{articleId}")
    public Article getArticleById(@PathVariable BigInteger articleId) {
        return articleService.getArticleById(articleId);
    }

    // 공개 글 목록 가져오기
    //@GetMapping("/public/articles/")

    // 비공개 글 상세보기
    //@GetMapping("/private/articles/{articleId}")

    // 글쓰기
    @PostMapping("/articles")
    public void postArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }
}

