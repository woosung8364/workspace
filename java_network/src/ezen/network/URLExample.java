package ezen.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLExample {

	public static void main(String[] args) throws IOException {
//		String urlString = "https://www.naver.com";
		String urlString = "https://www.daum.net";
		URL url = new URL(urlString);
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		
//		네트워크 통신을 통해 리소스 데이터 읽기
		InputStream in =  url.openStream();
//		System.out.println(in);
//		in.read();
		
		/*
		byte[] buffer = new byte[1024];
		int count = 0;
		while( (count = in.read(buffer)) != -1 ) {
			for (byte b : buffer) {
				System.out.println(b);
			}
		}
		*/
		// 브릿지(Bridge) 스트림 활용
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String html = null;
		while( (html = br.readLine()) != null ) {
			System.out.println(html);
		}
		
		in.close();		
	}

}






