package com.example.learn.controller;

import com.example.learn.dto.LoginInfo;
import com.example.learn.dto.MemberDTO;
import com.example.learn.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public ResponseEntity<MemberDTO> validateLogin(
            @Valid @RequestBody LoginInfo loginInfo,
            HttpServletRequest request) {
        return ResponseEntity.ok(memberService.login(loginInfo, request));
    }

}
