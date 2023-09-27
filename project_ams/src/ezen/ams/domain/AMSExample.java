package ezen.ams.domain;

import ezen.ams.exception.NotBalanceException;

public class AMSExample {

	public static void main(String[] args) {
		Account account = new Account("배종현", 1111, 10000);
		try {
			long restMoney = account.deposit(1000);
			System.out.println("정상처리 : " + account.getRestMoney());
			
			restMoney = account.withdraw(1000);
			System.out.println("출금 후 잔액: " + restMoney);
		} catch (NotBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

}
