package ezen.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLExample {

	public static void main(String[] args) throws IOException {
		String urlString = "https://www.naver.com/index.html";
		
		//예외 처리 필요
		URL url = new URL (urlString);
		// 프로트콜 읽어오기 = https
		System.out.println(url.getProtocol());
		// 주소 읽어오기 = www.daum.com
		System.out.println(url.getHost());
		//포트번호 읽어오기 = -1
		System.out.println(url.getPort());
		// 홈페이지 폴더 주소(uri) 읽어오기  /index.html
		System.out.println(url.getPath());

		
		
		// 네트워크 통신을 통해 리소스 데이터 읽기
		//예외처리 필요 - ioException
		//sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@6392827e
		//인풋스트림은 바이트 스트림의 최상위 클래스
		InputStream in =url.openStream();
		System.out.println(in);
		
		
		
		//바이트 스트림-숫자를 읽어들이기 위해서 사용했다
		
		/*
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = in.read(buffer)) != -1) {
			for (byte b : buffer) {
				System.out.println(b);
			}
		}
		*/
		
		//InputStreamReader Bridge (다리) 클래스 - (in):inputStream 과 buffered 스트림을 잇는 역할을 한다
		InputStreamReader r = new InputStreamReader(in);
		//버퍼드리더 - 문자를 읽어들이기 위해 사용
		BufferedReader br = new BufferedReader(r);
		
		String html = null;
		//readLine() 텍스트파일 한줄씩 읽어들이기
		//결과물은 홈페이지에서 소스보기 하는것과 같은값이 나온다
		while((html= br.readLine()) != null) {
			System.out.println(html);
		}
		
		in.close();
	}

}
