package ezen.oop.array;

public class ArrayUtil {

//	배열 복사 기능
	public static int[] arrayCopy(int[] array, int increament) {
		int[] copyArray = new int[array.length + increament];
		for (int i = 0; i < array.length; i++) {
			copyArray[i] = array[i];

		}
		return copyArray;
	}

//	오름차순, 내림차순을 구분하기 위한 상수
	public static final int ASC = 0;
	public static final int DESC = 1;

//	배열 정렬 기능 (오름차순, 내림차순 모두 지원)
	public static void sort(int[] array, int sortBy) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				int temp = 0;
				if (sortBy == ASC) {
					if (array[j] > array[j + 1]) {
						temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				} else {
					if (array[j] < array[j + 1]) {
						temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
		}
	}
}
