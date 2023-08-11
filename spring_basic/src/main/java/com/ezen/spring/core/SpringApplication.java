package com.ezen.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * ApplicationConfig 클래스라는 조립공장에서
 * 인터페이스와 객체를 조립해서 리턴하는 메소드를 
 * ClassicApplicationConfig 클래스에서 직접 구현을 했다면
 * 이 클래스에선 스프링 프레임워크를  활용하여 스프링컨테이너에 메소드를 집어넣고
 * 동적으로 넣다 뻈다 서랍역할을 하는 클래스
 */
public class SpringApplication {

	
	public static void main(String[] args) {
		
//		스프링 컨테이너 초기화 (@bean 을 정의한 클래스 입력)
//		빈 선물상자에 @bean 으로 선언한 선물들을 넣는 과정
		ApplicationContext springContainer = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		log.info("{}",springContainer);
		

//		스프링 컨테이너에 등록된 @Bean 중 이름이 'Unit' 인걸 불러옴 
//		Unit.class = Unit 인터페이스를 구현한 클래스를 동적으로 가져옴 - Marine.class
		Unit unit = springContainer.getBean(Unit.class);
//		Unit unit = springContainer.getBean("unit" , Unit.class);
		
//		위 과정을 통해 실제로 Marine.class 를 불러왔으므로 Marine의 메소드인 offense () 를 사용가능하다
		unit.offense();
		
		
//		스프링 컨테이너에 등록된 모든 빈 검색
//		컨테이너의 모든 빈의 갯수 검색
		int count = springContainer.getBeanDefinitionCount();
		
//		"등록된 갯수 {count의 값} , count [키이름]  
		log.info("등록된 갯수 {}" , count);
		
//		이번에는 문자열을 통하여 스프링 컨테이너에 등록된 모든 bean 을 '이름' 으로 검색해보기
		String[] names = springContainer.getBeanDefinitionNames();
		
//		컨테이너에 등록됬던 8개의 bean 들의 이름들의 배열을 반복문을 통하여 하나씩 log로 출력해보기
		for (String beanName : names) {
			Object bean = springContainer.getBean(beanName);
			log.info("검색된 Bean : {}",bean);
		}
		
	
	}

}
