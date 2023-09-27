
//		Return 

public class ReturnExample {

	public static void main(String[] args) {
		System.out.println("자바 프로그램 시작됨");
		
		
			for (int i = 0; i < 10; i++) {
				if (i == 5) {
					return; // method를 종료시킴
				}
				System.out.println(i);
			}
		
		System.out.println("자바 프로그램 종료됨");
	
	} // return 이동 위치

}
