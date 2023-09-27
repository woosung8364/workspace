package ezen.oop.regexp;

/**
 * 입력데이터 유효성 검증 공통 기능 정의 유틸리티
 * @author 배종현
 *
 */

public class Validator {

	/**
	 * 공백 포함 여부 확인 메소드
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {
		if (input == null || input.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 입력데이터가 숫자인지 확인
	 * @param number 입력 문자열
	 * @return 
	 */
	public static boolean isNumber(String number) {
		return number.matches("\\d+");
	}
	
	
	/**
	 * 아이디 유효 여부 - 영문과 숫자조합으로 8~10자리 아이디
	 * @param id
	 * @return
	 */
	public static boolean isId(String id) {
		return id.matches("\\w{8,10}$");
	}
	
	
//	테스트를 위한 메인메소드
	public static void main(String[] args) {
	
		String string = "";
		System.out.println(Validator.isEmpty(string));
		
		String num = "434343";
		System.out.println(Validator.isNumber(num));
		
		System.out.println(Validator.isId("bangry313"));
		
		
	}
	
	
}
