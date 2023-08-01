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
public class DMLExample {
	
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
			//con.setAutoCommit(false);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, managerId);
			pstmt.setInt(3, locationid);
			count = pstmt.executeUpdate();
			//con.commit();
		}catch (SQLException e) {
			//con.rollback();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
			
		}
		return count;
	}
	
	public static int removeDepartment(String departmentName) throws ClassNotFoundException, SQLException {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM departments")
          .append(" WHERE department_name LIKE '%' || ? || '%'");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName);
			count = pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
			
		}
		return count;
	}
	
	
	public static int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date,  job_id, salary, department_id)")
          .append(" VALUES(employees_seq.NEXTVAL, ?, ?, ?, ?, sysdate,  ?, ?, ?)");
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(" UPDATE  employees")
		   .append(" SET salary = salary + 500")
		   .append(" WHERE department_id = ?");
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			con.setAutoCommit(false);
			// 사원 등록
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhoneNumber());
			pstmt.setString(5, employee.getJobId());
			pstmt.setDouble(6, employee.getSalary());
			pstmt.setInt(7, employee.getDepartmentId());
			count = pstmt.executeUpdate();
			
			// 같은 부서의 모든 사원 급여 + 500;
			pstmt = con.prepareStatement(sb2.toString());
			pstmt.setInt(1, employee.getDepartmentId());
			count = pstmt.executeUpdate();
			con.commit();			
		}catch (SQLException e) {
			con.rollback();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
			
		}
		return count;
	}
	
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
//		int count = createDepartment("기획실", 101, 1300);
//		System.out.println(count + "부서가 등록되었습니다..");
		
//		int count = removeDepartment("기");
//		System.out.println(count + "부서가 삭제되었습니다..");
		
		Employee emp = new Employee();
		emp.setFirstName("길동");
		emp.setLastName("홍");
		emp.setEmail("hong@gmail.com");
		emp.setPhoneNumber("000.0000.0000");
		emp.setJobId("IT_PROG");
		emp.setSalary(10000);
		emp.setDepartmentId(100);
		
		createEmployee(emp);
		System.out.println("신입사원 등록 완료!!!");
		
	}
}






