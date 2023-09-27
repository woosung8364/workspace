package ezen.practice;


public class Grade implements Comparable<Grade> {

	private String name;
	private int korean;
	private int english;
	private int rank;
	
	
	public Grade () {}	
	public Grade(String name, int korean, int english, int rank) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.rank = rank;
	}
	public Grade(String name, int korean, int english) {
		this.name = name;
		this.korean = korean;
		this.english = english;
	}
	
	
	public String getName() {
		return name;
	}
	public int getKorean() {
		return korean;
	}
	public int getEnglish() {
		return english;
	}		
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * 총점 계산 메소드
	 * @return 총점
	 */
	public int total() {
		return getKorean()+getEnglish();
	}
	
	
	/**
	 * 순위 설정 메소드
	 * @param grade
	 */
	
	public static void checkRank(Grade[] grade) {
	    for (int i = 0; i < grade.length; i++) {
	        int rank = 1;
	        for (int j = 0; j < grade.length; j++) {
	            if (grade[j].total() > grade[i].total()) {
	                rank++;
	            }
	        }
	        grade[i].setRank(rank);
	    }
	}
	
	/**
	 * 학생 정보
	 * @param grade
	 */
	public static void list(Grade[] grade) {
	    System.out.println("-----------------------");
	    System.out.println("순위\t이름\t총점");
	    System.out.println("-----------------------");
		for (Grade grades : grade) {
	        System.out.println(grades.getRank()+"등" + "\t" + grades.getName() + "\t" + grades.total() + "점");
	    }
	}
	
	
	
	@Override
	public String toString() {
		return name + "\t" + korean + "\t" + english;
	}
	
//	이름순으로 정렬 메소드 오버라이딩
	@Override
	 public int compareTo(Grade other) {
        return this.name.compareTo(other.name);
    }


	
}
