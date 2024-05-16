package io.mshanobject.springbootdemo.repository;

import io.mshanobject.springbootdemo.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

// Articles 테이블과 1:1 매핑
@Mapper
@Repository
public interface ArticleRepository {
    public List<Article> selectArticles();
    public Article selectArticleById(BigInteger articleId);
    public void insertArticle(Article article);
}
