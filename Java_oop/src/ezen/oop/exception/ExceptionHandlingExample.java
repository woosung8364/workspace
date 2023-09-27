package ezen.oop.exception;

import java.io.IOException;
import java.util.Scanner;

/**
 * 개발자가 예외 처리하는 방법 try ~ catch 블록 사용
 * 
 * @author 배종현
 */

public class ExceptionHandlingExample {

	public static void exceptionHandling1() {
		try {
//			예외가 발생할 가능성이 있는 실행문
			int x = 10, y = 0;
			System.out.println(x / y);

			String name = null;
			System.out.println(name.length());

		} catch (ArithmeticException ex) {
//			개발자가 예외 처리하는 코드
			ex.printStackTrace(); // 디버깅 할 때 유용한 메소드
			System.err.println("숫자는 0으로 나눌 수 없습니다.");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.err.println("nullpointer exception");
		} finally {
			System.out.println("반드시 실행되어야 하는 코드");
			System.out.println("리소스 반납 코드");
		}
	}

	public static void exceptionHandling2() {
		try {
//			예외가 발생할 가능성이 있는 실행문
			int x = 10, y = 2;
			System.out.println(x / y);

			String name = null;
			System.out.println(name.length());

		} catch (Exception ex) {
//			개발자가 예외 처리하는 코드
			System.err.println(ex.getMessage());
			if (ex instanceof ArithmeticException) {
				System.err.println("숫자는 0으로 나눌 수 없습니다.");
			} else if (ex instanceof NullPointerException) {
				System.err.println("nullpointer exception");
			}
		}
	}

	public static void inputMoney() throws NotBalanceException {
		System.out.print("입금금액 : ");
		Scanner scanner = new Scanner(System.in);
		long money = scanner.nextLong();
//		입력데이터 검증
		if (money <= 0) {
//			사용자 강제 예외 발생
			throw new NotBalanceException("금액은 0이거나 음수일 수 없습니다.", 100);
		}
		System.out.println("정상 입금 처리되었습니다.");
	}

	public static void standardAPITest() {
		try {
			int c = System.in.read();
			char c2 = (char)c;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void eclipseTest () {
		try {
			inputMoney();
		} catch (NotBalanceException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작됨");

		standardAPITest();
		
		
//		try {
//			inputMoney();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		
//		exceptionHandling1();

//		int[] array = {1, 2};
//		int count = 5;
//		for (int i = 0; i < count; i++) {
//			System.out.println(array[i]);
//		}
		
		/*
		 * JVM 기본 처리 메커니즘 ArrayIndexOutOfBoundsException ex = new
		 * ArrayIndexOutOfBoundsException("Index 2 out of bounds for length 2");
		 * System.out.println(ex.getMessage()); System.exit(0);
		 */

		System.out.println("프로그램 종료됨");
	}

}
