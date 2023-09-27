package ezen.oop;

public enum Direction {
	NORTH("북쪽"), WEST("서쪽"), EAST("동쪽"), SOUTH("남쪽");
	
	
	private final String name ;
	
	private Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

//	필요에 따라 기능 추가 가능
	
}
