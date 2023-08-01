package ezen.oop;

public class Robot {
	
	public void move(Direction direction) {
		switch (direction) {
			case NORTH: System.out.println("북쪽으로 이동>>>"); break;
			case SOUTH: System.out.println("남쪽으로 이동>>>"); break;
			case EAST: System.out.println("동쪽으로 이동>>>"); break;
			case WEST: System.out.println("서쪽으로 이동>>>"); break;
		}
	}
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.move(Direction.NORTH);
		robot.move(Direction.WEST);
//		robot.move(1000); // 타입에 안전한 열거형
		
//		열거형 목록
		Direction[] directions = Direction.values();
		for (Direction direction : directions) {
//			System.out.println(direction);
			System.out.println(direction.getName());
		}
		
//		해당 열거형 객체 검색
		Direction direction = Direction.valueOf("NORTH");
//		System.out.println(direction);
		System.out.println(direction.getName());
		
		System.out.println(direction.ordinal());
		System.out.println(direction.name());
		
//		Enum은 생성자 호출로 생성할 수 없다..
//		Direction d = new Direction();
		
	}

}








