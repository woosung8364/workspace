package ezen.oop;

public class Student<T> /* implements Comparable<Student<Integer>>*/{
	
	private String name;
	private T ssn;
	
	public Student() {
		super();
	}
	
	public Student(String name, T ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getSsn() {
		return ssn;
	}

	public void setSsn(T ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ssn=" + ssn + "]";
	}
	
	@Override
	public int hashCode() {
//		System.out.println("HashSet이 hashCode() 호출함...");
		return toString().hashCode();
//		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
//		System.out.println("HashSet이 equals() 호출함...");
		if(obj instanceof Student) {
			return toString().equals(obj.toString());
		}
		return false;
	}
	
	/*
	@Override
	public int compareTo(Student<Integer> student) {
		System.out.println("compareTo() 호출됨...");
//		if(ssn == student.getSsn()) {
//			return 0;
//		} else if(((Integer)ssn).intValue() < student.getSsn().intValue()) {
//			return -1;			
//		} else {
//			return 1;
//		}
//		return ((Integer)ssn).intValue() - student.getSsn().intValue();
		return student.getSsn().intValue() - ((Integer)ssn).intValue();
	}
	*/
	
	
	public static void main(String[] args) {
		Student<String> student = new Student<>();
		student.setSsn("12345");
		student.getSsn();
		
		Student<Integer> student2 = new Student<>();
		student2.setSsn(1234);//Auto boxing
		int s = student2.getSsn(); // unboxing
		System.out.println(s);
		
	}

	
}










