package com.example.learn.domain.member;

import com.example.learn.domain.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
//    private JdbcTemplate jdbcTemplate; MemberDAO는 매퍼로 쓰여서 필요 없음
    Member getMemberByEmail(String email);
}
