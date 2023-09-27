package ezen.oop.ams;

public class MinusAccount extends Account {

//	부모클래스에 없는 필드나 메소드 추가
	private long borrowMoney;
	
//	부모클래스의 생성자는 상속되지않아서 같이 만들어줘야함
	public MinusAccount() {
//		super();  작성하지 않아도 컴파일시 자동으로 생성해줌 (부모의 디폴트생성자를 호출 해주는 코드)
	}
	

	
	public MinusAccount(String accountOwner, int passwd, long restMoney, long borrowMoney) {
//	부모클래스의 생성자 호출을 이용한 초기화
		super(accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}
	
	
	
//	메소드 추가
	public long getBorrowMoney() {
		return borrowMoney;
	}
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
//	필요에 따라 부모클래스의 메소드를 재정의(overriding)
	@Override
	public long getRestMoney() {
		return super.getRestMoney()-borrowMoney;
	}
	@Override
	public String toString() {
		return super.getAccountNum() + "\t" + super.getAccountOwner()  + "\t******\t" +borrowMoney;
	}
	
	
	
}
	