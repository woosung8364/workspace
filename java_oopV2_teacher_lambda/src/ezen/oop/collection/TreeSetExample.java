package ezen.oop.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import ezen.oop.Student;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(60);
		set.add(50);
		set.add(10);
		set.add(20);
		for (Integer num : set) {
			System.out.println(num);
		}
		
//		Set<Student<Integer>> set2 = new TreeSet<Student<Integer>>();
		
		// 사용자 선택
		int sort = 1;
		Comparator<Student<Integer>> comparator = null;
		if(sort == 0) {// 학번으로 정렬
			comparator = new StudentSssComparator();
		}else if(sort == 1) { // 이름으로 정렬
			comparator = new StudentNameComparator();
		}
		
		Set<Student<Integer>> set2 = new TreeSet<Student<Integer>>(comparator);
		set2.add(new Student<Integer>("김기정", 15));
		set2.add(new Student<Integer>("이기정", 20));
		set2.add(new Student<Integer>("최기정", 5));
		for (Student<Integer> student : set2) {
			System.out.println(student);
		}

	}

}










