package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	
	/*
	 * 웹 브라우저 요청이 GET 방식일때 동적 컨텐츠 생성 및 전송 
	 * 액션 이벤트 처리하는 이벤트 핸들러와 비슷
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		DB 처리 필요..
//		DB에서 가져옴
		String name = "김기정";
		
//		REQUEST - 요청시 파싱해서 객체로 담아서 전달해줌
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<h2>DB로부터 가져온 이름: "+name+"</h2>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		
	}


}
