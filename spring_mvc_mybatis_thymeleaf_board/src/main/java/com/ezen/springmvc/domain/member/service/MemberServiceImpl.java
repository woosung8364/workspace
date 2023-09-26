package com.ezen.springmvc.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;

//	회원가입
	@Transactional
	public void register(Member member) {
		memberMapper.create(member);
		memberMapper.update(member);
		
	}

//	로그인 : 아이디 , 패스워드 일치 여부 확인
	
	@Override
	public Member isMember(String id, String passwd) {
		return memberMapper.findByIdAndPasswd(id, passwd);
	}

//	회원 전체조회
	
	@Override
	public List<Member> getMemberList() {
		return memberMapper.findByAll();
	}

//	아이디로 회원 찾기
	
	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}
	
}
