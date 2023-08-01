package ezen.mvcframework.core.web.adapter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.controller.HttpController;
import ezen.mvcframework.core.web.controller.ModelAndView;

public class HttpControllerHandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return handler instanceof HttpController;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException, IOException {
		HttpController controller = (HttpController) handler;
		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<String, Object>();
		
		String viewName = controller.process(paramMap, model, request, response);
		ModelAndView mav = new ModelAndView(viewName);
		mav.setModel(model);
		return mav;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> e = request.getParameterNames();
		Iterator<String> iter = e.asIterator();
		while (iter.hasNext()) {
			String paramName = iter.next();
			String paramValue = request.getParameter(paramName);
			paramMap.put(paramName, paramValue);
		}
		return paramMap;
	}

}
