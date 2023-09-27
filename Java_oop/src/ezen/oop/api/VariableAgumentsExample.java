package ezen.oop.api;

/**
 * 가변인자
 * @author 배종현
 *
 */

public class VariableAgumentsExample {

	public static int sum(int x, int y) {
		return x+y;
	}
	
//	메소드 오버로딩
	public static int sum(int x, int y, int z) {
		return x+y+z;
	}
	
	public static int sum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			 sum += i;
		}return sum;
	}

//	가변인자를 이용한 덧셈 , 위의 []과...은 같은 뜻 , 가변인자를 사용하면 호출할때 따로 배열을 만들지 않고 바로 값을 입력 가능
	public static int sum2(int... nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}return sum;
	}
	
	
	public static void main(String[] args) {
		int result = sum(15, 30);
		System.out.println(result);
		result = sum(10, 20, 30);
		System.out.println(result);
		int[] nums = {1,2,3,4,5,6,7};
		result = sum(nums);
		System.out.println(result);

		sum2(10, 20);
		sum2(10, 20, 30, 40, 50);
		result = sum2(10, 20, 30, 40, 50);
		System.out.println(result);
	

//		표준API에 적용된 가변인자
		int x = 50, y = 30;
		System.out.printf("%1$d, %2$d" , x, y);
		
		
	}
}
