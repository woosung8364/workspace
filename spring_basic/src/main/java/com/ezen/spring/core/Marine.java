package com.ezen.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
//@Scope("prototype")
public class Marine implements Unit {
	
	
//	@Autowired : 스프링 컨테이너가 해당 타입에 맞는 빈을 찾아서 주입해줍니다.
//	@Qualifier() : 하나의 인터페이스를 여러개의 구현 클래스가 구현하고 있을때
//  빈을 주입할때 어떤 빈을 주입할지 결정하는 애노테이션
//	@Autowired
//	@Qualifier("Sword")
	
	final Weapon weapon;
	
	
	
	public Marine(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Autowired
	public void offense() {
		weapon.attack();
	}
	
//	생성된다음에 자동으로 호출하는 애노테이션
	@PostConstruct
	public void init() {
		System.out.println("강아지 키우고 싶다...");
	}
}
