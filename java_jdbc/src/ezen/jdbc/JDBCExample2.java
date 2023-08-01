package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * PreparedStatement 활용
 * @author 김기정
 */
public class JDBCExample2 {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password = "hr";
	
	
	public static int createDepartment(String departmentName, int managerId, int locationid) throws ClassNotFoundException, SQLException {
		int count = 0;
//		String sql = "INSERT INTO departments (department_id, department_name, manager_id, location_id)" +
//	                 "VALUES( departments_seq.NEXTVAL,  ?, ?, ?)";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO departments (department_id, department_name, manager_id, location_id)")
          .append("VALUES( departments_seq.NEXTVAL, ?, ?, ?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, managerId);
			pstmt.setInt(3, locationid);
			count = pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
			
		}
		return count;
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		/*
		String sql = "INSERT INTO departments (department_id, department_name, manager_id, location_id)" +
		             "VALUES( departments_seq.NEXTVAL,  ?, ?, ?)";
		Class.forName(driver);
		
		Connection con = null;
		PreparedStatement pstmt = null;
			
		con = DriverManager.getConnection(url, userid, password);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "이젠잘나가");
		pstmt.setInt(2, 107);
		pstmt.setInt(3, 1100);
		
		int count = pstmt.executeUpdate();// DML 처리 메소드
		System.out.println(count + "행이 추가되었습니다..");
		
		pstmt.close();
		con.close();
		*/
		
		int count = createDepartment("기획실", 101, 1300);
		System.out.println(count + "부서가 등록되었습니다..");
		
	}
}






