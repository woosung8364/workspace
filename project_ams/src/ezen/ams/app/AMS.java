package ezen.ams.app;

import java.util.Scanner;

import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.MemoryAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.exception.NotBalanceException;

public class AMS {

	private static AccountRepository repository = new MemoryAccountRepository();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("*****************************************");
		System.out.println("** " + Account.BANK_NAME + "은행 계좌 관리 애플리케이션 **");
		System.out.println("*****************************************");

//		가상 데이터 임시 등록
		repository.addAccount(new Account("배종현", 1234, 500000));
		repository.addAccount(new Account("김기정", 1234, 100000));
		repository.addAccount(new Account("홍길동", 1234, 300000));
		repository.addAccount(new Account("배종현", 1234, 300000));
		repository.addAccount(new MinusAccount("배종현", 1234, 0, 100000));

		boolean run = true;

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.입금|4.출금|5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				// 계좌 생성 및 등록
				createAccount();
			} else if (selectNo == 2) {
				// 계좌목록
				accountList();
			} else if (selectNo == 3) {
				// 입금
				deposit();
			} else if (selectNo == 4) {
				// 출금
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		scanner.close();
		System.out.println("계좌관리 애플리케이션을 종료합니다.");
	}

	/**
	 * 키보드(표준입력)로부터 계좌정보 입력 받아 계좌생성하기
	 */

	private static void createAccount() {

		
		
		
		
		
		System.out.println("생성할 계좌");
		System.out.println("1.일반계좌 2.마이너스계좌");
		System.out.print("선택> ");
		int accountType = Integer.parseInt(scanner.nextLine());
			System.out.print("예금주명: ");
			String owner = scanner.nextLine();

			System.out.print("비밀번호: ");
			int passwd = Integer.parseInt(scanner.nextLine());
		if (accountType == 1) {
			System.out.print("입금액: ");
			long inputMoney = Long.parseLong(scanner.nextLine());

			Account account = new Account(owner, passwd, inputMoney);

			// AccountRepository에 계좌등록
			repository.addAccount(account);
		} else {			
			System.out.print("대출금액: ");
			long borrowMoney = Long.parseLong(scanner.nextLine());
			MinusAccount minusaccount = new MinusAccount(owner, passwd, 0, borrowMoney);
			// AccountRepository에 계좌등록
			repository.addAccount(minusaccount);
		}
		System.out.println("※ 계좌 정상 등록 처리되었습니다.");
	}
	
	/**
	 * 등록된 계좌번호를 불러오기
	 * 
	 * @return 전체 계좌 정보
	 */

	private static Account[] accountList() {
		System.out.println("----------------------------------------------");
		System.out.println("계좌타입\t번호\t예금주\t비밀번호  잔액");
		System.out.println("----------------------------------------------");

		Account[] list = repository.getAccounts();
		for (int i = 0; i < repository.getCount(); i++) {
			if (list[i] instanceof MinusAccount) {
				System.out.println("마이너스계좌\t" + list[i]);
			} else {
				System.out.println("입출금계좌\t" + list[i]);
			}
		}
		return list;
	}

	/**
	 * 입금 기능
	 * 
	 * @throws NotBalanceException
	 */

	private static void deposit() {
		System.out.print("계좌번호: ");
		String accountNum = scanner.nextLine();
		Account a = repository.searchAccount(accountNum);
		if (a != null) {
			System.out.print("비밀번호: ");
			int passwd = Integer.parseInt(scanner.nextLine());
			if (passwd == a.getPasswd()) {
				System.out.print("입금 금액: ");
				try {
					long inputMoney = Long.parseLong(scanner.nextLine());
					long money = a.deposit(inputMoney);
					System.out.println("총금액: " + money);
				} catch (NotBalanceException e) {
					System.out.println(e.getMessage());
				}

			} else {
				System.out.println("비밀번호가 잘못되었습니다.");
			}
		} else {
			System.out.println("입력한 계좌번호 정보가 없습니다.");
		}
	}

	/**
	 * 출금기능
	 * 
	 * @throws NotBalanceException
	 */
	private static void withdraw() {
		System.out.print("계좌번호: ");
		String accountNum = scanner.nextLine();
		Account a = repository.searchAccount(accountNum);
		if (a != null) {
			if (a instanceof Account) {
				System.out.print("비밀번호: ");
				int passwd = Integer.parseInt(scanner.nextLine());
				if (passwd == a.getPasswd()) {
					System.out.print("출금 금액: ");
					try {
						long inputMoney = Long.parseLong(scanner.nextLine());
						long money = a.withdraw(inputMoney);
						System.out.println("총금액: " + money);
					} catch (NotBalanceException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("비밀번호가 잘못되었습니다.");
				}
			} else if (a instanceof MinusAccount) {
				System.out.print("비밀번호: ");
				int passwd = Integer.parseInt(scanner.nextLine());
				if (passwd == a.getPasswd()) {
					System.out.print("출금 금액: ");
					try {
						long inputMoney = Long.parseLong(scanner.nextLine());
						MinusAccount b = (MinusAccount) a;
						long money = b.withdraw(inputMoney);
						System.out.println("총금액: " + money);
					} catch (NotBalanceException e) {
						System.out.println(e.getMessage());
					}

				}
				System.out.println("비밀번호가 잘못되었습니다.");
			}
		} else {
			System.out.println("입력한 계좌번호 정보가 없습니다.");
		}

	}

}
