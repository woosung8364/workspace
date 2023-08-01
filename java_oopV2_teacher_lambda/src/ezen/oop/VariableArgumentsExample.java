package ezen.oop;

import java.util.Date;

/**
 * @author 김기정
 */
public class VariableArgumentsExample {

	public static int sum(int x, int y) {
		return x + y;
	}
	
	public static int sum(int x, int y, int z) {
		return x + y + z;
	}
	
	public static int sum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;			
		}
		return sum;
	}
	
//	가변인자를 이용한 덧셈
	public static int sum2(int... nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;			
		}
		return sum;
	} 
	

	public static void main(String[] args) {
		int result = sum(15, 30);
		System.out.println(result);
		result = sum(15, 30, 10);
		System.out.println(result);
		int[] nums = {1, 2, 3, 4, 5, 4};
		result = sum(nums);
		System.out.println(result);
		
		sum2(10, 20);
		sum2(10, 20, 30, 40);
		result = sum2(10, 20, 30, 40, 50);
		System.out.println(result);
		
//		표준API에 적용된 가변인자
		int x = 50, y = 30;
		System.out.printf("%1$-10d,  %2$-10d" , x, y);
	}

}








