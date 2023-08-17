package com.ezen.springmvc.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;

@Mapper
public interface MemberMapper {
	
//	회원 통합검색
	public List<Member> findByAll();
	
//	회원 id로 특정 회원 검색
	public Member findById(String id);
	
//	이름으로 특정 회원 검색
	public List<Member> findByNameLike(String name);
	
//	회원가입
	public void create(Member member);
	
//	회원정보수정
	public void update(Member member);
	
	
//	검색 타입별 회원 검색 @param : SQL #{type} 매게변수랑 String type 매게변수랑 연동
	public List<Member> findBySearchType(@Param("type") String type, @Param("value") String value);
	
//	검색값으로 통합 검색
	public List<Member> findBySearchAll(String value);
	
//	체크한 옵션을 바탕으로 필터링해서 검색
	public List<Member> findBySearchAllOption(MemberSearchCondition searchCondition);
}
