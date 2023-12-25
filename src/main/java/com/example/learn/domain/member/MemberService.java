package com.example.learn.domain.member;

import com.example.learn.domain.member.dto.LoginRequest;
import com.example.learn.domain.member.dto.MemberDTO;
import com.example.learn.domain.member.entity.Member;
import com.example.learn.global.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberDAO memberDAO;


    public MemberDTO login(LoginRequest form, HttpServletRequest request) {

        Member member = memberDAO.getMemberByEmail(form.email());
        if (member == null) {
            throw new IllegalStateException("없는 계정 입니다");
        }
        if (!form.password().equals(member.getPassword())) {
            throw new IllegalStateException("암호가 일치하지 않습니다");
        }

        SecurityUtils.setAuthentication(request, member);
        return MemberDTO.from(member);
    }

    public MemberDTO getMyInfo(HttpServletRequest request) {
        Member member = SecurityUtils.getAuthenticationOrThrow(request);
        return MemberDTO.from(member);
    }


}
