package ezen.thread;

public class DogRaceApp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("지금부터 강아지 경주를 시작합니다.");
		System.out.println("강아지 입장>>>");
		
		Dog dog1 = new Dog("희영",1);
		Dog dog2 = new Dog("재헌",2);
		Dog dog3 = new Dog("종현",3);
		Dog dog4 = new Dog("정환",4);
		Dog dog5 = new Dog("영호",5);
		Dog dog6 = new Dog("성민",6);
		
		System.out.println("시작");
		
		dog1.start();
		dog2.start();
		dog3.start();
		dog4.start();
		dog5.start();
		dog6.start();
		
		dog1.join();
		dog2.join();
		dog3.join();
		dog4.join();
		dog5.join();
		dog6.join();
		
		System.out.println("강아지 경주를 종료합니다.");
	}

}
