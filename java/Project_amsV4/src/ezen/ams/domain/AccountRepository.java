package ezen.ams.domain;

import java.util.List;

/**
 * 은행계좌 목록 저장 및 명세
 * 
 * @author 송우성
 */
public interface AccountRepository {

	public int getCount(); //추상메소드
	List<Account> getAccounts();
	public boolean addAccount(Account account);
	public Account searchAccount(String accountNum);
	public List<Account> searchAccountByOwner(String accountOwner);
	public boolean removeAccout(String accountNum);
	boolean removeAccount(String accountNum);
}
