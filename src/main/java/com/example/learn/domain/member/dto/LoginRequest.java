package com.example.learn.domain.member.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "이메일을 입력해야 합니다.")
        String email,
        @NotBlank(message = "비밀번호를 입력해야 합니다.")
        String password
) {
}
