package ezen.oop.regexp;

import java.util.regex.Pattern;

public class RegExpExample {

	public static void main(String[] args) {
		String inputMessage = "Javad";
		String regexp = "Java.";
		
		boolean mt = Pattern.matches(regexp, inputMessage);
		System.out.println(mt);
		
		boolean matched = inputMessage.matches(regexp);
		System.out.println(matched);
		

	}

}
