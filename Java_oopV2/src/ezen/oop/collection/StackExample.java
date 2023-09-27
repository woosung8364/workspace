package ezen.oop.collection;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		stack.push("AAAAA");
		stack.push("BBBBB");
		stack.push("CCCCC");
		stack.push("DDDDD");
		stack.push("EEEEE");
		stack.push("FFFFF");
		
		while (!stack.isEmpty()) {
			String str = stack.pop();
//			String str = stack.pop();			
			System.out.println(str);
		}
	
		System.out.println(stack.size());
	
	}
}
