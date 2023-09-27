package ezen.oop.ams;

public class AccountExample {

	public static void main(String[] args) {
		
		Account account = new Account("배종현", 1111, 100000);
//		커맨드창에 출력하든 GUI 출력하든 웹 화면에 출력하게 출력하든 모든 재사용할 수 있다.
		System.out.println(account);		
	
		MinusAccount ma = new MinusAccount("배종현", 1111, 1000000, 500000000);
		System.out.println(ma);
	}

}
