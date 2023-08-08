package com.ezen.mybatis.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * @author 송우성
 *
 */

// 디폴트 생성자
@NoArgsConstructor
// 생성자
@AllArgsConstructor
@Getter
@Setter
@ToString

// 생성자 이외에 대부분의 메소드를 자동생성해주는 어노테이션
// data만 넣으면 디폴트 생성자 '만' 생성
// 버그가 많으니 쓰지 않는걸 권장
//@Data


@Builder
public class Member {
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
}













