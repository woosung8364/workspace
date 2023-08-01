package ezen.io.bytee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

public class PrintStreamExample {

	public static void main(String[] args) throws FileNotFoundException {
//		PrintStream out = System.out;
//		out.println(5);
//		out.printf("%,+d", 10000000);
		String file = "example2.txt";
		
//		PrintStream out = new PrintStream(new FileOutputStream(file));
//		PrintStream out = new PrintStream(file);
		PrintStream out = new PrintStream(new File(file));
		out.print(true);
		out.print('김');
		out.print("기정");
		out.print(50);
		out.print(50.56);
		out.println();
		out.printf("%1$tF %1$tT", Calendar.getInstance());
		out.close();
		System.out.println("텍스트 파일 생성 완료...");
	}

}







