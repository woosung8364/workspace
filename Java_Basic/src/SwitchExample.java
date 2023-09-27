
//	조건(분기) Switch문 

public class SwitchExample {
	public static void main(String[] args) {
		
		int num = 3 ;
		switch (num) {
			case 1: System.out.println("1입니다.");
				break;
			case 2: System.out.println("2입니다.");
				break;
			case 3: System.out.println("3입니다.");
				break;
			case 4: System.out.println("4입니다.");
				break;
			case 5: System.out.println("5입니다.");
				break;
			default:System.out.println("일치하는 값이 없습니다.");
		}
//		문자형, 문자열, 정수형 모두 비교 가능하지만 실수형은 불가능
//		break;가 없으면 다음 case로 이동 / 일치하는 case가 없으면 default 출력
		
		int score = 10;
		switch (score/10) {
			case 10:
			case 9: System.out.println("수");break;
			case 8: System.out.println("우");break;
			case 7: System.out.println("미");break;
			case 6: System.out.println("양");break;
			default: System.out.println("가");
		}
	
		int x = 50, y = 30;
		char operatoer = '+';
		switch (operatoer) {
			case '+': System.out.println("덧셈 = " + (x + y));break;
			case '-': System.out.println("뺄셈 = " + (x - y));break;
			case '*': System.out.println("곱셈 = " + (x * y));break;
			case '/': System.out.println("나눗셈 = " + (x / y));break;
		}
	}
}
