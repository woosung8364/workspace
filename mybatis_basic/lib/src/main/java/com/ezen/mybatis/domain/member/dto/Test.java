package com.ezen.mybatis.domain.member.dto;

public class Test {
	public static void main(String[] args) {
//		디폴트 생성자 호출
		Member member = Member
				.builder()
				.email("seo8362@email.com")
				.id("song8362")
				.name("송우성")
				.passwd("12341234")
				.build();
		System.out.println(member);
	}
}
