package ezen.thread;

public class Dog extends Thread{
//	private String name;
	private int num;
	
	
	public Dog () {
		this("익명", 0);
	}
	public Dog (String name, int num) {
		super(name);
		this.num=num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public void race() {
		System.out.println("----"+getName() + "강아지 출발----");
		for (int i = 1; i <= 100; i++) {
			int delayTime = (int)(Math.random()*500);
			System.out.println(getName() + " 강아지 " + i + " 미터 전진");
			try {
				Thread.sleep(delayTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} System.out.println("----"+getName() + "강아지 도착----");
	}
	
	@Override
	public void run() {
		race();
	}
	
	
}
