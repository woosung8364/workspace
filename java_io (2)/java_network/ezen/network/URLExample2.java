package ezen.network;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


/***
 * URL에 해당하는 이미지 파일 다운로드
 * @author i7C-
 *
 */
public class URLExample2 {

	public static void main(String[] args) throws IOException {
//		String urlString = "https://www.naver.com/index.html";
		String urlString = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
		
		
		
		// 네트워크 통신을 통해 리소스 데이터 읽기
		//예외처리 필요 - ioException
		//sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@6392827e
		//인풋스트림은 바이트 스트림의 최상위 클래스
		URL url = new URL(urlString);
		InputStream in =url.openStream();
		
		String saveFile = "google.png";
		FileOutputStream out = new FileOutputStream(saveFile);
		
		//바이트 스트림-숫자를 읽어들이기 위해서 사용했다
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = in.read(buffer)) != -1) {
			out.write(buffer , 0 , count);
		}
		System.out.println("다운로드 완료!!");
		
		out.close();
		in.close();
	}

}
