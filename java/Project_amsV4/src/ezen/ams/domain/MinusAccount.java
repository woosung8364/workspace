package ezen.ams.domain;

public class MinusAccount extends Account {
//	부모클래스에 없는 필드나 메소드 추가
	private long borrowMoney;
	public static String accountType2;
	
	
	
	public MinusAccount() {
//		컴파일시 부모클래스의 디폴트생성자를 호출하는 super(); 자동 추가
		super();
	}
	
	public MinusAccount(String accountOwner, int passwd, long restMoney, long borrowMoney) {
//		부모클래스의 생성자 호출을 이용한 초기화
		//super();
		super(accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
		this.accountType2="마이너스 계좌";
	}

	// 메소드 추가
	public long getBorrowMoney() {
		return borrowMoney;
	}


	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	
	
	public String getAccountType2() {
		return accountType2;
	}

	public void setAccountType2(String accountType2) {
		this.accountType2 = accountType2;
	}

	// 필요에 따라 부모클래스클래스의 메소드 재정의(Overriding)
	@Override
	public long getRestMoney() {
		return super.getRestMoney() - borrowMoney;
	}


	
	
	
	
	
}














