package ezen.thread;

public class ATM {

	/** 테스트를 위한 공유 계좌 */
    Account account = new Account("방그리가족통장", 1111, 100000);
    
    /** 입금 */
    public void depositMoney(String accountNum, int passwd, long money, String user){
        System.out.println("***** " + user + " 입금 시작 *****");
        // 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        account.deposit(money);
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println(user + " 입금 후 잔액 : " + account.getRestMoney());
        System.out.println("***** " + user + " 입금 완료 *****");
    }
    
    
    /** 출금 */
    public /*synchronized*/ void withdrawMoney(String accountNum, int passwd, long money, String user){
        System.out.println("***** " + user + " 출금 시작 *****");
        if (money > account.getRestMoney()) {
            throw new RuntimeException("-> 잔액이 부족합니다.");
        }
        // 본점 서버와의 통신에 약간의 시간이 소요된다 가정..
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        try {
        	// 실행 대기 상태에 있는 다른 쓰레드가 withdrawMoney() 를 사용할 수
        	// 있도록 Object의 notify() 메소드 호출
//        	this.notify();
//        	notify(); // notifyAll();
//        	notify();
        	account.withdraw(money);
        	// 10000원 씩 공평하게 출금할 수 있도록 현재 스레드 일시정지
        	//this.wait();
//        	wait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("->" + user + " 출금 후 잔액 : " + account.getRestMoney());
        System.out.println("***** " + user + " 출금 완료 *****");
    }
}




