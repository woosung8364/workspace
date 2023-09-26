package com.ezen.mybatis.domain.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticleDTO {
	int articleId;  //게시글 식별번호
	int boardId;  //게시글 소속 게시판번호
	String writer; //게시글 작성자 아이디
	String subject; //게시글 제목
	String content; //게시글 내용
	String regdate; //게시글 등록일자
	int hitcount; //게시글 조회수
	String passwd; //게시글 비밀번호
	int groupNum; //계층형 게시판 구조를 위한 게시글 / 그룹번호 신규글 답변글 댓글등을 하나로 묶는 번호
	int levelNum; //계층형 게시판 구조를 위한 그룹내 게시글 레벨
	int orderNum; //계층형 게시판 구조를 위한 그룹내 게시글 순서
}
