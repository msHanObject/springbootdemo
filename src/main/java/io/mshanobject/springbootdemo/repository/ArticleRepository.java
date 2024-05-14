package io.mshanobject.springbootdemo.repository;

import org.springframework.stereotype.Repository;

// Articles 테이블과 1:1 매핑
@Repository
public class ArticleRepository {

    // Article 테이블에서 모든 글 보기
    // select * from article;
    public String selectArticles() {
        // 실제 쿼리 수행
        return "data from db";
    }

    public String selectArticleById(String articleId) {
        return articleId + "번 글 상세내용입니다.";
    }
}
