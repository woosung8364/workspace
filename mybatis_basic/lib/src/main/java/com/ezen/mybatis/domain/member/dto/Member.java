package com.ezen.mybatis.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * @author 김기정
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
}













