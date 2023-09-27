package ezen.oop.api;
/**
 * 싱글톤 패턴
 * @author 배종현
 *
 */

public class Foo {
	
	
	private static Foo instace = new Foo(); // 생성자를 private 으로 막아놓아서 클래스 안에 Foo 타입 객체를 생성 해놓고 get메소드를 통해서 외부에서 사용 가능하게 함  
	
	private Foo() {}
	
	public static Foo getInstace() {
		return instace;
	}
	
}
