package ezen.servlet;

import java.io.IOException;
import java.util.Enumeration;

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

@WebServlet("/member/register")
public class memberRegistServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		문자가 깨지지 않게 설정
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("name");
		String pwHint = request.getParameter("pwhint");
//		하나의 이름에 값이 여러개일때
		String [] interests = request.getParameterValues("interest");
		
//		수신한 데이터 DB 처리
		
		System.out.println(uname);
//		공백을 제거한 이름입력칸이 빈문자로 들어왔을때
		if (uname.trim().equals("")) {
			System.out.println("이름을 입력하지 않았습니다.");
		}
		System.out.println(pwHint);
//		관심분야를 선택하지 않지않았을때 실행
		if (interests != null) {
			for (String interest : interests) {
				System.out.println(interest);
			}
		} else {
			System.out.println("관심사항을 선택하지 않았습니다...");
			return;
		}
		
		
////		파라미터 이름을 알지 못할때 / 폼태그안에 존재하는 모든 속성들
//		Enumeration<String> paramNames=request.getParameterNames();		
//		while (paramNames.hasMoreElements()) {
//			String paramName = paramNames.nextElement();
//			String paramValue = request.getParameter(paramName);
//			System.out.println(paramName + "=" + paramValue);
//			
//		}
		
	}

}
