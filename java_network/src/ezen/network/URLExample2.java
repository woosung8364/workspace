package ezen.network;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * URL에 해당하는 이미지 파일 다운로드
 * @author 김기정
 *
 */
public class URLExample2 {

	public static void main(String[] args) throws IOException {
		String urlString = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
		URL url = new URL(urlString);
		InputStream in =  url.openStream();
		
		String saveFile = "google.png";
		
		FileOutputStream out = new FileOutputStream(saveFile);
		
		byte[] buffer = new byte[1024];
		int count = 0;
		while( (count = in.read(buffer)) != -1 ) {
			out.write(buffer, 0, count);
		}
		System.out.println("파일 다운로드 완료!!!");
		
		out.close();
		in.close();		
	}

}






