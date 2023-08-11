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
import com.ezen.mybatis.domain.board.dto.BoardDTO;
import com.ezen.mybatis.domain.board.mapper.ArticleMapper;
import com.ezen.mybatis.domain.board.mapper.BoardMapper;
import com.ezen.mybatis.domain.common.web.PageParams;
import com.ezen.mybatis.domain.member.MemberDao;
import com.ezen.mybatis.domain.member.dto.Member;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BoardMapperTest {

	
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
	@DisplayName("새로운 게시판 생성")
	public void createTest(){
		
		System.out.println("==================== 새로운 게시판 생성 ========================");
		
		
//		board 객체에 값들 지정
		BoardDTO boardDTO= new BoardDTO();
		boardDTO.setBoardId(100);
		boardDTO.setCategory(10);
		boardDTO.setTitle("가나다라");
		boardDTO.setDescription("마바사자");
		
		
		
//		myBatis 에서 mapper proxy 라는 EmployeeMapper 인터페이스의 구현체 클래스를 만들어서 리턴
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.create(boardDTO);
		
		
//		{} : 값 , mapper 변수의 값을 로그로 출력하는 코드	
		log.debug("멤버등록 완료 : {}", boardDTO);
		
		
//		sqlSession.commit();
		sqlSession.close();

	}
	
	@Test
	@DisplayName("전체 게시판 목록")
	public void findByAllTest(){
		System.out.println("==================== 전체 게시판 조회 ========================");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardDTO> findBoards = mapper.findAll();
//		자바 스크립트식 forEach 사용하기
		findBoards.forEach( (board)  ->{
			log.debug("전체 게시판 : {}", board);
		});
	
		sqlSession.close();
	}
	

	
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}
