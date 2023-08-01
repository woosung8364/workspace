package ezen.oop.lambda;

public class LambdaExample {

	public static void main(String[] args) {
		
		//익명 구현 객체
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("스레드 실행");
				
			}
		}).start();

		
		new Thread(()-> System.out.println("또다른 스레드")).start();
		
		
		
	}

}
