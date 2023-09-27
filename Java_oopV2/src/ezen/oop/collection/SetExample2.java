package ezen.oop.collection;

import java.util.HashSet;
import java.util.Set;

import ezen.oop.Student;

/**
 * 순서가 없고, 중복을 허용하지 않는다.
 * @author 배종현
 *
 */

public class SetExample2 {
		

	public static void main(String[] args) {

		Set<Student<Integer>> set = new HashSet<Student<Integer>>();
		
//		Set<String> set = new TreeSet<String>();
		
		Set<String> set2 = new HashSet<String>();
		set2.add("김기정");
		set2.add("이기정");
		set2.add("박기정");
		set2.add("김기정");
		System.out.println(set2.size());
		
		set.add(new Student<Integer>("희영",1));
		set.add(new Student<Integer>("소영",2));
		set.add(new Student<Integer>("기정",3));		
		System.out.println(set.size());
		set.add(new Student<Integer>("기정",3));
		System.out.println(set.size());
		
		
		
	}

}
