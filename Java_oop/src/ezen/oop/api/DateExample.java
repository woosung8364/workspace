package ezen.oop.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {

		Date now = new Date();
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("yyy년 MM월 dd일 hh시 mm분 ss초 aaa");
		String fomattedDate = simpleDateFormat.format(now);
		System.out.println(fomattedDate);

		System.out.println(now);
		System.out.println(now.toLocaleString());
		System.out.println(now.getHours());

		
		
		
//		특정 날짜 설정
		Date hireDate = new Date(1994, 8, 20);
		System.out.println(hireDate.toLocaleString());
	
	}

}
