package com.ezen.mybatis.domain;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import com.ezen.mybatis.domain.board.dto.ArticleDTO;
import com.ezen.mybatis.domain.board.mapper.ArticleMapper;
import com.ezen.mybatis.domain.common.web.PageParams;
import com.ezen.mybatis.domain.member.MemberDao;
import com.ezen.mybatis.domain.member.dto.Member;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ArticleMapperTest {

	
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
	@DisplayName("새로운 게시글 생성")
	public void createTest(){
		
		System.out.println("==================== 새로운 게시글 생성 ========================");
		
		
//		article 객체에 값들 지정
		Member member = new Member();
		ArticleDTO article = new ArticleDTO();
		article.setArticleId(1252);
		article.setBoardId(10);
		article.setSubject("오늘 칼바람 몇시?");
		article.setContent("8시 ㄱ?");
		article.setWriter("song");
		article.setRegdate("2023-08-09");
		article.setHitcount(3000);
		article.setPasswd("1234");
		article.setGroupNum(1);
		article.setLevelNum(1);
		
		
//		myBatis 에서 mapper proxy 라는 EmployeeMapper 인터페이스의 구현체 클래스를 만들어서 리턴
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		mapper.create(article);
		
		
//		{} : 값 , mapper 변수의 값을 로그로 출력하는 코드	
		log.debug("멤버등록 완료 : {}", article);
		
		
//		sqlSession.commit();
		sqlSession.close();

	}
	
	@Test
	@DisplayName("전체 게시글 목록")
	public void findByAllTest(){
		System.out.println("==================== 전체 게시판 조회 ========================");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		List<ArticleDTO> findArticles = mapper.findAll();
//		자바 스크립트식 forEach 사용하기
		findArticles.forEach( (article)  ->{
			log.debug("전체 게시판 : {}", article);
		});
	
		sqlSession.close();
	}
	
	
	@Test
	@DisplayName("전체 게시글의 갯수")
//	@Disabled
	public void getCountAllTest(){
		System.out.println("==================== 전체 게시판의 갯수 조회 ========================");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
//		articleDTO 객체 생성
		ArticleDTO articleDTO = new ArticleDTO();
//		articleDTO 객체중 article_id를 꺼내옴
		int artId= articleDTO.getArticleId();
		int articleCount = mapper.getCountAll(artId);
		log.debug("전체 게시판의 갯수 : {}" , articleCount);
//		자바 스크립트식 forEach 사용하기
	
		sqlSession.close();
	}
	
	
	@Test
	@DisplayName("현재 페이지의 게시글 목록")
	@Disabled
	public void findByAllTest(PageParams pageParams){
		System.out.println("==================== 현재 페이지의 게시글 목록 ========================");
		pageParams = new PageParams();
		int recentPage = pageParams.getRequestPage();
		int pageList = pageParams.getElementSize();
		
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		ArticleMapperTest articleMapperTest = new ArticleMapperTest();
	    
//		자바 스크립트식 forEach 사용하기
	
		sqlSession.close();
	}
	
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}
