package ezen.io.bytee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyExample {
	
	public static long copy(String srcFile, String copyFile) throws IOException {
		long copyCount = 0;
		File file = new File(srcFile);
		if(!file.exists()) {
			throw new IOException("복사하고자 하는 파일을 찾을 수 없습니다..");
		}
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(copyFile);
		
		byte[] buffer = new byte[1024];
		int count = 0;
		while( (count = in.read(buffer)) != -1) {
			out.write(buffer, 0, count);
			copyCount += count;
		}
		return copyCount;
	}
	

	public static void main(String[] args) throws IOException {
		
		String srcFile = FileCopyExample.class.getResource("/assets/student.jpg").getFile();
		String copyFile = FileCopyExample.class.getResource("/assets/").getFile() + "student3.jpg";
//		
//		InputStream in = new FileInputStream(srcFile);
//		OutputStream out = new FileOutputStream(copyFile);
//		
//		byte[] buffer = new byte[1024];
//		int count = 0;
//		while( (count = in.read(buffer)) != -1) {
//			out.write(buffer, 0, count);
//		}
//		
//		System.out.println("파일 복사 완료...");
//		long copyCount = copy(srcFile, copyFile);
//		System.out.println(copyCount);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					long copyCount = copy("xxxx.txt", copyFile);
					System.out.println(copyCount/1024+ "KB 복사 완료!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
//				System.out.println(copyCount);
			}
		}).start();

	}

}






