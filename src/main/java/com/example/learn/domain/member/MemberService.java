package com.example.learn.domain.member;

import com.example.learn.domain.member.dto.LoginRequest;
import com.example.learn.domain.member.dto.MemberDTO;
import com.example.learn.domain.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberDAO memberDAO;

    private static final String SESSION_ATTRIBUTE_NAME = "member";

    public MemberDTO login(LoginRequest form, HttpServletRequest request) {

        Member member = memberDAO.getMemberByEmail(form.email());
        if (member == null) {
            throw new IllegalStateException("없는 계정 입니다");
        }
        if (!form.password().equals(member.getPassword())) {
            throw new IllegalStateException("암호가 일치하지 않습니다");
        }

        setAuthentication(request, member);
        return MemberDTO.from(member);
    }

    public MemberDTO getMyInfo(HttpServletRequest request) {
        Member member = getAuthentication(request)
                .orElseThrow(() -> new IllegalStateException("현재 로그인된 상태가 아닙니다"));
        return MemberDTO.from(member);
    }

    private void setAuthentication(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ATTRIBUTE_NAME, member);
    }

    private Optional<Member> getAuthentication(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return Optional.empty();
        }
        Member member = (Member) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        return Optional.ofNullable(member);
    }

}
