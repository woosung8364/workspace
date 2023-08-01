package ezen.shoppingmall.web.common.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/albums")
public class ProxyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		요청(request)의 문자 인코딩을 "utf-8"로 설정합니다. 
		request.setCharacterEncoding("utf-8");
		
//		응답(response)의 Content-Type을 "application/json"으로 설정합니다. 
//		이렇게 함으로써 서블릿이 클라이언트에게 JSON 형식의 데이터를 전송할 것임을 명시합니다.
		response.setContentType("application/json; charset=utf-8");
		
//		응답(response)으로부터 문자열을 출력하기 위한 PrintWriter 객체를 생성합니다. 
//		이를 사용하여 JSON 형식의 데이터를 클라이언트로 전송합니다.
		PrintWriter out = response.getWriter();
		
//		Open API에 접속하기 위한 URL 객체를 생성합니다. 
//		이 예제에서는 "https://jsonplaceholder.typicode.com/albums"라는 주소로 접속하겠다는 의미입니다.
		URL url = new URL("https://jsonplaceholder.typicode.com/albums");
		
//		URL 객체로부터 HttpURLConnection을 생성하여 웹 서비스에 HTTP 연결을 수행합니다.
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
//		 HTTP 요청 메서드를 "GET"으로 설정합니다. 이는 데이터를 요청하는 용도의 메서드입니다.
		connection.setRequestMethod("GET");
		
//		연결 시도 시간을 5000 밀리초(5초)로 설정합니다. 웹 서비스와의 연결이 5초 이내에 이루어지지 않으면 연결 실패로 간주됩니다.
		connection.setConnectTimeout(5000);
		
//		응답 데이터를 받아올 BufferedReader 객체를 선언합니다.
		BufferedReader in = null;
		
//		응답 데이터를 저장할 StringBuilder 객체를 생성합니다. StringBuilder는 문자열을 효율적으로 처리하기 위한 클래스로, 반복적인 문자열 연결 작업에 용이합니다.
		StringBuilder sb = new StringBuilder();	
		
//		서버로부터 받은 HTTP 응답 코드를 status 변수에 저장합니다. HTTP 응답 코드는 요청 결과에 대한 상태를 나타내는 숫자입니다.
		int status = connection.getResponseCode();
		String text = null;
//		받은 HTTP 응답 코드(status)가 300 이상인 경우와 그렇지 않은 경우로 분기하여 처리합니다.
		if(status >= 300) {
//			만약 HTTP 응답 코드가 300 이상인 경우, 에러 스트림(getErrorStream())을 이용하여 BufferedReader를 생성합니다. 
//			에러 스트림은 서버로부터 에러 메시지를 받아오는 스트림입니다.
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//			BufferedReader를 이용하여 응답 데이터를 한 줄씩 읽어와서 StringBuilder에 추가합니다. 
//			이렇게 함으로써 서버로부터 받은 데이터를 문자열로 변환하여 저장합니다.
			while((text=in.readLine()) != null) {
				sb.append(text);				
			}			
		}else {
			
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((text=in.readLine()) != null) {
				sb.append(text);				
			}
		}
//		BufferedReader를 사용한 후에는 반드시 스트림을 닫아주어야 합니다. 여기서는 in 객체의 close() 메서드를 호출하여 스트림을 닫습니다.
		in.close();
//		System.out.println(sb.toString());
		out.print(sb.toString());
	}
}


