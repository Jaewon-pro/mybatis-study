package com.example.learn.service;

import com.example.learn.dto.LoginInfo;
import com.example.learn.dto.MemberDTO;
import com.example.learn.repository.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberDAO memberDAO;

    public MemberDTO login(LoginInfo form, HttpServletRequest request) {

        MemberDTO memberDTO = memberDAO.getMemberByEmail(form.email());
        if (memberDTO == null) {
            throw new IllegalStateException("없는 계정 입니다");
        }
        if (!form.password().equals(memberDTO.password())) {
            throw new IllegalStateException("암호가 일치하지 않습니다.");
        }

        setAuthentication(request, memberDTO);
        return memberDTO;
    }

    private void setAuthentication(HttpServletRequest request, MemberDTO memberDTO) {
        HttpSession session = request.getSession();
        session.setAttribute("member", memberDTO);
    }

}
