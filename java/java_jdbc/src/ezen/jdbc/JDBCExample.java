package ezen.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC API를 이용한 RDBMS (ORACLE) 연동
 * @author i7C- 송우성
 *
 */
public class JDBCExample {

	public static void main(String[] args) {
//		Socket socket = new Socket("localhost", 1521);
//		System.out.println("오라클 서버와 연결되었습니다");
//		//오라클 서버가 사용하는 응용프로토콜에 따라 프로그래밍???
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String passwd = "hr";
		
		
		String sql = "INSERT INTO departments(department_id, department_name, manager_id ,location_id)"
		 + "VALUES(7778,'이젠잘나가',100, 1000)";
				
		
	
		//JDBC API를 이용한 RDB 연동
//		생성자를 이용한 정적 객체 생성
//		OracleDriver driver = new OracleDriver();
//		리플렉션 API 를 이용한 객체 동적 생성
		
		try {
//			class cls 만 해두면 drvier가 DriverManager 에 자동으로 등록함
		Class cls =Class.forName(driver);
		
		} catch (Exception e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
		}
		
		System.out.println("오라클 드라이버 생성됨...");
		
		//statement : stream 역할 주고받고
		//데이터베이스와의 연결을 설정하고 sql 문을 실행하기 위해 사용
		//statement 클래스 생성 커밋 , 롤백등의 기능
		Connection con = null;
		
		//java에서 sql 문을 실행하기 위한 클래스 
		//statement 클래스는 connection 으로 부터 생성
		Statement stmt = null;
		
		try {
			con=DriverManager.getConnection(url,userid,passwd); //데이터 베이스 연결
			System.out.println(con);
			System.out.println("오라클 서버 연결됨...");
			stmt=con.createStatement(); //연결된 데이터 베이스에서 statement 객체 생성 : sql문을 실행하기 위해 사용
			System.out.println(stmt);
			//생성된 statement 객채를 통해 insert 문을 실행
			// executeUpdate() : 수정된 행의 수를 반환
			int count= stmt.executeUpdate(sql);  
			System.out.println(count+ "행이 추가되었습니다...");
		} catch (SQLException e) {
			System.out.println("오라클 서버 연결 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				
			}
			
			
		}

	
	}

}
