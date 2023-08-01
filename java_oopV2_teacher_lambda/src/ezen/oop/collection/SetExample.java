package ezen.oop.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 순서가 없고, 중복을 허용 X
 * @author 김기정
 */
public class SetExample {

	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		set.add("희영");
		set.add("소영");
		set.add("영호");
		set.add("승욱");
		System.out.println(set.size());
		
		set.add("기정");
		set.add("승욱");
		System.out.println(set.size());
		
		/*
		for (String name : set) {
			System.out.println(name);
		}
		*/
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		
		boolean exist = set.contains("영호");
		System.out.println(exist);
		
		boolean deleted = set.remove("기정");
		System.out.println(deleted);
		
		System.out.println(set.isEmpty());
		
		set.clear();
		System.out.println(set.size());
	}
}















