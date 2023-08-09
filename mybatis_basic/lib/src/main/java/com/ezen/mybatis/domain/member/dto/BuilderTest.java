package com.ezen.mybatis.domain.member.dto;

public class BuilderTest {

	public static void main(String[] args) {
		Member member = Member
				.builder()
				.email("bangry@gmail.com")
				.id("bangry")
				.name("김기정")
				.build();
		System.out.println(member);
		

	}

}
