package com.ezen.springmvc.member;

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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	
//	전체회원 검색
	@Test
	@DisplayName("전체회원 검색")
	public void findByAllTest() {
		List<Member> list = memberMapper.findByAll();
		for (Member member : list) {
			log.info(member.toString());
		}
	}
	
	
//	회원 id로 특정 회원검색
	@Test
	@DisplayName("회원 id로 특정 회원검색")
//	@Disabled
	public void findByIdTest() {
//		찾을 이름설정 :: 데이타베이스에 해당 아이디가 존재해야함
//		없을시 NullpointerException 발생
		String memberId = "song8364";
		
		Member member = memberMapper.findById(memberId);
		
//		MemberId가 Null 이 아닌지 검증
		assertThat(memberId)
			.isNotNull();
		log.info("회원정보 : {}", member.toString());
	}
	
	
//	이름(키워드)로 특정 회원 검색
	@Test
//	@Disabled
	@DisplayName("이름(키워드)로 특정 회원 검색")
	void findByNameLikeTest() {
		String findName = "성";
		List<Member> list = memberMapper.findByNameLike(findName);
		log.info("이름 와일드카드 검색 : {}", list);
		for (Member member : list) {
			log.info("검색 키워드 : "+"'"+findName +"'"+ "/검색된 객체들 : {}",member.toString());
		}
	}
	
	
//	회원 등록
	@Test
//	@Disabled
	@DisplayName("회원등록")
	void createTest() {
		Member createMember = Member
				.builder()
				.id("harrypotter")
				.passwd("1111")
				.name("손흥민")
				.email("harry@gmail.com")
				.build();
		memberMapper.create(createMember);
		log.info("회원 등록 완료 : {}", createMember);
	}
	
//	회원 정보 수정
	@Test
//	@Disabled
	@DisplayName("회원 정보 수정")
	void updateTest() {
		Member updateMember = Member
				.builder()
				.id("monday")
				.passwd("2222")
				.build();
		memberMapper.update(updateMember);
		log.info("회원 수정 완료 : {}", updateMember);
	}
	
	
	@Test
//	@Disabled
	@DisplayName("검색 타입별 회원 검색")
	void findBySearchTypeTest() {
		//List<Member> list = memberMapper.findBySearchType("id", "bangry");
		List<Member> list = memberMapper.findBySearchType("name", "김");
		for (Member member : list) {
			log.info("검색 타입별 검색 회원 전체목록 : {}", member);
		}
		
	}
	
	
//	검색 키워드로 통합 검색
	@Test
//	@Disabled
	@DisplayName("검색 키워드로 통합 검색")
	void findBySearchAllTest() {
		List<Member> list = memberMapper.findBySearchAll("요일");
		for (Member member : list) {
			log.info("통합 검색된 객체 목록 : {}", member);
		}
		
	}
	
//	체크한 옵션으로 필터링 검색
	@Test
//	@Disabled
	@DisplayName("체크한 옵션으로 필터링 검색")
	void findBySearchAllOptionTest() {
		
//		검색 필터링 체크 옵션을 DTO로 구현한 클래스
		MemberSearchCondition searchCondition = 
				MemberSearchCondition
				.builder()
				.memberId("bangry")
//				.name("김")
//				.email("bangry@gmail.com")
				.build();
		
//		위에서 설정한 체크옵션을 담은 (객체)를 조건으로 검색
		List<Member> list = memberMapper.findBySearchAllOption(searchCondition);
		log.info("(필터링) 통합 검색된 객체 : {}", list);
		log.info("(필터링)검색된 객체의 수 : {}", list.size());
	}
	

}