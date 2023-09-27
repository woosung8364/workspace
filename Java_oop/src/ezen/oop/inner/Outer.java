package ezen.oop.inner;

public class Outer {
	int x;
	String message;

	public Outer() {}
	public Outer(int x, String message) {
		this.x = x;
		this.message = message;
	}
	
	public void doSome() {
		Inner inner = new Inner();
		inner.doTask();
		
		Inner2 inner2 = new Inner2();
		inner2.method1();
		Inner2.method2();
		
//		지역 (로컬) 클래스
		class Local {
			int x;
//			static int y; 
			
			Local(int x){
				this.x = x;
				Outer.this.x = x;
			}
			
			public void doTask() {
				System.out.println("doTask() 메소드 실행됨.");
			}
		}
		
		Local local = new Local(10);
		local.doTask();
	}
	
//	인스턴스 멤버 내부클래스
	public class Inner {
		int y;
//		static int z;    // 인스턴스 멤버 내부클래스 에서는 static 변수 선언 불가
		public Inner() {}
		public Inner (int y) {
			this.y = y;
	}
	
		public void doTask() {
			System.out.println("외부클래스의 x값 : " + x);
		}
	}
	
//	정적 (static) 멤버 내부클래스
	static class Inner2 {
		int z;
		static int a;
		public Inner2() {
			z=10;
		}
		public void method1() {
			System.out.println("method1() 실행됨.");
		}
		public static void method2() {
			System.out.println("method2() 실행됨.");
		}
	
	}
	
	
}
