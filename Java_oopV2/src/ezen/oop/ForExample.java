package ezen.oop;

/**
 * Java5 버전에 추가된 향상 for문
 * @author 배종현
 *
 */

public class ForExample {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,};
		for( int num : array ) { //    ( : )  : 기준으로 왼쪽은 값을 저장 할 변수 선언 , 오른쪽은 반복 할 변수 
			System.out.println(num);
		}
		
		
		
	}

}
