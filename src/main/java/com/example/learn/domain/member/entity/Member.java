package com.example.learn.domain.member.entity;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Member {
    private int id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;

    public Member(
            int id,
            String email,
            String password,
            String name,
            LocalDateTime regdate
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.regdate = regdate;
    }

}
