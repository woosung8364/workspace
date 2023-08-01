package ezen.io.bytee;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BufferedInputExample {
	public static void main(String[] args) {
		String file = BufferedInputExample.class.getResource("/assets/student.jpg").getFile();
		
		InputStream in = null;
		
		try {
			in = new BufferedInputStream(new FileInputStream(file));
//			//int byteData = in.read();
//			//System.out.println(byteData);
//			byte[] array = new byte[512];
//			int count = in.read(array);
//			for (byte b : array) {
//				System.out.println(b);
//			}
			// 표준입력
			//in = System.in;
			//System.out.println(in);
			System.out.print("이름: ");
//			byte[] array = new byte[512];
//			int count = System.in.read(array);
//			// 디코딩
//			String name = new String(array, 0, count);
//			System.out.println(name);
			
//			Scanner scanner = new Scanner(System.in);
//			String name = scanner.nextLine();
//			System.out.println(name);
			
//			BufferedInputStream 추가 기능
			in.mark(0);
			int data = in.read();
			System.out.println(data);
			in.read();
			in.read();
			in.read();
			in.read();
			in.skip(5);
			in.skip(5);
			in.skip(5);
			in.read();
			in.reset();
			data = in.read();
			System.out.println(data);
			
		} catch (Exception e) {
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









