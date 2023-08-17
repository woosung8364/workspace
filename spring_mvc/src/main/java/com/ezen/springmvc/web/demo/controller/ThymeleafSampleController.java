package com.ezen.springmvc.web.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

//스프링 컨테이너에 이 자바 클래스 선언
@Controller
//url 설정 : /thymeleaf 일경우 이 클래스를 실행하겠음
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafSampleController {

	@GetMapping("/exam1")
	public String exam1(Model model) {
		
//		db에서 가져왔다고 가정 , 새 member 객체 지정 
		Member member = Member.builder()
				.id("bangry")
				.passwd("1234")
				.age(30)
				.build();

//		list 배열에 가상 객체 3개 담기 (db 가정)
		List<Member> list = new ArrayList<>();
		list.add(new Member("양우성" , "1234" , 15));
				list.add(new Member("정우성" , "4321" , 25));
						list.add(new Member("송우성" , "1111" , 35));
		
//		모델에 "member" 라는 이름으로 member 객체 저장
		model.addAttribute("member" , member);
		model.addAttribute("list" , list);
		
		return "demo/exam1";
	}
	
	
	@GetMapping("/exam2")
	public String exam2(Model model) {
		
		int score = 80;
		model.addAttribute("score" , score);
		return "demo/exam2";
	}
	
	
	
	@GetMapping("/exam3")
	public String exam3(Model model) {
		
		model.addAttribute("id" , "exam2");
		model.addAttribute("name" , "홍박사님을아세요?");
		
		return "demo/exam3";
	}
	
//	post방식
//	member 객체를 통째로 받음
//	PostMan 프로그램에서 임의로 파라미터값을 추가하여 테스트하였음
//	@PostMapping("/regist")
//	public String regist(@ModelAttribute  Member member , Model model , RedirectAttributes redirectAttributes) {
//		
//		log.info("수신한 회원정보 : {}" , member);
//		
//		
////		회원 가입 후 결과 페이지로 재요청
//		redirectAttributes.addFlashAttribute("result" , "success");
//		redirectAttributes.addFlashAttribute("member" , member);
//		
////		redirect: 를 썼을땐 파일경로의 viewName이 아닌 url 링크 주소를 리턴한다
//		return "redirect:/thymeleaf/member-result";
//	}
	
////	get요청 방식
//	@GetMapping("/member-result")
//	public String registResult(@ModelAttribute  Member member , Model model , RedirectAttributes redirectAttributes) {
//		
////		viewName : 파일경로 리턴됨 
//		return "demo/member-result";
//	}
	
	
	
	
	@GetMapping("/member-result")
	public String regist2(@ModelAttribute  Member member , Model model , RedirectAttributes redirectAttributes) {
	
		return "demo/member-result";
	}
	
//	get요청 방식
	@GetMapping("/regist")
	public String form(@ModelAttribute  Member member , Model model , RedirectAttributes redirectAttributes) {
		
//		viewName : 파일경로 리턴됨 
		return "demo/regist-form";
	}
}
