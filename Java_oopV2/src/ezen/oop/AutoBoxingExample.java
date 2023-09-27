package ezen.oop;

/**
 * Java5 버전에 추가된 AutoBoxing
 * @author 배종현
 *
 */

public class AutoBoxingExample {

	public static void main(String[] args) {
//		Java5 이전
		int x = 100;
//		Integer integer = new Integer(x);
//		Integer integer = Integer.valueOf(x);
		
//		Java5 이후(AutoBoxing)
		Integer integer = x;
//		Integer integer = Integer.valueOf(x);
		x = integer;
//		x = integer.intValue();  // 위랑 같은 값 ,		
		
		
		
		
	}

}
