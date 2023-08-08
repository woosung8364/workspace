package com.ezen.mybatis.domain.member;

import java.util.List;

import com.ezen.mybatis.domain.member.dto.Member;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 김기정
 *
 */
public interface MemberDao {
	
	public boolean create(Member member);
	public List<Member> findByAll();
	public Member findById(String id);
	public Member findByUser(String id, String passwd);
	
	
	
	
}
