package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Article;
import io.mshanobject.springbootdemo.repository.ArticleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@SpringBootTest
public class ArticleServiceTests {

    @Qualifier("articleRepository")
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testGetArticles() {
        // 성공조건: 글 전체조회해서 결과가 하나 이상 조회되면 성공
        List<Article> articles = articleRepository.selectArticles();

        Assertions.assertFalse(articles.isEmpty());
    }

    @Test
    public void testGetArticleById() {
        // 성공조건: articleId 2번으로 조회시 content가 "내용2"이면 성공
        Article article = articleRepository.selectArticleById(BigInteger.valueOf(2));

        Assertions.assertEquals("내용2", article.getContent());
    }

    @Transactional // 테스트 후 데이터 원복해주는 어노테이션
    @Test
    public void testAddArticle() {
        // 성공조건: article을 ("5", "글 제목", "글 작성자", "글 내용", "0") 으로 등록후
        articleRepository.insertArticle(new Article(5L, "글 제목", "글 작성자", "글 내용", 0L));
        Article article = articleRepository.selectArticleById(BigInteger.valueOf(5));

        Assertions.assertEquals("글 내용", article.getContent());
    }
}
