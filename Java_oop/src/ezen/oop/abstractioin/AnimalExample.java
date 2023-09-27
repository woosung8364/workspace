package ezen.oop.abstractioin;

public class AnimalExample {

	public static void main(String[] args) {

//		추상클래스는 new 생성자 호출을 이용하여 생성할 수 없다.
//		Animal animal = new Animal;

//		추상클래스는 타입으로 선언은 가능
		Animal animal;
		animal = new Dog("루니", 7);
		animal.eat();
		animal.sleep();
		animal.walk();
		System.out.println();
		animal = new Cat("야옹이", 3);
		animal.eat();
		animal.sleep();
		animal.walk();
	
//		새롭게 추가된 메소듣 호출을 위해 강제형변환
//		animal.jump();
		Cat cat = (Cat)animal;
		cat.jump();
		
		
	}

}
