package ezen.oop.inheritence;

public class Circle extends Shape {

	private double radian;

	public Circle() {}

	public Circle(double x, double y, double radian) {
		this.x=x;
		this.y=y;
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}
	

	@Override
	public void draw() {
		System.out.println("중심좌표가 " + x + " , " + y + " 이고 반지름이 " + radian + " 인 원입니다");
	}

	@Override
	public double getLength() {
		return 2 * Math.PI * radian;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radian, 2);
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", getX()=" + x + ", getY()=" + y + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

}
