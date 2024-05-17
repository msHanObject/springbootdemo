package io.mshanobject.springbootdemo.model;


import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Article {

    private Long id;
    private String title;
    private String author;
    private String content;
    private Long likes;

}
