package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


/**
 * 회원 관련 요청에 대한 세부 컨트롤러 (핸들러)
 * @author i7C- 송우성
 * jsp 마다 컨트롤러 클래스를 만들지 말고 이 클래스 하나로 모든 url 요청에 대해 대응
 * 서버사이드 렌더링
 */

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
//	url 경로가 /member/regist  라면 해당 메소드를 실행하겠다
	@GetMapping("/regist")
	public String form(Model model) {
		return "regist";
	}
	
//	url 경로가 /member/regist  이고 요청방식이 'Post' 이면 해당 메소드를 실행하겠다
//	@RequestMapping(value="/regist" , mehod = RequestMapping.POST)
//	@PostMapping("/regist")
	
//	@RequestParam : 단일 파라미터를 각각 전달할때 사용된다
//	public String regist(@RequestParam String id, @RequestParam String passwd ,Model model) {
//		log.info("수신한 아이디 {}" , id);
//		log.info("수신한 아이디 {}" , passwd);
//		
////		Service 를 이용한 DB 등록 처리
////		해당 경로로 forward 처리
////		return "regist-result";
//		
////		해당 경로로 redirect 처리
//		return "redirect:regist-result";
//	}
	
	
	
//	ModelAttribute : 객체를 통째로 파라미터값으로 전달할때 사용한다
//	localhost/member/regist 경로일때 아래 메소드의 기능을 실행하겠다
	@PostMapping("/regist")
	public String regist(@ModelAttribute Member member ,Model model) {
		log.info("수신한 아이디 {}" , member);
		return "redirect:regist-result";
	}
	
	
	
	
	
	@GetMapping("/regist-result")
	public String registResult(Model model) {
		
		
//		Service 를 이용한 DB 등록 처리
//		해당 경로로 forward 처리
		return "regist-result";
		
	}
	
	
//	파라미터 설정 - key , value 로 [admin , bangry] 가 들어와야만 해당 홈페이지에 접속할 수 있게 설정               
	@GetMapping(value="/find" , params = "admin=bangry")
	public String find(Model model) {
	
		return "hello";
		
	}

	//{memberId}는 경로 변수로, 실제 요청 URL에서 해당 부분의 값을 추출하여 memberId 매개변수에 전달하는 역할을 합니다.
	//클라이언트가 "/find/123"과 같은 URL로 요청을 보낸다면, memberId 매개변수는 "123"이라는 값을 가지게 됩니다.
//	@PathVariable : url 에서 추출한 경로값 {memberId}을 파라미터(매개변수)로 전달하는 어노테이션
	@GetMapping("/find/{memberId}")
	
//	@cookieValue : 해당 쿠키가 존재하여야만 접속가능
//	(value="loginId" , required=false , defaultValue="손님")String id : loginId 라는 이름의 쿠키값을
//	String id 매게변수에 전달 / required = false :: 기본값은 'true' 로 설정되어있지만 본문에서는 'false' 로 설정하여 
//	쿠키가 존재하지 않더라도 접속이 가능하게 해두었음
//	defaultValue = "손님" 만약 쿠키값이 존재하지않는다면 기본값으로 '손님' 으로 설정

	public String find(@PathVariable String memberId , @CookieValue(value="loginId" , required=false , defaultValue="손님")String id, Model model) {
		log.info("수신한 회원아이디 {}" , memberId);
		return "hello";
		
	}
	
	
	@PostMapping("/login")
//	[Post방식] id , passwd 파라미터 받아서 session 으로 저장해서 hello.jsp 를 출력하는 메소드
	public String login(@RequestParam String id , String passwd , HttpSession session ,  Model model) {
		log.info("수신한 회원아이디 {}" , id);
		log.info("수신한 회원아이디 {}" , passwd);
		session.setAttribute("loginId", id);
		log.info("세션에 저장된 아이디 : {}" , session.getAttribute("loginId"));
		return "hello";
		
	}
	
}
