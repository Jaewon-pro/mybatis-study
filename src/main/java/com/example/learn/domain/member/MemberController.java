package com.example.learn.domain.member;

import com.example.learn.domain.member.dto.LoginRequest;
import com.example.learn.domain.member.dto.MemberDTO;
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
    public ResponseEntity<MemberDTO> login(
            @Valid @RequestBody LoginRequest loginRequest,
            HttpServletRequest request) {
        return ResponseEntity.ok(memberService.login(loginRequest, request));
    }

    @GetMapping("/me")
    public ResponseEntity<MemberDTO> getMyInfo(
            HttpServletRequest request) {
        return ResponseEntity.ok(memberService.getMyInfo(request));
    }

}
