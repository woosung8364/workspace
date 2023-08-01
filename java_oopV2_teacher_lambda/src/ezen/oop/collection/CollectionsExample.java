package ezen.oop.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ezen.oop.Student;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Student<Integer>> list = new ArrayList<>();
		list.add(new Student<Integer>("김기정", 15));
		list.add(new Student<Integer>("이기정", 20));
		list.add(new Student<Integer>("최기정", 5));
		
//		학번 정렬 출력
//		Collections.sort(list, new StudentSssComparator());
//		이름으로 정렬
		Collections.sort(list, new StudentNameComparator());
		
		for (Student<Integer> student : list) {
			System.out.println(student);
		}
		

	}
}









