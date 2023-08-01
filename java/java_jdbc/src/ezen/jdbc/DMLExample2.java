package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * PreparedStatement 활용
 * @author 임지연
 *
 */
public class DMLExample2 {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password = "hr";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	
	/**
	 * sql 함수화..? + 트랜잭션 추가..(주석처리함)
	 * @param departmentName
	 * @param managerId
	 * @param locationId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int createDepartment(String departmentName, int managerId, int locationId) throws ClassNotFoundException, SQLException {
		int count =0;
		
		// StringBuilder를 쓰면 더 깔끔하다.
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO departments(department_id, department_name, manager_id, location_id)")
		.append("VALUES(departments_seq.NEXTVAL, ?,?,?)");
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// try finally 구문 : db에서 많이씀
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, password);
			// 트랜잭션
			//con.setAutoCommit(false);
			pstmt =con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName); // setString = VARCHER2 물음표순서, 바꿀 값
			pstmt.setInt(2, managerId); // setInt = NUMBER
			pstmt.setInt(3, locationId);
			
			count =pstmt.executeUpdate(); // 이미 위에서 날렸으니까 인자가 없다!
			//con.commit(); // 오류 없을 시 commit!
			
			// 오류가 있다면 catch로 잡기
		} catch(SQLException e) {
			//con.rollback();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	
	
	/**
	 * 부서이름 받아서 삭제
	 * @param departmentName
	 * @param managerId
	 * @param locationId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int removeDepartment(String departmentName) throws ClassNotFoundException, SQLException {
		int count =0;
		StringBuilder sb = new StringBuilder();
		// 앞에 스페이스 한칸 띄워줘야함.
		sb.append(" DELETE FROM departments")
		.append(" WHERE department_name LIKE '%' ||?|| '%'");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// try finally 구문 : db에서 많이씀
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt =con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName); // setString = VARCHER2 물음표순서, 바꿀 값
			count =pstmt.executeUpdate(); // 이미 위에서 날렸으니까 인자가 없다!
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	/**
	 * 사원이 등록됐을 때, 모든 직원들 급여가 +500
	 * @param departmentName
	 * @param managerId
	 * @param locationId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		int count =0;
		
		// StringBuilder를 쓰면 더 깔끔하다.
		StringBuilder sb = new StringBuilder();
		// 사원등록
		sb.append("INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date,  job_id, salary, department_id)")
		.append("values(employees_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?)");
		
		// 같은 부서 모든 사원 급여 +500
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("UPDATE employees")
		.append(" SET salary = salary +500")
		.append(" WHERE department_id = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// try finally 구문 : db에서 많이씀
		try {
			Class.forName(driver);

			
			con = DriverManager.getConnection(url, userid, password);
			// 트랜잭션
			con.setAutoCommit(false);
			
			// 사원등록
			pstmt =con.prepareStatement(sb.toString());
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhoneNumber());
			pstmt.setString(5, employee.getJobId());
			pstmt.setDouble(6, employee.getSalary());
			pstmt.setInt(7, employee.getDepartmentId());

			count =pstmt.executeUpdate(); // 이미 위에서 날렸으니까 인자가 없다!
			
			// 같은 부서의 모든 사원 급여 +500
			pstmt = con.prepareStatement(sb2.toString());
			pstmt.setInt(1, employee.getDepartmentId());
			
			count =pstmt.executeUpdate();
			
			
			// 오류 없을 시 commit!
			con.commit();
			
			// 오류가 있다면 catch로 잡기
		} catch(SQLException e) {
			con.rollback();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
//		int count = createDepartment("기획실", 101, 1300);
//		System.out.println(count+ "개의 부서가 등록되었습니다...");
		
//		int count = removeDepartment("획");
		// SQL 와일드카드(%) 사용법 
		// 방법 1 : 호출하는 쪽에 %이젠%.. (%붙이기) - "%이젠%"
		// 방법 2 : ?에 결합연산자 (||) 사용 - '%' ||?|| '%'
//		System.out.println(count+ "개의 부서가 삭제되었습니다...");
		
		Employee emp = new Employee();
		emp.setFirstName("길동");
		emp.setLastName("홍");
		emp.setEmail("hong@gmail.com");
		emp.setPhoneNumber("000.0000.0000");
		emp.setJobId("IT_PROG");
		emp.setSalary(10000);
		emp.setDepartmentId(10);
		
		createEmployee(emp);
		System.out.println("신입사원 등록 완료!");
		
	}
}

