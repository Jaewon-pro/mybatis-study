package com.example.learn.domain.article.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Article {
    private int aid;
    private int wid;
    private String writer;
    private String title;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
    private int readCnt;

    @Builder
    public Article(int wid, String writer, String title, LocalDateTime regdate, LocalDateTime moddate, int readCnt) {
        this.wid = wid;
        this.writer = writer;
        this.title = title;
        this.regdate = regdate;
        this.moddate = moddate;
        this.readCnt = readCnt;
    }
}
