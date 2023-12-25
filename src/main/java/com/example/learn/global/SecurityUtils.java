package com.example.learn.global;

import com.example.learn.domain.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public final class SecurityUtils {

    private static final String SESSION_ATTRIBUTE_NAME = "member";


    public static void setAuthentication(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ATTRIBUTE_NAME, member);
    }

    public static Optional<Member> getAuthentication(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return Optional.empty();
        }
        Member member = (Member) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        return Optional.ofNullable(member);
    }

    public static Member getAuthenticationOrThrow(HttpServletRequest request) {
        return SecurityUtils.getAuthentication(request)
                .orElseThrow(() -> new IllegalStateException("현재 로그인된 상태가 아닙니다"));
    }

    private SecurityUtils() {
    }
}
