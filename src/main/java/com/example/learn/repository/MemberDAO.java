package com.example.learn.repository;

import com.example.learn.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
//    private JdbcTemplate jdbcTemplate; MemberDAO는 매퍼로 쓰여서 필요 없음
    MemberDTO getMemberByEmail(String email);
}
