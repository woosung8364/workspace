package ezen.oop.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QueueExample {

	public static void main(String[] args) {
//		List<String> list = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer("AAAAAA");
		queue.offer("BBBBBB");
		queue.offer("CCCCCC");
		
		while(!queue.isEmpty()) {
			String str = queue.poll();
//			String str = stack.peek();
			System.out.println(str);
		}
		
		System.out.println(queue.size());
		

	}

}









