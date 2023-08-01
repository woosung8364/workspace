package ezen.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/media")
public class MIMESevlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		경로지정 정적선언 (비권장)
//		String media ="C:/ezen-fullstack/workspace/servlet_advance/src/main/webapp/WEB-INF/media/";
		
//		리플렉션을 활용해서 경로를 동적으로 지정해보기
		InputStream in = MIMESevlet.class.getResourceAsStream("../../../media/Servlet.pdf");

//		응답메시지의 헤더에 Content-Type 설정
		
//		pdf 타입 선언
		response.setContentType("application/pdf");
		
//		오디오파일
//		response.setContentType("audio/mpeg");
		
//		파일-다운로드
//		response.setContentType("application/octect-stream");
		
		OutputStream out = response.getOutputStream();
		
//		파일 읽어들이기
		
		try {
//		in = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count=in.read(buffer)) != -1) {
			out.write(buffer , 0 , count);
		}
		
		}finally {
			in.close();
			out.close();
		}
		
		
		
		
		
	}
	
	
		
		
		
	}

