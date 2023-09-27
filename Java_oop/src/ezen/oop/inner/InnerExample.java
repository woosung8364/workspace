package ezen.oop.inner;

public class InnerExample {

	public static void main(String[] args) {

		Outer outer = new Outer(8, "내부클래스");
		outer.doSome();
		System.out.println(outer.x);
		
//		인스턴스 멤버 내부클래스 객체 생성 방법
		Outer.Inner inner = outer.new Inner();
		inner.doTask();
	
//		static 멤버 내부클래스 생성 방법
		Outer.Inner2 inner2 = new Outer.Inner2();
		inner2.method2();
		inner2.method1();
		
		
		
	}

}
