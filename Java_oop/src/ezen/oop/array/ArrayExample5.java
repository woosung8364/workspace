package ezen.oop.array;

//	동적 다차원 배열

public class ArrayExample5 {

	public static void main(String[] args) {
//		int[][] scores;
//		scores = new int[5][];
//		scores[0] = new int[10];
//		scores[1] = new int[9];
//		scores[2] = new int[11];
//		
//		scores[0][0] = 100;
////		...
//		scores[2][10] = 85;
		
		
		int[][] scores = {{100,50,10}, {55,70}, {70,80,90}};
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + ",");				
			}
			System.out.println();
		}
		
		
		
	}

}
