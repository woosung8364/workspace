package ezen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 이 문서는 memberRegist.html 과 연관됨
 * 송우성
 *
 */

@WebServlet("/respon")
public class HttpServletResponseServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		게시판 글쓰기 요청
//		게시판 테이블에 insert
		System.out.println("글쓰기 등록 완료...");
//		게시판 목록 보여주기 서블릿으로 자동요청
//		response.setStatus(HttpServletResponseServlet.SC_MOVED_PERMANENTLY);  // 302
		response.setHeader("location", "url");
		response.sendRedirect("");
		
	}

}
