package ezen.io.bytee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileInputExample2 {
	public static void main(String[] args) {
		String urlString = "https://mml.pstatic.net/www/mobile/edit/20230523_1095/upload_1684853651858jmD48.png";
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		InputStream in = null;
		try {
			in = url.openStream();
			byte[] buffer = new byte[1024];
			int byteCount = 0;
			int totalBytes = 0;
			while((byteCount=in.read(buffer)) != -1) {
				totalBytes += byteCount;
				for (int i =0; i< byteCount; i++) {
					System.out.println(buffer[i]);
				}
			}
			System.out.println(totalBytes+" 바이트 파일 다 읽어써요~~~~");
			
//			표준입력(키보드)
			System.out.print("아무키나 입력하세요: ");
			in = System.in;
			//int byteData = in.read();
			//System.out.println(byteCount);
			byte[] buffer2 = new byte[10];
			byteCount = 0; 
			while((byteCount=in.read(buffer2)) != -1) {
				for (int i = 0; i < byteCount; i++) {
					// 문자 디코딩...
					char c = (char)buffer2[i];
					System.out.print(c + "  ");
				}
			} 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}









