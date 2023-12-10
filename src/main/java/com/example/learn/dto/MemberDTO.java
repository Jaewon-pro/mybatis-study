package com.example.learn.dto;

public record MemberDTO(
        int id,
        String email,
        String password,
        String name,
        String regdate
) {
}
