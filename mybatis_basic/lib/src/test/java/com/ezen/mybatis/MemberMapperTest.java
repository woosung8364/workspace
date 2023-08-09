package com.ezen.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import com.ezen.mybatis.domain.member.MemberDao;
import com.ezen.mybatis.domain.member.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberMapperTest {
	SqlSession sqlSession;	
	
	@BeforeEach
	public void setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	public void createTest(){
		
		System.out.println("==================== 새로운 멤버 생성 ========================");
		

		Member member = new Member();
		member.setId("song8364");
		member.setName("송우성");
		member.setEmail("song8364@naver.com");
		member.setPasswd("seo8364");
		member.setRegdate("20230809");
		
//		myBatis 에서 mapper proxy 라는 EmployeeMapper 인터페이스의 구현체 클래스를 만들어서 리턴
		MemberDao mapper = sqlSession.getMapper(MemberDao.class);
		mapper.create(member);
		
		
//		{} : 값 , mapper 변수의 값을 로그로 출력하는 코드	
		log.debug("멤버등록 완료 : {}", member);
		
		
		
		sqlSession.close();

	}
	
	@Test
	public void findByAllTest(){
		System.out.println("==================== 전체 멤버 조회 ========================");
		MemberDao mapper = sqlSession.getMapper(MemberDao.class);
		List<Member> findMembers = mapper.findByAll();
//		자바 스크립트식 forEach 사용하기
		findMembers.forEach( (member)  ->{
			log.debug("검색된 사원 : {}",member);
		});
	
		sqlSession.close();
	}
	
	
	@Test
	public void findByIdTest(String id){
		System.out.println("==================== 전체 멤버 조회 ========================");
		MemberDao mapper = sqlSession.getMapper(MemberDao.class);
		Member findId = mapper.findById(id);
		log.debug("id로 검색된 멤버 : {}" , findId);
//		자바 스크립트식 forEach 사용하기
	
		sqlSession.close();
	}
	
	
	@Test
	public void findByUserTest(String id , String passwd){
		System.out.println("==================== 전체 멤버 조회 ========================");
		MemberDao mapper = sqlSession.getMapper(MemberDao.class);
		Member findUser = mapper.findByUser(id , passwd);
		log.debug("id와 pw로 검색된 멤버 : {}" , findUser);
//		자바 스크립트식 forEach 사용하기
	
		sqlSession.close();
	}
	
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







