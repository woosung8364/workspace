package com.ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SpringAOPTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void getMemberTest() {
		Member member = memberService.getMember("bangry");
		log.info("조회된 회원정보 : {}", member);
	}
	
}
