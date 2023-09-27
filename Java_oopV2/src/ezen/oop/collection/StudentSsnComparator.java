package ezen.oop.collection;

import java.util.Comparator;

import ezen.oop.Student;

public class StudentSsnComparator implements Comparator<Student<Integer>> {

	@Override
	public int compare(Student<Integer> student1, Student<Integer> student2) {
		return student1.getSsn().intValue() - student2.getSsn().intValue();
	}


}
