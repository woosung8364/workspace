package ezen.mvcframework.core.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.web.member.controller.MemberListControllerV4;
import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV4;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV4;

/**
 * 프론트 컨트롤러 구현
 * 3333333333333333333333
 */
//@WebServlet(name = "/frontController", urlPatterns = { "/mvc/*" })
public class FrontControllerServletV4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, ControllerV4> controllerMap = new HashMap<String, ControllerV4>();

	@Override
	public void init() throws ServletException {
		String contextPath = getServletContext().getContextPath();
		controllerMap.put(contextPath + "/mvc/member/signup", new MemberSignupControllerV4());
		controllerMap.put(contextPath + "/mvc/member/signup-action", new MemberSignupActionControllerV4());
		controllerMap.put(contextPath + "/mvc/members", new MemberListControllerV4());
	}

	/**
	 * 웹 브라우저 모든 요청 처리
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 웹 브라우저 요청 URI 분석
		String requestURI = request.getRequestURI();
		System.out.println("[디버깅] : 요청 URI - " + requestURI);

		// 세부 컨트롤러 선택
		ControllerV4 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 요청파라메터 정보를 맵에 저장
		Map<String, String> paramMap = createParamMap(request);
		
		// 모델 생성
		Map<String, Object> model = new HashMap<String, Object>(); 
		
		String viewName = controller.process(paramMap, model);
		
		// 뷰 선택
		MyView view = viewResolve(viewName);
		view.render(model, request, response);
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		
		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> e = request.getParameterNames();
		Iterator<String> iter = e.asIterator();
		while(iter.hasNext()) {
			String paramName = iter.next();
			String paramValue = request.getParameter(paramName);
			paramMap.put(paramName, paramValue);
		}
		return paramMap;
	}

	private MyView viewResolve(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
