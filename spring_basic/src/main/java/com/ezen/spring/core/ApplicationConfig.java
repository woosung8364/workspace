package com.ezen.spring.core;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

//애플리케이션에 관계된 구현 객체 생성 및 관계 설정을 책임지는 별도의 조립 클래스 작성
// 인터페이스와 구현클래스 조립을 해줘서 반환해주는 factory 역할 클래스

//  @Bean 으로 선언된 메소드들을 Spring 컨테이너 설정으로 등록하라 -> Map 이 생성됨
//  ApplicationConfig의 맨앞자리를 소문자로한 a , weapon , unit 이라는 이름으로 3개의 키가 생성됨


//방법1
//@Configuration 

//방법2 
//@ComponentScan : 지정된 패키지 또는 패키지들을 스캔하여 해당 패키지 내에 있는 @Component 애노테이션이 붙은 클래스들을 
// 자동으로 Spring 빈으로 등록
@ComponentScan(basePackages = "com.ezen.springbasic_core")
public class ApplicationConfig {

	
//	방법1 어노테이션을 활용해 직접 @Bean 메소드 선언
	
//	@Bean
//	public Weapon weapon() {
////		팩토리클래스에서 직접 코드를 gun 에서 sword 로 코드를 바꾸지않고도 동적으로 코드를 바꿀 수 없을까?
////		-> @Bean
////		return new Gun();
//		return new Sword();
//	}
//	
//	
//	@Bean
//	public Unit unit() {
//		return new Marine(weapon());
//	} 

	
	
}
