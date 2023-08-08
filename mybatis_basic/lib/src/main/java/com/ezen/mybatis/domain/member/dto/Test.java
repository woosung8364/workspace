package com.ezen.mybatis.domain.member.dto;

public class Test {
	public static void main(String[] args) {
//		디폴트 생성자 호출
		Member member = Member
				.builder()
				.email("bangry@email.com")
				.id("bangry")
				.name("송우성")
				.build();
		System.out.println(member);
	}
}
