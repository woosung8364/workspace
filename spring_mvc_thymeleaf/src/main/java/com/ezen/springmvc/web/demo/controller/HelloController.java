package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * /hello 요청에 대한 세부 컨트롤러(핸들러)
 * @author i7C- 송우성
 *
 */


// 스프링 컨테이너의 빈으로 자동등록 / 컨트롤러라고 인식됨
@Controller
public class HelloController {
	
//	/hello 혹은  /hi 경로로 들어가면 아래 메소드를 실행하겠다 선언
	@GetMapping({"/hello" , "/hi"})
	
//	파라미터로 설정된 Model 클래스는 springFramework 지원 클래스
	public String hello(Model model) {
		
//		DB로 부터 가져온 메시지라 가정 
		String message = "Spring <strong>MVC</strong> 실습페이지입니다...";
		
//		model 에 키와 값 저장
		model.addAttribute("message" , message);
		
//		hello 라는 뷰이름을 반환함
		return "hello";
	}
	
}
