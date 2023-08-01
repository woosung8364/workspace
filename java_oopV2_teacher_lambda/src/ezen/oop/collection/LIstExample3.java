package ezen.oop.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LIstExample3 {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		long start = System.currentTimeMillis();		
		for (int i =0; i < 10000000 ; i++) {
			list.add("아무개" + i);
		}
		
//		삭제 테스트
		for (int i = 0; i < 1000; i++) {
			list.remove((int)Math.random()*100000);			
		}
				
		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start) + "ms");
		
	}
}















