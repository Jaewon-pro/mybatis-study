package com.example.learn.domain.article.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Article {
    int aid;
    int wid;
    String writer;
    String title;
    LocalDateTime regdate;
    LocalDateTime moddate;
    int readCnt;

    @Builder
    public Article(int aid, int wid, String writer, String title, LocalDateTime regdate, LocalDateTime moddate, int readCnt) {
        this.aid = aid;
        this.wid = wid;
        this.writer = writer;
        this.title = title;
        this.regdate = regdate;
        this.moddate = moddate;
        this.readCnt = readCnt;
    }
}
