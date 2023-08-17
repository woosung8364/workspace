package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;




/**
 * 회원 관련 API 서비스 세부 컨트롤러
 * @author i7C- 송우성
 */

@Slf4j

//RestController 애노테이션을 사용하면 메소드 반환값이 json 형식으로 변환되어 리턴됨
//@RestController
//localhost/member2 ~~ 경로에서 RestMemberController 메소드를 실행하겠다
@Controller
@RequestMapping("/member2")
public class RestMemberController {
	
//	@PathVariable : url 에서 추출한 경로값 {memberId}을 파라미터(매개변수)로 전달하는 어노테이션
	@GetMapping("/{memberId}")
	@ResponseBody // 메소드에 선언
//	@RequestBody  - 대부분의 required 속성이 들어간 애노테이션이 기본값이 'true' 설정되어있는듯하다
//	따라서 선언시 반드시 return 값에 text 값이 포함되어있야 400 오류가 뜨지 않는다
	public String read(@PathVariable String memberId , @RequestBody(required = false) String text , Model model) {
		
		log.info("수신한 텍스트 : {}" , text);
		String id = "bangry";
		String name = "김기정";
		
//		@ResponseBody 나 @RestController 가 선언됬을경우 
//		리턴된 값들은  body 에 그대로 JSON 방식으로 출력된다
		return "아이디 : "+id+" , 이름 : " +name;
	}
	
	
//	회원가입 요청 처리
//	@RequestBody를 통해 Member 객체에 데이터가 json 형식으로 들어옴
	@PostMapping("/register")
	@ResponseBody
	public Member register(@RequestBody Member member) {
		log.info(member.toString());
//		MemberService 를 이용한 DB 처리 완료 가정
		return member;
	}
}
