package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Article;
import io.mshanobject.springbootdemo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 글에 대한 기능을 포함하고 있다.
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    //@Autowired
    private final ArticleRepository articleRepository;

    // 전체 글보기
    public String getArticles() {
        return articleRepository.selectArticles();
    }

    // articleId 로 글 상세보기
    public String getArticleById(String articleId) {
        return articleRepository.selectArticleById(articleId);
    }

    @Override
    public String addArticle(Article article) {
        return articleRepository.insertArticle(article);
    }

    // 글 수정

    // 좋아요 누르기(좋아요 1 증가)

    // 글 삭제

    // 글쓰기

    // 페이징
    //public Page<>
}
