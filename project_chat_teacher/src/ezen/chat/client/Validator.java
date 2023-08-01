package ezen.chat.client;

/**
 * 입력데이터 유효성 검증 공통 기능 정의 유틸리티
 * @author 김기정
 */
public class Validator {
	
	public static boolean hasText(String input) {
		if(input != null && input.trim().length() != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 입력데이터가 숫자인지 여부 체크
	 * @param number 입력문자열
	 * @return 유효여부
	 */
	public static boolean isNumber(String number) {
		return number.matches("\\d+");

	}
	
	public static boolean isId(String id) {
		return id.matches("\\w{8,10}");
	}
	
//	테스트를 main
	public static void main(String[] args) {
		String string = "     ";
		System.out.println(Validator.hasText(string));
		
		String number = "45454545";
		boolean ok = Validator.isNumber(number);
		System.out.println(ok);
		ok = Validator.isId("bang가y313");
		System.out.println(ok);
		
	}
	
}








