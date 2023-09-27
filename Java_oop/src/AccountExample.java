

import ezen.oop.ams.Account;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();

//		account.accountNum = "12-345";
		account.setAccountNum("111-222-333-444");
//		account.accountOwner = "배종현";
		account.setAccountOwner("배종현");
//		account.passwd = 1234;
		account.setPasswd(1234);
//		account.restMoney = 1000000;
		account.setRestMoney(1000000);

//		기능 사용

		
		if (account.checkPassWd(1234)) {

			long money = account.getRestMoney();
			System.out.println("현재 잔액 : " + money);
			long resMoney = account.deposit(1000000L);
			System.out.println("입금 후 잔액 : " + resMoney);

			System.out.println("출금 후 잔액 : " + account.withdraw(10000L)); // 변수 선언 없이 바로 출력

		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}

//		static변수는 클래스이름으로 접근 가능하다.
//		Account.bankName = "이젠은행"; 
		System.out.println(Account.BANK_NAME);
		
		Account a1 = new Account("배종현", 1111, 10000);
		Account a2 = new Account("종현", 1111, 10000);
		Account a3 = new Account("현", 1111, 10000);
		
		System.out.println(a1.getAccountNum());
		System.out.println(a2.getAccountNum());
		System.out.println(a3.getAccountNum());
		
//		스태틱메소드도 스태틱변수처럼 인스턴스 생성 없이 클래스이름으로 바로 접근하여 사용할 수 있다.
		System.out.println(Account.getAccountId());
	}

}
