package ezen.mvcframework.core.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * 문자 인코딩 필터 
 */
@WebFilter("/ajax/*")
public class CharacterEncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 필요에 따라 암호화 처리 로깅 등의 공통 처리.....
		chain.doFilter(request, response);
	}
}
