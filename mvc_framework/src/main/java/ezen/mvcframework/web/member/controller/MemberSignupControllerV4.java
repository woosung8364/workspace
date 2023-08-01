package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ControllerV4;
import ezen.mvcframework.core.web.controller.ModelAndView;

/**
 * 2222222222222222222222222
 * 회원 가입 화면 요청 처리 세부 컨트롤러
 */
public class MemberSignupControllerV4 implements ControllerV4 {
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
//		model and view 를 리턴하지않고 viewName 을 리턴
		String viewName = "member/signup";
		return viewName;
	}
	
	

}
