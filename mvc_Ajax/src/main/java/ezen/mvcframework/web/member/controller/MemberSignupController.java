package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.BasicController;
import ezen.mvcframework.core.web.controller.WebController;
import ezen.mvcframework.core.web.controller.ModelAndView;

/**
 * 회원 가입 화면 요청 처리 세부 컨트롤러
 */
public class MemberSignupController implements WebController {
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/signup";
		return viewName;
	}
	
	

}
