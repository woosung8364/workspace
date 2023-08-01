package ezen.mvcframework.web.ajax.controller;

import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;

public class HelloActionController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "ajax/hello-view";
		String name = paramMap.get("name");
		model.put("name", name);
		return viewName;
	}

}
