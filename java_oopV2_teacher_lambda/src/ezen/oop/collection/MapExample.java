package ezen.oop.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ezen.oop.Student;

/**
 * 키와 값의 쌍으로 데이터 저장
 * @author 김기정
 *
 */
public class MapExample {

	public static void main(String[] args) {
		
//		Map<Integer, Student<Integer>> map = new HashMap<Integer, Student<Integer>>();
		Map<Integer, Student<Integer>> map = new Hashtable<Integer, Student<Integer>>();
		
		for (int i=1; i<=10; i++) {
			Student<Integer> student = new Student<Integer>("희영"+i, i);
			map.put(student.getSsn(), student);
		}
		
		Student<Integer> addStudent = new Student<>("기정", 2);
		if(map.containsKey(addStudent.getSsn())) {
			//System.out.println("이미 사용중인 키입니다...");
			int max = 11;
			addStudent.setSsn(max);
			map.put(addStudent.getSsn(), addStudent);
			System.out.println("등록되었습니다...");
		}
		
		
		System.out.println(map.size());
		
		Student<Integer> searchStudent = map.get(5);
		System.out.println(searchStudent);
		
		searchStudent = map.remove(5);
		System.out.println(searchStudent);
		System.out.println(map.size());
		
		Collection<Student<Integer>> values = map.values();
		for (Student<Integer> student : values) {
			System.out.println(student);
		}
		
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key);
		}
		
		Set<Entry<Integer, Student<Integer>>> entries = map.entrySet();
		for (Entry<Integer, Student<Integer>> entry : entries) {
//			System.out.println(entry);
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
















