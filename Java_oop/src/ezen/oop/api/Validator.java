package ezen.oop.api;

/**
 * 입력데이터 유효성 검증 공통 기능 정의 유틸리티
 * @author 배종현
 *
 */

public class Validator {
	
	public static boolean hasText(String input) {
		if (input != null && input.trim().length() != 0) {
			return true;
		}return false;
	}
	
	/**
	 * 입력데이터가 숫자인지 확인
	 * @param number 입력 문자열
	 * @return 유효여부
	 */
	public static boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isId(String id) {
		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			if(!Character.isDigit(c) && !Character.isAlphabetic(c)) {
				return false;
			}
		}
		return true;
	}
	
//	테스트를 위한 메인메소드
	public static void main(String[] args) {
	
		String string = "";
		System.out.println(Validator.hasText(string));
		
	}
	
	
}
