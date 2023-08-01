package ezen.mvcframework.web.member.controller;

import java.util.Calendar;
import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;

/**
 * /today 요청에 대한 세부 컨트롤러
 * @author 배종현
 */
public class TodayController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "today";
		String today = null ;
		Calendar calendar = Calendar.getInstance();
		today = String.format("%1$tF %1$tT", calendar);
		model.put("today", today);
		return viewName;
	}
	
}
