package ezen.oop.api;

import java.util.Iterator;

public class WrapperExample {

	public static void main(String[] args) {
//		Integer
		int x = 50;
//		Integer integer = new Integer(x);
		Integer integer = Integer.valueOf(x);
		byte b = integer.byteValue();

		String str = "50";
		int value = Integer.parseInt(str);
		System.out.println(value + 100);

		String str2 = "1010";
		System.out.println(Integer.parseInt(str2, 2));

		int y = 5678;
		System.out.println(Integer.toString(y, 2));
		System.out.println(Integer.toString(y, 16));

		System.out.println(Integer.toBinaryString(5000));
		System.out.println(Integer.toOctalString(5000));
		System.out.println(Integer.toHexString(5000));

//		Character
		char[] data = { 'A', 'a', '4', ' ', '#' };
		for (int i = 0; i < data.length; i++) {
			if (Character.isUpperCase(data[i])) {
				System.out.println(data[i] + "은 대문자이다.");
			} else if (Character.isLowerCase(data[i])) {
				System.out.println(data[i] + "은 소문자이다.");
			} else if (Character.isDigit(data[i])) {
				System.out.println(data[i] + "은 숫자이다.");
			} else if (Character.isSpaceChar(data[i])) {
				System.out.println(data[i] + "은 공백문자이다.");
			}
		}
		
//		Double
		double d = 15.5;
//		System.out.println(d/0);
		int z =0;
//		input(d/z);
		

	}

	public static void input(double d) {
		if(Double.isInfinite(d)) {
			System.out.println("잘못된 입력값이다.");
			return;
		}
		System.out.println(d + 10);
	}
	
	public static boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
		
		
	}

	public static boolean isId(String id) {
		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			if(!Character.isDigit(c) && !Character.isAlphabetic(c)) {
				return false;
			}
		}
		return true;
	}
	
	
	
}

