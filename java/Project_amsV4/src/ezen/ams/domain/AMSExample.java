package ezen.ams.domain;

import ezen.ams.exception.NotBalanceException;

public class AMSExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account("김기정" , 1111 , 10000);
		try {
			account.deposit(1000);
		} catch (NotBalanceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상처리: " + account.getRestMoney());
		
		try {
			account.withdraw(0);
		} catch (NotBalanceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(account.getRestMoney());
	}

}
