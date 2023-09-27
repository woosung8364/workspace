package com.ezen.sample2;


import java.util.Date;
import com.ezen.sample.Lecture;

public class PackageExample {

	public static void main(String[] args) {
		Lecture lecture = new Lecture("풀스택");
		lecture.printName();

		Date today = new Date();
		System.out.println(today.toLocaleString());		
		
		
//		자바 표준 API의 java.lang는 기본패키지 이므로 자동 import
		String message;
	}

}
