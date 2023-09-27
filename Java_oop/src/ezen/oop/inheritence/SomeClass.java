package ezen.oop.inheritence;

public class SomeClass {

	public void showShape(Shape shape) {
		if(shape instanceof Circle) {
			shape.draw();
			Circle circle = (Circle)shape;
			System.out.println(circle.getRadian());
			
		}
	}
	
	
}
