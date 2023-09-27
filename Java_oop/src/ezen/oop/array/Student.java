package ezen.oop.array;

//	학생정보 추상화/캡슐화
//	마커인터페이스(추상메소드가 없는 멍텅구리 인터페이스)

public class Student implements Cloneable {
	public static final String SCHOOL_NAME = "이젠초등학교";
//	관례대로 상수는 인스턴스보다 위에 
	private int no;
	private String name;
	private int score;
	
//	생성자
	public Student() {}
	public Student(int no, String name, int score) {
		this.no = no;
		this.name = name;
		this.score = score;
	}
	
//	getter & setter 메소드
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

//	학생 모든 정보를 출력하는 기능
	public void printInfo () {
		System.out.println(no + "\t" + name + "\t" + score);
	}
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
		Student student = (Student) obj;
			if(toString().equals(student.toString())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


