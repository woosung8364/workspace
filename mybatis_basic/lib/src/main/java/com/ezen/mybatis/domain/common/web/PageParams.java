package com.ezen.mybatis.domain.common.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO 기능 수행
 * 변수추가하면 유동적으로 lombok 기능을 사용하기위해 8/9 수정하였음
 * 
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder

public class PageParams {
	
	private int elementSize;    /** 페이지에 보여지는 목록 갯수 */
	private int pageSize;       /** 페이지에 보여지는 페이지 갯수 */
	private int requestPage;    /** 사용자 요청 페이지 */
	
	public PageParams() {
		this(10, 5, 1);
	}
	
	
}
