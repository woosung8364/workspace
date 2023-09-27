package ezen.oop.inheritence;

import ezen.oop.ams.Account;
import ezen.oop.ams.MinusAccount;

public class InstanceofExample {

	public static void main(String[] args) {
		MinusAccount minusAccount = new MinusAccount();
		System.out.println(minusAccount instanceof MinusAccount);
		System.out.println(minusAccount instanceof Account);
		System.out.println(minusAccount instanceof Object);
	}

}
