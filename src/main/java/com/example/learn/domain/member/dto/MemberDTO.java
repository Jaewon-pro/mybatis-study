package com.example.learn.domain.member.dto;

import com.example.learn.domain.member.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class MemberDTO {
    private final int id;
    private final String email;
    private final String name;
    private final LocalDateTime regdate;

    public static MemberDTO from(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getRegdate()
        );
    }

    private MemberDTO(
            int id,
            String email,
            String name,
            LocalDateTime regdate
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.regdate = regdate;
    }


}
