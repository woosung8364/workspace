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
	
	private final MemberMapper memberMapper;

//	회원가입
	@Transactional
	public void register(Member member) {
		memberMapper.create(member);
		memberMapper.update(member);
		
	}


	@Override
	public Member isMember(String id, String passwd) {
		return memberMapper.findByIdAndPasswd(id, passwd);
	}

	@Override
	public List<Member> getMemberList() {
		return memberMapper.findByAll();
	}

	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}
	
}
