package ezen.oop.api;

public class StringbufferExample {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Java");
//		코드체이닝 가능
		sb.append("!").append("?").append(123);
		System.out.println(sb);
		sb.insert(4, '-');
		System.out.println(sb);
		
		
	}

}
