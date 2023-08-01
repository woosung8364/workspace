package ezen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.servlet.account.domain.Account;
import ezen.servlet.account.domain.AccountRepository;
import ezen.servlet.account.domain.JdbcAccountRepository;

/**
 * Servlet implementation class ServeltConfigServlet
 */
@WebServlet({ "/context" })

public class ServletContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context);
		String applicationPath = context.getContextPath();
		System.out.println(applicationPath);

//		서블릿간의 데이터 공유
		context.setAttribute("title", "- 홈페이지 방문을 환영합니다 .-");

//		context 가져오기
//		RequestDispatcher rd =context.getRequestDispatcher(applicationPath); 
		RequestDispatcher rd = request.getRequestDispatcher("b");
		System.out.println(rd);
//		rd.forward(request, response);

		System.out.println("title 저장 완료...");

		AccountRepository repository;

		
		try {
			repository = new JdbcAccountRepository();
			List<Account> list = repository.getAccounts();
			if (list != null) {
				for (Account account : list) {
					System.out.println(account);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
