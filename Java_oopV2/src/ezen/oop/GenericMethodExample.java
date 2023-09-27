package ezen.oop;

public class GenericMethodExample  {

	
//	제너릭 메소드
	public static <T> Box<T> makeBox(T t) {
		Box<T> box = new Box<>();
		box.setItem(t);
		return box;
	}
	
	
//	public 리턴타입 메소드명(제네릭타입<? extends Student> 변수) {...} // Student를 상속 받은 클래스들만 매개변수로 사용 가능
//	public 리턴타입 메소드명(제네릭타입<? super Worker> 변수) {...} // Worker보다 상위 클래스만 매개변수로 사용 가능
	
	
	
		
	public static void main(String[] args) {
	
		Box<Robot> box = makeBox(new Robot());
		Robot robot = box.getItem();
		System.out.println(robot);
	
	}

}
