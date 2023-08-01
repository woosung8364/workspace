package ezen.oop;

public class Person {
	String name;
	int age;
	
	@Override
	public String toString() {
		return "일반인";
	}
}

class Worker extends Person{
	@Override
	public String toString() {
		return "근로자";
	}
}

class SStudent extends Person{
	@Override
	public String toString() {
		return "학생";
	}
}

class MiddleStudent extends SStudent{
	@Override
	public String toString() {
		return "중딩이";
	}
}


class HighStudent extends SStudent{
	@Override
	public String toString() {
		return "고딩이";
	}
}



















