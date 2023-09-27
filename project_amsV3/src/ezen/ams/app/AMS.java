package ezen.ams.app;

import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.view.AmsFrame;

public class AMS {

	public static AccountRepository repository = new ListAccountRepository();

	public static void main(String[] args) {
		AmsFrame frame = new AmsFrame("EZEN_BANK_AMS");
		frame.init();
		frame.pack();
		frame.setResizable(false);
		frame.addEventListner();
		frame.setVisible(true);
		
		// 임시 더미데이터 입력
		repository.addAccount(new Account("김기정", 1111, 100000000));
		repository.addAccount(new Account("강소영", 1234, 100000000));
		repository.addAccount(new Account("이희영", 1234, 100000000));
		repository.addAccount(new Account("김기정", 1111, 10000));
		repository.addAccount(new MinusAccount("김대출", 1111, 10000, 10000000));
		repository.addAccount(new MinusAccount("강대출", 1111, 10000, 10000000));
		repository.addAccount(new Account("김기정", 2222, 20000));
	}	

}
