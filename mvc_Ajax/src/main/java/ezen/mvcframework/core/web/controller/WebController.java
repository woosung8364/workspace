package ezen.mvcframework.core.web.controller;

import java.util.Map;

/**
 * 세부 컨트롤러 명세(역할)
 * @author 배종현
 */
public interface WebController {
	public String process(Map<String, String> paramMap, Map<String, Object> model);
}


