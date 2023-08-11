package com.ezen.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
//		실행시 톰캣과 spring 컨테이너가 생성됨
//		Run as Spring boot app
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
