package ezen.oop.interfacee;

/**
 * 유닛이 사용하는 모든 무기들에 대한 역할(명세)을 정의
 * 인터페이스도 하나의 데이터 타입.
 * 인터페이스는 100% 추상메소드들로만 구성된다.
 * @author 배종현
 *
 */

	
/*public*/ interface Weapon { // 정의하지 않아도 컴파일시에 자동으로 public이 된다.

//	상수
	/*public static final*/ int WEIGHT = 1; 
	/*public abstract */ void attack (); // 인터페이스에는 무조건 상수, 추상메소드만 작성할 수 있으므로 작성하지않아도 자동으로 생성.
		
}
