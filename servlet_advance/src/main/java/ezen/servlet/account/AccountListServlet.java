package ezen.servlet.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.servlet.account.domain.Account;
import ezen.servlet.account.domain.AccountRepository;
import ezen.servlet.account.domain.JdbcAccountRepository;

/**
 * DB 연동을 이용한 계좌 목록 서블릿
 */
@WebServlet("/account/list")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AccountRepository  repository = new JdbcAccountRepository();
			List<Account> list = repository.getAccounts();
			for (Account account : list) {
				System.out.println(account);
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
	}

}
