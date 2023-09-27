package ezen.oop.inheritence;

public class ShapeExample {

	public static void main(String[] args) {

//		Shape shape = new Shape(10, 10);
//		shape.draw();
//		System.out.println(shape.getLength());
//		System.out.println(shape.getArea());
//		Object의 toString() 재사용
//		System.out.println(shape.toString());

//		추상클래스는 인스턴스 생성 X
//		그러나 데이터타입으로는 사용 가능함
		Shape shape = new Circle(10, 10, 5);
//		재정의
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		System.out.println(shape.toString());

		shape = new Lectangle(10, 10, 100, 50);
//		재정의
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		System.out.println(shape.toString());
//		참조변수를 출력하면 자동으로 Object의 toString() 메소드가 자동 호출된다.
//		주소값을 연산하지 못하게 하는 역할의 메소드
		System.out.println(shape);				
		
		
		
	}

}
