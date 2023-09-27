package ezen.thread;

public class ATMExample2 {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		new Thread() {
			@Override
			public void run() {
				synchronized (atm) {
					while (true) {
						atm.notify();
						atm.withdrawMoney("1111-2222", 1111, 10000, "아빠");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				synchronized (atm) {
					while (true) {
						atm.notify();
						atm.withdrawMoney("1111-2222", 1111, 10000, "아들");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
	}

}
