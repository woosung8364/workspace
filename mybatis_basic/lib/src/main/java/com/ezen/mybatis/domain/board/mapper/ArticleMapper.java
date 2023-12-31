package com.ezen.mybatis.domain.board.mapper;

import java.util.List;

import com.ezen.mybatis.domain.board.dto.ArticleDTO;
import com.ezen.mybatis.domain.common.web.PageParams;

/**
 * 로그 설정 저장 : logback.xml
 * 저장소 : ????DTO
 * SQL 쿼리 실행 : ????.xml 파일
 * Ma
 */
public interface ArticleMapper {
	/** 신규 게시글 등록 */
	public void create(ArticleDTO articleDTO);

	/** 전체 게시판 목록 반환 */
	public List<ArticleDTO> findAll();

	/** 페이징 계산에 필요한 게시글 전체 갯수 반환 */
	public int getCountAll(int articleId);

	/** 페이징 계산(검색값 포함)에 필요한 게시글 전체 갯수 반환 */
//	public int getCountAll(PageParams pageParams);

	/** 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환 */
	public List<ArticleDTO> findByAll(PageParams pageParams);

//	   댓글쓰기
	public void createArticle(ArticleDTO articleDTO);

//	   대댓글 쓰기,
	public void createSubArticle();

//	   게시글 상세보기 : 게시글 , 댓글 , 대댓글 전부 출력
	public void viewArticleAll(int groupNum);

//	   게시글 번호로 게시글 검색
	public ArticleDTO searchArticle(int articleId);

//	   게시글 수정
	public ArticleDTO updateArticle(ArticleDTO articleDTO);

//	   게시글 삭제 
	public ArticleDTO deleteArticle(int articleId);
}
