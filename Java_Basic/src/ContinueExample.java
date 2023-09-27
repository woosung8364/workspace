
//		continue 이동문

public class ContinueExample {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (i == 50) {
				continue;
			}
			System.out.println("출력 = " + i);
		}

//		1부터 100까지 홀수만 출력

//		첫번째 방법
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}

//		두번째 방법
		for (int i = 1; i <= 100; i += 2) {
			System.out.println(i);
		}

//		세번째 방법
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
