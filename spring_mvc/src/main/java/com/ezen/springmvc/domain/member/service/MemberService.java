package com.ezen.springmvc.domain.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ezen.springmvc.domain.member.dto.Member;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * 08/18 추가됨
 */

public interface MemberService {

//	회원가입
	public void register(Member member);
	
//	회원인지 여부 , 로그인
	public Member isMember(String id , String passwd);
	
//	전체 회원 목록
	public List<Member> getMemberList();
	
//	특정 회원 검색
	public Member getMember(String id);
}
