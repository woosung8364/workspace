package com.ezen.springmvc.domain.article;

import com.ezen.springmvc.domain.article.dto.ArticleDTO;
import com.ezen.springmvc.domain.article.page.PageParams;
import com.ezen.springmvc.domain.member.dto.Member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

public interface ArticleService {
    // 신규글 등록
    public void create(ArticleDTO articleDTO);
    // 게시글 수정
    // 게시글 삭제

    public List<ArticleDTO> findAll();

    // 전체 게시글 목록 (+게시글 페이징 처리)
    public List<ArticleDTO> findByAll(PageParams pageParams);

    // 페이징 계산(검색값 포함)에 필요한 게시글 전체 갯수 반환
    public int getCountAll();

    // 댓글 쓰기
    public void createArticle(ArticleDTO articleDTO);
    // 대댓글 쓰기
    // 게시글 상세보기

    // 게시글 검색 (게시글 번호, 이름 등)
}
