
//	반복문 while

public class WhileExample {

	public static void main(String[] args) {

//		while문

		int index = 0;

		while (index < 100) {
			System.out.println("바보");
			index++;
		}

		index = 1;
		int odd = 0, even = 0, result = 0;
		while (index <= 100) {
			result += index;
			if ((index % 2) == 0) {
				even += index;
			} else {
				odd += index;
			}
			index++;
		}
		System.out.println("누적합 : " + result);
		System.out.println("짝수합 : " + even);
		System.out.println("홀수합 : " + odd);

//		do~while문 

		index = 0;

		do {
			System.out.println("풀스택 웹 개발자과정");
		} while (index < 100);
//		do 안에 있는 명령을 한번 실행 하고 while 안에 있는 조건이 true 일때 do로 돌아가서 명령 실행

	}

}
