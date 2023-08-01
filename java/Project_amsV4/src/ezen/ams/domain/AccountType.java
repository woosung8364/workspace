package ezen.ams.domain;

/*
 * enum 클래스 - AccountType
 */

//한정된 값 (상수) 들의 집합
//생성자 , getter , 상수
public enum AccountType {
	ALL_ACCOUNT("전체계좌"), GENERAL_ACCOUNT("입출금계좌"), MINUS_ACCONUT("마이너스계좌");
	
	private final String name;
	
	private AccountType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
