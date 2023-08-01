package ezen.io.bytee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputExample {
	public static void main(String[] args) {
//		String file = "c:/fullstack/..../..../student.jsp";
		String file = FileInputExample.class.getResource("/assets/student.jpg").getFile();
		
		InputStream in = null;
		try {
			// 입력빨대
			in = new FileInputStream(file);
//			while(true) {
//				int byteData = in.read();
//				if(byteData == -1) {
//					break;
//				}
//				System.out.println(byteData);
//			}
			
//			int byteData = 0;
//			while((byteData=in.read()) != -1) {
//				System.out.println(byteData);
//			}
			
//			효율적으로 파일 바이트 읽기
			byte[] buffer = new byte[1024];
			int byteCount = 0;
			int totalBytes = 0;
//			int byteCount = in.read(buffer);
//			int totalBytes = 0;
//			System.out.println(byteCount);
//			for (int i=0; i<byteCount; i++) {
//				System.out.println(buffer[i]);
//				totalBytes += byteCount;
//			}
			
			while((byteCount=in.read(buffer)) != -1) {
				totalBytes += byteCount;
				System.out.println(in.available());
			}
			System.out.println(totalBytes+" 바이트 파일 다 읽어써요~~~~");
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









