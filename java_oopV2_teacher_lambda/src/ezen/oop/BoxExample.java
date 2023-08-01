package ezen.oop;

public class BoxExample {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setItem("기아 트윈즈");
		String item = box.getItem();
		System.out.println(item);
		
//		Box<Robot> box2 = new Box<Robot>();
		Box<Robot> box2 = new Box<>();
		box2.setItem(new Robot());
		Robot robot = box2.getItem();
		robot.move(Direction.NORTH);
		
	}

}







