package ezen.oop;

/**
 * @author 김기정
 */
public class AutoBoxingExample {

	public static void main(String[] args) {
//		Java5 이전
		int x = 100;
//		Integer integer = new Integer(x);
//		Integer integer = Integer.valueOf(x);
//		x = integer.intValue();
		
		
//		Java5 이후(오토박싱)
		Integer integer = x;
//		Integer integer = Integer.valueOf(x);
		x = integer;
//		x = integer.intValue();
		
	}

}








