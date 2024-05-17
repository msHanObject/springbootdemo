package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Article;
import io.mshanobject.springbootdemo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    /*
     * @Slf4j 롬복을 쓰면 아래 코드를 자동 생성 해줌
     * private static final Logger log = LoggerFactory.getLogger(ArticleService.class);
     */

    //@Autowired
    private final ArticleRepository articleRepository;

    // 전체 글보기
    public List<Article> getArticles() {
        log.debug("서비스 메소드 실행");
        return articleRepository.selectArticles();
    }

    // articleId 로 글 상세보기
    public Article getArticleById(BigInteger articleId) {
        return articleRepository.selectArticleById(articleId);
    }

    @Override
    public void addArticle(Article article) {
        articleRepository.insertArticle(article);
    }

    // 글 수정

    // 좋아요 누르기(좋아요 1 증가)

    // 글 삭제

    // 글쓰기

    // 페이징
    //public Page<>
}
