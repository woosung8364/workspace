package ezen.oop.api;

import java.util.Scanner;

/**
 * String 클래스의 주요 메소드
 * @author 배종현
 *
 */
public class StringExample {

	public static void main(String[] args) {
		String ssn = "9408201234567";
		if(ssn.length()==13) {
			System.out.println("정확한 번호입니다.");
		}else {
			System.out.println("X");
		}
		
		
		String title = "자바 프로그래밍";
		System.out.println(title.substring(0, 2));
		System.out.println(title.substring(3));
		System.out.println(title.replace("자바", "JAVA"));
		
		System.out.println("        헐         ".trim());
		
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호 : ");
		ssn = scanner.nextLine();
		char a = ssn.charAt(6);
		switch (a) {
		case '1':System.out.println("2000년 이전 출생 남자");break;
		case '2':System.out.println("2000년 이전 출생 여자");break;
		case '3':System.out.println("2000년 이후 출생 남자");break;
		case '4':System.out.println("2000년 이후 출생 여자");break;
		default:System.out.println("외국인");
			
		}
		*/
		
		if(title.indexOf("자바") != -1) {
			System.out.println("욕하지마");
		}
		
		int number = 1342345;
//		문자열로 변환
		String numStr = String.valueOf(number);
		System.out.println(numStr.length());
		
		
	}
}
