package ezen.oop;

import java.util.Date;

/**
 * 표준애노테이션 사용하기
 * @author 김기정
 *
 */
public class AnnotationExample {
	
	@Deprecated
	public static void someMethod() {
		System.out.println("폐기처분 메소드 예제");
	}
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		someMethod();
			
		Date today = new Date();
		System.out.println(today.toLocaleString());

	}

}












