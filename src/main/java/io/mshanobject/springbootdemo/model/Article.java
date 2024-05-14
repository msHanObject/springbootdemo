package io.mshanobject.springbootdemo.model;


import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Article {

    private Long id;
    private String title;
    private String author;
    private String content;
    private int likes;

}
