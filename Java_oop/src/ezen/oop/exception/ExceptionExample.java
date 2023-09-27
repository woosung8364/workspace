package ezen.oop.exception;

/**
 * 예외란 무엇인가
 * 예외가 발생했을 때 JVM 기본 처리 메커니즘
 * @author 배종현
 */


public class ExceptionExample {

	public static void main(String[] args) {
		System.out.println("프로그램 시작됨");
		
//		int x = 10, y = 0;
//		System.out.println(x/y);
		
//		String name = null;
//		System.out.println(name.length());
		
		int[] array = {1, 2};
		int count = 5;
		for (int i = 0; i < count; i++) {
			System.out.println(array[i]);
		}
/*		
 		JVM 기본 처리 메커니즘
		ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException("Index 2 out of bounds for length 2");
		System.out.println(ex.getMessage());
		System.exit(0);
*/		
		
		
		
		System.out.println("프로그램 종료됨");				
	}

}
