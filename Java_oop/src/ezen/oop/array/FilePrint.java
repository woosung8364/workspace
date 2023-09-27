package ezen.oop.array;

//	특정 파일 이름을 전달받아 파일 내용을 콘솔창에 출력하는 예제

public class FilePrint {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("사용법 : java FilePrint <파일명>");
			return;
		}
		String fileName = args[0];
		System.out.println("읽어들인 파일 이름 : " + fileName);
	} 

}

//  자바 교재 190p ~