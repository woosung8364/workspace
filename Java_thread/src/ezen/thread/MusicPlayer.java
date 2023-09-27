package ezen.thread;

/**
 * 사용자 정의 스레드
 * @author 배종현
 *
 */

public class MusicPlayer extends Thread {
//	사용자 스레드 엔트리포인트	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("음악재생 : " + i);
		}
	}
	
	
}
