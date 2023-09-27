package ezen.oop;

public class Course {
	
	
	// 누구나 등록 가능
	public void addCourse(Applicant<?> applicant) {
		System.out.println(applicant.getKind().toString());
	}
	
	// 학생만 등록 가능
	public void addCourse2(Applicant<? extends SStudent> applicant) {
		System.out.println(applicant.getKind().toString());
	}
	
	// 성인만 등록 가능
	public void addCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().toString());
	}
	
	public static void main(String[] args) {
		Course course = new Course();
//		Applicant<Person> person = new Applicant<>(new Person());
		Applicant<MiddleStudent> person = new Applicant<>(new MiddleStudent());
		course.addCourse(person);
		
		course.addCourse2(new Applicant<SStudent>(new SStudent()));
		course.addCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		course.addCourse2(new Applicant<HighStudent>(new HighStudent()));
//		course.addCourse2(new Applicant<Worker>(new Worker()));
		
		
//		course.addCourse3(new Applicant<SStudent>(new SStudent()));
//		course.addCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
//		course.addCourse3(new Applicant<HighStudent>(new HighStudent()));
		course.addCourse3(new Applicant<Worker>(new Worker()));
	}
	

}






