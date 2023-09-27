package ezen.ams.domain;

/**
 * 은행계좌 목록 저장 및 관리 명세
 * @author 배종현
 */

public interface AccountRepository {

	public int getCount();
	public Account[] getAccounts();
	public boolean addAccount(Account account);
	public Account searchAccount(String accountNum);
	public Account[] searchAccountByOwner(String accountOwner);
	public boolean removeAccout(String accountNum);
	
}
