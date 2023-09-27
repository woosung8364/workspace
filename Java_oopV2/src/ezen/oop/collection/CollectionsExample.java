package ezen.oop.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ezen.oop.Student;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Student<Integer>> list = new ArrayList<>();
		list.add(new Student<Integer>("배종현", 15));
		list.add(new Student<Integer>("김기정", 20));
		list.add(new Student<Integer>("홍길동", 10));
		
		Collections.sort(list, new StudentSsnComparator()); // 학번정렬
		Collections.sort(list, new StudentNameComparator()); // 이름정렬
		for (Student<Integer> student : list) {
			System.out.println(student);
		}
		
		
	}

}
