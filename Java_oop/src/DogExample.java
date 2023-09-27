
//	애플리케이션(Main) 클래스

public class DogExample {

	public static void main(String[] args) {
//		위치상 지역변수, 기본 데이터타입
//		int age = 50;
		
//		메모리상에 Dog 인스턴스 생성
//		위치상 지역변수, 레퍼런스 데이터타입 (참조 자료형)
		Dog dog; // Dog 자체가 기본 데이터타입 의 char, int, ... 와 같이 Dog 자체가 타입이 됨

//		디폴트 생성자 호출을 이용한 인스턴스 생성
		dog = new Dog(); // Dog인스턴스 자체가 dog에 들어가는것이 아니고 컴퓨터 바탕화면의 바로가기와 같은 Dog인스턴스의 주소가 할당되는 원리
		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());
						
//		인스턴스의 속성(상태) 변경
		dog.setName("루니");
		dog.setType("비숑");
		dog.setAge(0);
		
		dog = new Dog("루니", "비숑", 8);
		
		
		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());				
		dog.bark();

		Dog dog2 = new Dog("메리", "진돗개");
		System.out.println(dog2.getName());
		System.out.println(dog2.getType());
		System.out.println(dog2.getAge());
		
	}

}
