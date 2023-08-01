package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * @author 김기정
 */
public class JDBCExample {

	public static void main(String[] args){
//		Socket socket = new Socket("localhost", 1521);
//		System.out.println("오라클 서버와 연결되었습니다..");
		// 오라클 서버가 사용하는 응용프로토콜에 따라 프로그래밍????????
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String password = "hr";
		
		String sql = "INSERT INTO departments (department_id, department_name, manager_id, location_id)" +
		             "VALUES( departments_seq.NEXTVAL,  '이젠잘나가', 100, 1000)";
		
		// JDBC API를 이용한 RDB 연동
		
		// 생성자를 이용한 정적 객체 생성
//		OracleDriver driver = new OracleDriver();
//		리플렉션 API를 이용한 객체 동적 생성
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다..");
		}
		
		System.out.println("오라클 드라이버 생성됨..");
		
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = DriverManager.getConnection(url, userid, password);
			System.out.println("오라클 서버 연결됨....");
			stmt = con.createStatement();
			System.out.println(stmt);
			int count = stmt.executeUpdate(sql);// DML 처리 메소드
			System.out.println(count + "행이 추가되었습니다..");
			
			
		} catch (SQLException e) {
			System.out.println("오라클 서버 연결 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null)  con.close();
			} catch (SQLException e) {}
			
		}
		

	}
}






