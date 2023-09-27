
//	for 반복문

public class ForExample {

	public static void main(String[] args) {

		for (int index = 0; index < 100; index++) {
			System.out.println("바보");
		}

//		실행>변수업데이트>조건확인>실행 순

		int result = 0;

		for (int index = 1; index <= 100; index++) {
			result += index;
		}
		System.out.println(result);
//		변수의 허용 범위는 블록 안쪽이다
//		위의 index와 아래의 index는 다른 변수	

//		중첩for문을 이용한 사각형 출력

		for (int i = 0; i < 10; i++) { // 행 반복
			for (int j = 9; j >= i; j--) { // 열 반복
				System.out.print('*');
			}
			System.out.println();
		}

//		중첩for문을 활용한 구구단 출력

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}

	}

}
