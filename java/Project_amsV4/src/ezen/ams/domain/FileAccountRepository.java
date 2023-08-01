package ezen.ams.domain;

import java.util.List;

public class FileAccountRepository implements AccountRepository {

	
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account searchAccount(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean removeAccout(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean removeAccount(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
