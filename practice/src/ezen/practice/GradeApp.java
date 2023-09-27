package ezen.practice;

import java.util.Arrays;

/**
 * Grade 클래스 APP
 * @author 배종현
 *
 */


public class GradeApp {


	public static void main(String[] args) {

		Grade[] grade = {
				new Grade("홍길동", 60, 75),
				new Grade("강호동", 70, 80),
				new Grade("유재석", 80, 55),
				new Grade("박명수", 90, 100)				
		};
		
	    Grade.checkRank(grade);
	    Arrays.sort(grade);
	    Grade.list(grade);
	}
}

