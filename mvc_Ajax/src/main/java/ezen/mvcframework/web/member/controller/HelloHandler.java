package ezen.mvcframework.web.member.controller;

import java.util.Map;

import ezen.mvcframework.core.web.controller.BasicController;
import ezen.mvcframework.core.web.controller.ModelAndView;

public class HelloHandler implements BasicController {

	@Override
	public ModelAndView process(Map<String, String> paramMap) {
		String message = "이것을 사용자 정의 웹 프레임워크라 합니다..";
		ModelAndView mav = new ModelAndView("member/hello");
		mav.getModel().put("message", message);
		return mav;
	}

}
