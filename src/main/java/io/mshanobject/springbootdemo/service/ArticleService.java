package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Article;

public interface ArticleService {
    // 전체 글보기
    public String getArticles();

    // articleId 로 글 상세보기
    public String getArticleById(String articleId);

    // 글 수정

    // 좋아요 누르기(좋아요 1 증가)

    // 글 삭제

    // 글쓰기
    public String addArticle(Article article);

    // 페이징
    //public Page<>
}