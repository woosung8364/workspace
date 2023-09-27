package ezen.oop;

public class StudentAgent implements Rentable<Student<String>> {

	@Override
	public Student<String> rent() {
		Student<String> student = new Student<>("배종현", "1234");
		return student;
	}

	public static void main(String[] args) {
		
		Rentable<Student<String>> rentable = new StudentAgent(); 
		Student<String> student = rentable.rent();
		System.out.println(student);
		
	}


}
