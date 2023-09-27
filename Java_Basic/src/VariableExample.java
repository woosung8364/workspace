class VariableExample {
	public static void main(String[] args) {
		// 변수는 프로그램에서 사용하는 데이터를 저장하기 위한 메모리 공간
		// 변수를 사용하는 목적은 데이터를 재사용 하기 위함
		// 변수 선언
		String name; // String 문자열
		int age; // int 정수
		double weight; // double 실수
		
		// 변수 초기화
		name = "배종현";
		age = 30;
		weight = 75.5;

		// 변수 사용
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);

		// 변수의 값 수정 (update)
		name = "홍길동";
		age = 40;
		weight = 85.5;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);

		int age2;
		// 변수에 변수의 값 할당
		age2 = age;
		System.out.println(age2);

		// 변수선언과 할당을 한번에
		int score = 95;
//		int a = 10, b = 20, c = 30, d = 40, e = 50;
		

		System.out.println(score);
//		System.out.println(e);
		

		// 초기화 되지 않은 변수는 사용할 수 없다.
		/*	
			int x;
			System.out.println(x);
		*/

		String firstName = "종현"; // Camel 표기법
		String lastName = "배";

		System.out.print(lastName);
		System.out.println(firstName);

		// 자바예악어(키워드)는 변수명으로 사용할 수 없다.

		String 이름 = "홍길동";
		System.out.println(이름);

		// 변수이름을 한글로 쓸 순 있지만 권장하지 않음


		
	}
}
