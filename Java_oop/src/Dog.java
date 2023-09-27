
//	일상생활의 강아지(객체)를 프로그램으로 표현한 클래스

public class Dog {
//	인스턴스 변수들 (필드)
	private String name;
	private String type;
	private int age;
	
//	생성자에 의해 초기화하지 않은 인스턴스변수는 JVM에 의해 실행 시 자동 초기화 된다.
//	정수(byte, short, int, long) : 0
//	실수(float, double) : 0.0
//	문자(char) : 0
//	논리값(boolean) : false
//	참조형 : null
	
	
//	작성하지 않을 시 컴파일러에 의해 자동 생성되는 디폴트 생성자
 	Dog (){
	name = null;
	type = null;
	age = 0;
	}

//	개발자가 정의하는 생성자
	public Dog (String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
//	생성자 오버로딩(중복정의)
	public Dog (String name, String type) {
//		this.name = name;
//		this.type = type;
		this(name, type, 0);
	}
	
	public Dog (String name, int age) {
//		this.name = name;
//		this.age = age;
		this(name, null, age);
	}
//	불필요한 중복 코드 방지를 위해 this를 사용 가능.
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	//	인스턴스 메소드
	void bark () {
		System.out.println(name + "가 왈왈 짖습니다.");
	}
	
	void eat () {
		System.out.println(name + "가 먹이를 먹습니다.");
	}
	
	
}
