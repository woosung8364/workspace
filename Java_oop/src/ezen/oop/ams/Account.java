package ezen.oop.ams;

import java.util.Objects;

//	은행계좌 추상화

public class Account {
//	필드 캡슐화
//	인스턴스변수들 (필드)
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	
//	스태틱(정적)변수 / 클래스변수 
//	상수
	public final static String BANK_NAME = "이젠은행"; // static 변수는 사용하는쪽 (메인메소드)에서도 초기화 가능
//	private static int accountId = 1000;
	private static int accountId;
	
//	초기화 블록
//	static 초기화 블록
	static{
//		System.out.println("초기화 블록 실행됨");
//	주로 애플리케이션 환경설정 파일 내용을 읽어오는 코드
		accountId = 1000;
	}
	
//	생성자 , 오버로딩
	public Account() {}
	
	public Account(String accountOwner, int passwd, long restMoney) {
//		System.out.println("생성자 실행됨");
		this.accountNum = (accountId++) + "";
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	public Account(String accountOwner, int passwd) {
		this.accountOwner=accountOwner;
		this.passwd=passwd;
	}
	
//	setter & getter 메소드
//	자동 생성 단축키 ALT+Shift+S >> [generate getters & setters]
	


	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	
//	입금기능
	public long deposit(long money) {
		return restMoney += money;
	}

//	출금기능
	public long withdraw(long money) {
		return restMoney -= money;
	}

//	잔액조회
	public long getRestMoney() {
		return restMoney;
	}

//	비밀번호확인
	public boolean checkPassWd(int pwd) {
		return passwd == pwd;
	
	}
		
// 	계좌 모든 정보 확인
	public void printInfo () {
		System.out.println(accountNum + "\t" + accountOwner  + "\t******\t" + restMoney);
	}
	
	
	@Override
	public String toString() {	
		return accountNum + "\t" + accountOwner  + "\t******\t" + restMoney;
//		return "Account [accountNum=" + accountNum + ", accountOwner=" + accountOwner + ", passwd=" + passwd
//				+ ", restMoney=" + restMoney + "]";
	}
			
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

	//	스태틱 (클래스) 메소드
	public static int getAccountId() {
		return accountId;
	}


	
	
}
