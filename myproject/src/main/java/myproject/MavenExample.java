package myproject;

public class MavenExample {

	public static void main(String[] args) throws ClassNotFoundException {
		
//		오라클 드라이버 이름 확인해보기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("오라클 드라이버 로딩 완료...");
	}

}
