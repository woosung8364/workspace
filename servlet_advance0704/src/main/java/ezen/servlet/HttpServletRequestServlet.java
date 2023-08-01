package ezen.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/request")
public class HttpServletRequestServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		브라우저 요청 메시지 : request
		System.out.println("브라우저 요청 메시지 : " + request);
		
//		브라우저 요청 방식을 알아내기위한 변수선언 : getMehod()  , 결과 -  GET
		String method = request.getMethod();
		
//		uri 를 알아내기 위한 변수선언  : getRequestURI(); ,  결과 - /request
		String uri = request.getRequestURI(); 
		
//		프로토콜을 알아내기 위한 변수선언 : getProtocol(); , 결과 - HTTP/1.1
		String protocol = request.getProtocol();
		
//		user Agent의 정보 반환
		String userAgent = request.getHeader("user-agent");
		
		System.out.println("요청방식: " + method);
		System.out.println("요청URI: " + uri);
		System.out.println("요청프로토콜: " +protocol);
		System.out.println("UserAgent 의정보 반환 : " + userAgent);
		
		System.out.println("--- 기타 헤더 정보들 ---");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ":" + headerValue + "/");
		};
		
		String clientIp= request.getRemoteAddr();
		System.out.println(clientIp);
		
//		동적으로 현재 서블릿이 동작하고 있는 웹 어플리케이션 이름 받아내기 결과 = /sevlet
		String appPath = request.getContextPath();
		System.out.println("getContextPath 실험입니다"+appPath);
		
//		서블릿간 데이터 공유
//		"hello" 한태만 message 를 전달할 준비 
		RequestDispatcher rd = request.getRequestDispatcher("hello");
		System.out.println("getRequestDispatcher 에 대해 이해하기 위한 콘솔출력입니다" +rd);
		String message = "오늘 수업 끝";
		
		request.setAttribute("message", message);
		rd.forward(request, response);
		
	}

}
