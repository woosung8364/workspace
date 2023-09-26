package com.ezen.springmvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;
import com.ezen.springmvc.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService memberService;
		
	@Test
	public void isMemberTest() {
		String id = "song8364" , passwd ="1234";
		Member loginMember = memberService.isMember(id, passwd);
		log.info("로그인 사용자 정보 : {}" , loginMember);
	}
	

	

}