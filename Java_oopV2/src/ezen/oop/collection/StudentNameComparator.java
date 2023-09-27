package ezen.oop.collection;

import java.util.Comparator;

import ezen.oop.Student;

public class StudentNameComparator implements Comparator<Student<Integer>> {

	@Override
	public int compare(Student<Integer> student1, Student<Integer> student2) {
		return student1.getName().compareTo(student2.getName());
	}


}
