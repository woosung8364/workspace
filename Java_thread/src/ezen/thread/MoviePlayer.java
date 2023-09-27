package ezen.thread;
/**
 * 스레드에 의해 독립적으로 실행되는 코드 블럭
 * @author 배종현
 *
 */
public class MoviePlayer implements Runnable {

	public void play() {
		while (true) {
			System.out.println("동영상 재생중 . . .");
		}
	}
	
	@Override
	public void run() {
		play();
	}

}
