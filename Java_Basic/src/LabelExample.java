
//		Label 

public class LabelExample {

	public static void main(String[] args) {

		
		
		OUT: // Label 선언, 모두 대문자로 쓰는것이 관례
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i + "," + j);
				if(j==5) {
					break OUT; // Label 사용
				}
			}
		}				
		
	}

}
