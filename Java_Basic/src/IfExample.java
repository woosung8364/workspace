
//	조건(분기) if문

public class IfExample {
	public static void main(String[] args) {
		int score = 88;
//		단순 if 문
		if (score >= 60) {
			System.out.println("참 잘했어요.");
		}

//		if ~ else 문
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		int num = 56;
		if ((num % 2) == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

//		조건 삼항 연산자
		String result = score >= 60 ? "합격" : "불합격";
		System.out.println(result);

//		다중 if문
		if (score >= 90) {
			System.out.println("수");
		} else if (score >= 80) {
			System.out.println("우");
		} else if (score >= 70) {
			System.out.println("미");
		} else if (score >= 60) {
			System.out.println("양");
		} else if (score >= 50) {
			System.out.println("가");
		}

	}

}
