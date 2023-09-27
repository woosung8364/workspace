package ezen.oop.api;

public class MathExample {

	public static void main(String[] args) {

		double d = 69.4;

//		반올림
		System.out.println(Math.round(d));
//		올림
		System.out.println(Math.ceil(d));
//		내림
		System.out.println(Math.floor(d));

		
		System.out.println(Math.random());
		
		for (int i = 0; i < 6; i++) {
			int num = (int) (Math.random()*45)+1;
			System.out.print(num + ",");
		}

	}

}
