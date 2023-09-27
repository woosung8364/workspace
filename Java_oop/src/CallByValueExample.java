import ezen.oop.ams.Account;

//	call by value 개념

public class CallByValueExample {

	public static int sum(int x, int y) {
		x += 50;
		return x+y;
	}
	

	public static void doTask(Account account) {
		account.deposit(500000);
	}
	
	public static void main(String[] args) {

		int x = 50, y = 60;
//		call by value
		int result = sum(x, y);
		System.out.println(result);
		System.out.println(x);
		
		Account account = new Account("배종현", 1234, 1000);
//		call by value
		doTask(account);
		long restmoney = account.getRestMoney();
		System.out.println(restmoney);
	}

}
