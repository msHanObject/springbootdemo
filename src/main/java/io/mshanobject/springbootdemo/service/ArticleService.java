package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Article;

import java.math.BigInteger;
import java.util.List;

public interface ArticleService {
    // 전체 글보기
    public List<Article> getArticles();

    // articleId 로 글 상세보기
    public Article getArticleById(BigInteger articleId);

    // 글 수정

    // 좋아요 누르기(좋아요 1 증가)

    // 글 삭제

    // 글쓰기
    public void addArticle(Article article);

    // 페이징
    //public Page<>
}
