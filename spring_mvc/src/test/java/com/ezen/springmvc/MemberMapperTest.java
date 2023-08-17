package com.ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//Spring bean 등록과 함께 Spring 콘테이너 등록
@SpringBootTest
public class MemberMapperTest {

	@Autowired
	public MemberMapper memberMapper;

	
	@Test
	public void findByAllTest() {
		List<Member> list = memberMapper.findByAll();
		for (Member member : list) {
			log.info(member.toString());
		}

	}

}
