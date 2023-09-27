
//	메소드(함수) 정의 및 사용

public class MethodExample {

// 	구구단을 출력 하는 메소드 정의
	static void printGugudan() {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}
	
 
//	단을 입력 받아 해당 단을 출력하는 기능	
	static void printDan(int dan) {
		for (int i = 1; i < 10; i++) {
			System.out.print(dan + " * " + i + " = " + (dan * i)+"\t");
		} System.out.println();
	}
	
		
//	두개의 정수를 전달 받아 해당 정수의 합을 반환하는 기능
	static int sum(int a, int b) {
		return a + b; 
		}
	
	
	
//	메인 메소드 	
	public static void main(String[] args) {
		System.out.println("구구단 출력하기");
		// 구구단 출력 메소드 호출
		printGugudan();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printGugudan();
		
		
		printDan(9);	// 9단 출력 (9를 전달인자 라고 한다 - Argument)
	
		int a = 500, b = 700;
		
		int result = sum(a,b); // 호출 한 값을 메인메소드 안에 저장		
		System.out.println(result);
			
		System.out.println(sum(5,10)); // 결과를 바로 호출 하는 방법.
	}

}
