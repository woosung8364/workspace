package ezen.oop.array;

//	배열 복사하기

public class ArrayExample4 {
//	배열 복사 기능
	public static int[] arrayCopy (int[] array, int increament) {
		int[] copyArray = new int[array.length+increament];
		for (int i = 0; i < array.length; i++) {
			copyArray[i] = array[i];
			
		}
		return copyArray;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int [] array = {5,1,3,7,4,2,6,9,8};
		
//		int [] array2 = new int[array.length + 1];
//		for (int i = 0; i < array.length; i++) {
//			array2[i] = array[i];
//		}
//		for (int i = 0; i < array2.length; i++) {
//			System.out.println(array2[i]);
//		}
		
//		메소드 호출을 이용한 배열 복사
		int[] copyArray = arrayCopy(array, 2);
		for (int i = 0; i < copyArray.length; i++) {
			System.out.println(copyArray[i]);
		}
				
//		배열을 정렬하는 로직
//		for (int i = 0; i < array.length; i++) {			
//			for (int j = i; j < array.length; j++) {
//				if(array[j]<array[i]) {
//					int a = array[j];
//					array[j]=array[i];
//					array[i] = a;
//				} 
//			}
//		}
		
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length-1; j++) {
//				int temp = 0;
//				if(array[j]>array[j+1]) {
//					temp = array[j];
//					array[j]=array[j+1];
//					array[j+1] = temp;
//							
//				}
//			}
//		}
//		

		ArrayUtil.sort(array, ArrayUtil.ASC);
		ArrayUtil.sort(array, ArrayUtil.DESC);
		
		
//		배열 정렬하여 출력하기
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		
		
	}

}
