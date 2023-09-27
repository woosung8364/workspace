package ezen.oop.inheritence;

/**
 * 추상클래스 정의
 * @author 배종현
 */
public abstract class Shape {
	protected double x;
	protected double y;
	
//	추상메소드
//	이 클래스를 상속받아 만들어지는 클래스들이 반드시 만들어야하는 메소드
	public abstract void draw(); 
	public abstract double getLength();
	public abstract double getArea();

}
