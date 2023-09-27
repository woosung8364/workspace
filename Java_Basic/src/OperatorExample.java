
//  	자바에서 지원하는 연산자들
 
public class OperatorExample {

	public static void main(String[] args) {
		int x = 30, y = 5;
		
//		산술연산자
		
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y); // 나머지 값

		
//		+ 연산자 오버로딩(중복정의)
		System.out.println(10 + 50);
		System.out.println("배" + "종현");
		System.out.println(10 + "배종현");
		System.out.println(10 + 20 + "배종현"); // 형 변환 (숫자형과 문자열이 결합 할 때에는 숫자형을 문자열로 바꿔줌)
		System.out.println((10 + 20) + "배종현"); // 좌에서 우로 순서대로 수행, 숫자형 연산을 우선순위로 지정 할 때에는 ()안에 숫자형 연산을 가둬줌
		
				
//		복합 대입 연산자 (+=, -=, *=, /=, %=)
		x += 5; // x = x + 5;
		x -= 5; 
		x *= 5; 
		System.out.println(x);
		
//		비교 연산자 (==, !=, >, >=, <, <=) 출력 값은 boolean형으로 나온다
		x = 10; y = 5;
		System.out.println(x == y);
		System.out.println(x != y);
		System.out.println(x > y);
		System.out.println(x >= y);
		
//		증감 연산자 (++ , --)
		x++; 
//		x = x +1;
//		x += 1;   세 가지 모두 같음
		System.out.println(x);
		
		x = 10;
		System.out.println(x++); // 10 
		System.out.println(++x); // 11 왼쪽 부터 순서대로 실행 
		
//		논리 연산자 (논리곱(&&)and, 논리합(||)or, 논리 부정(!)not) 출력 값은 boolean형으로 나온다
		x = 30;
		y = 50;
		System.out.println(x>=30 && y<=50);
		System.out.println(x>=30 && y<=40);
		System.out.println(x>=30 || y<=40);
		System.out.println(!true);
/*		
		논리곱(&&)과 논리합(||) 연산자의 경우 Short-circuit이 발생한다
		
		Short-circuit Logical Operator
		if(true && ???) // 앞이 true이면 뒤를 평가하지 않음
		if(false || ???) // 앞이 false이면 뒤를 평가하지 않음
*/

//		조건 삼항 연산자 (조건 ? 수식1 : 수식2 ;)
//		조건을 평가해서 true이면 수식1을 false이면 수식2를 수행한다.
//		조건문(if) 대신에 대입 연산자와 함께 유용하게 사용된다.
		int score = 85;
		String result = score >= 60 ? "통과" : "실패";
		System.out.println(result);
		
//		기본 데이터타입 형변환
//		자동 형변환(Promotion - Up Casting)
		double some = 50;
		System.out.println(some);

//		강제 형변환(Demotion - Down Casting)
//		숫자형 끼리만 가능, 실수를 정수로 출력하고자 할 경우 주로 사용한다.
		double avg = 85.34567;
		System.out.println(avg);
		System.out.println((int)avg);
		
		int avg2 = (int)avg;
		System.out.println(avg2);

	}
}
