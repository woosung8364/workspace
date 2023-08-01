package ezen.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeltConfigServlet
 */
@WebServlet(
		urlPatterns = { "/config" }, 
//		초기 설정 정보 설정
		initParams = { 
				@WebInitParam(name = "message1", value = "개졸려~~") ,
				@WebInitParam(name = "message2", value = "집가~~") 
		})
public class ServeltConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String message1 , message2;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		설정해둔 initParam 읽어오기
		message1 = config.getInitParameter("message1");
		message2 = config.getInitParameter("message2");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		value 값만 바로 읽어오기 -- 시작할때 한번만 읽어오는 init 을 통해 주로사용
//		설정값은 한번만 읽어오면 되지만 (doGet은 호출할때마다 실행되니까)
		
//		System.out.println(getInitParameter("message1"));
//		System.out.println(getInitParameter("message2"));
		
		System.out.println("message1 " + message1);
		System.out.println("message2 " + message2);
	}

}
