package ezen.mvcframework.web.ajax.controller;

import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;

public class HelloAjaxController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "ajax/hello";
		return viewName;
	}

}
