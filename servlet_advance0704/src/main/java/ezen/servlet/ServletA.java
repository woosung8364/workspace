package ezen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/a")
public class ServletA extends HttpServlet {

	
    	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servelt 요청됨...");
//		Servlet B 로 내부이동
//		request dispatcher 를 이용한 forward
		RequestDispatcher rd = request.getRequestDispatcher("b");
		ServletB b = new ServletB();
		System.out.println(b);
		rd.forward(request, response);
	}
	


}
