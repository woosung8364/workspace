package ezen.oop.inheritence;

import ezen.oop.ams.Account;
import ezen.oop.ams.AccountRepository;
import ezen.oop.ams.MinusAccount;

public class PolymorphismExample {

	public static void main(String[] args) {
//		클래스 자동형변환
		Shape shape; // = new Shape();
		shape = new Circle(10, 10, 100);
		shape.draw();
		shape = new Lectangle(10,10, 200, 200);
		shape.draw();
		
		
		SomeClass some = new SomeClass();
//		some.showShape(new Shape());
		some.showShape(new Circle(10, 10, 50));
		some.showShape(new Lectangle());
		
		
		
		AccountRepository repository = new AccountRepository();
		repository.addAccount(new Account("배종현", 1111, 10000));
		repository.addAccount(new Account("배종현", 1111, 20000));
		repository.addAccount(new MinusAccount("김기정", 1111, 50000, 500000));
		repository.addAccount(new MinusAccount("강기정", 1111, 50000, 500000));
		
		Account[] list = repository.getAccounts();
		for (int i = 0; i < repository.getCount(); i++) {
			if(list[i] instanceof MinusAccount) {
				System.out.println("마이너스계좌\t" + list[i]);
			}else {
				System.out.println("입출금계좌\t" + list[i]);
			}
			
		}
		
		
		String message1 = "Java King!";
		String message2 = "Java King!";
		System.out.println(message1.equals(message2));

		Account account1 = new Account("배종현", 1111, 10000);
		Account account2 = new Account("배종현", 1111, 10000);
		System.out.println(account1.equals(account2));
//		Object의 equals메소드는 객체의 "주소값"이 동일한지 비교하는것
//		내용을 비교하려면 오버라이딩 해줘야함
		
//		강제형변환
		Account account = new MinusAccount("김기정", 1111, 50000, 500000);
//		자동형변환의 경우 자식클래스에서 재정의한 메소드인 경우 호출 가능
		System.out.println(account.getRestMoney());
//		추가된 필드나 메소드인 경우 호출 불가능
//		account.getBorrowMoney();
		
//		추가된 메소드 호출이 가능하도록 강제형변환 필요
		MinusAccount minusAccount = (MinusAccount)account;
		System.out.println("대출금액 : " + minusAccount.getBorrowMoney());
		
		Account searchAccount = repository.searchAccount("1002");
		System.out.println(searchAccount);
		minusAccount = (MinusAccount)searchAccount;
		System.out.println(minusAccount.getBorrowMoney());
		
	}

}
