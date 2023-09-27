package ezen.oop.regexp;

import java.util.regex.Pattern;

public class RegExpExample {

	public static void main(String[] args) {
		String inputmessage = "Java1";
		String regexp = "Java.";
		
		boolean mt = Pattern.matches(regexp, inputmessage);
		System.out.println(mt);
		
		boolean matched = inputmessage.matches(regexp);
		System.out.println(matched);
		
	
	
	}

}


