package ezen.oop.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<>();
		queue.offer("AAAAA");
		queue.offer("BBBBB");
		queue.offer("CCCCC");
		queue.offer("DDDDD");
		queue.offer("EEEEE");
		queue.offer("FFFFF");
		
		while (!queue.isEmpty()) {
			String str = queue.poll();
//			String str = queue.pop();			
			System.out.println(str);
		}
	
		System.out.println(queue.size());
	
	}
}
