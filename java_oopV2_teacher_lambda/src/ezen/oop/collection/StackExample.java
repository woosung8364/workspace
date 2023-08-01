package ezen.oop.collection;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("AAAAAA");
		stack.push("BBBBBB");
		stack.push("CCCCCC");
		
		while(!stack.isEmpty()) {
			String str = stack.pop();
//			String str = stack.peek();
			System.out.println(str);
		}
		
		System.out.println(stack.size());
		

	}

}









