package ezen.oop.ams;

public class MinusAccountExample {

	public static void main(String[] args) {
//		부모클래스로부터 상속받은 필드 및 메소드 재사용
		MinusAccount minusAccount = new MinusAccount("김대출", 1233, 10000, 10000000);
//		부모클래스의 메소드 재사용		
		String accountNum = minusAccount.getAccountNum();
		System.out.println(accountNum);
//		추가된 메소드 사용
		System.out.println(minusAccount.getBorrowMoney());
//		재정의된 메소드 사용
		System.out.println(minusAccount.getRestMoney());
		
		Account account = new Account("배종현", 1111, 10000);
		
	}

}
