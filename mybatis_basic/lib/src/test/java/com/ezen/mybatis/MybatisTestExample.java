package com.ezen.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ezen.mybatis.domain.employee.dto.Employee;


public class MybatisTestExample {
	
	private static final String namespace = "com.ezen.mybatis.domain.employee.mapper.EmployeeMapper";
	
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		
		Reader reader = null;
		try {
			// 리소스로부터 리더(Reader)를 가져옵니다.
			// 이 리더는 설정 파일을 읽는 데 사용됩니다.
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 리더를 사용하여 SqlSessionFactory를 생성합니다.
		// SqlSessionFactory는 데이터베이스와의 연결과 세션을 관리합니다.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "product");
		
		// 트랜잭션 Auto Commit
		//SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		// SqlSessionFactory를 사용하여 SqlSession을 열어줍니다.
		// SqlSession은 데이터베이스 작업을 실행하고 관리하는 데 사용됩니다.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// Not Auto Commit
		//SqlSession sqlSession = sqlSessionFactory.openSession(false);
		//sqlSession.commit();
		//sqlSession.rollback();
		
		
		System.out.println("==================== sqlSession 생성 완료 ====================");
		
		
//		String today = sqlSession.selectOne(namespace + ".findToDate");
//		System.out.println(today);
		
		System.out.println("==================== 전체사원 조회 ========================");
		//List<Employee> employeeList = sqlSession.selectList("com.ezen.mybatis.domain.employee.mapper.EmployeeMapper.findAll");
		
		// SqlSession을 사용하여 데이터베이스에서 모든 직원(Employee) 데이터를 조회합니다.
		// 매퍼(namespace)와 연결된 SQL 매핑 구문(namespace + ".findAll")을 실행합니다.
//		List<Employee> employeeList = sqlSession.selectList(namespace + ".findAll");
//		
//		// 조회된 직원 데이터를 반복문을 통해 출력합니다.
//		for (Employee employee : employeeList) {
//			System.out.println(employee);
//		}
		

//		
//		System.out.println("==================== 사원번호로 사원조회 ========================");
//		int id = 200;
//		Employee employee = sqlSession.selectOne(namespace + ".findById", id);
//		System.out.println(employee);
		
//		
//		System.out.println("==================== 사원 급여조회 ========================");
//		int salary = sqlSession.selectOne(namespace + ".findBySalary", id);
//		System.out.println("받는 급여 : " + salary);
//		
//		System.out.println("==================== 급여범위로 사원검색 ========================");
////		맵 배열을 생성해서 배열에 min , max 키를 가진 값 두개를 넣음
//		Map<String, Integer> params = new HashMap<>();
//		params.put("min", 10000);
//		params.put("max", 100000);
//
//		// SqlSession을 사용하여 특정 범위 내의 사원들의 정보를 조회합니다.
//		// 매퍼(namespace)와 연결된 SQL 매핑 구문(namespace + ".findBySalaryRange")을 실행합니다.
//		// params는 쿼리 실행에 필요한 파라미터를 담은 객체입니다.
//		List<Employee> list = sqlSession.selectList(namespace + ".findBySalaryRange", params);
//		for (Employee emp : list) {
//			System.out.println(emp);
//		}
//		
		
		
////		이름에 e가 포함된 사원 검색
//		System.out.println("==================== 성으로 사원검색 ========================");
//		String searchName = "e";
//		// E(e)가 포함된 모든 성
////		'%' = sql 와일드카드 : 이자리에 어떤 문자열이 와도 대체할 수 있음
////		searchName.toUpperCase() : 문자열을 대문자로 변환하는 기능 
//		searchName = "%" + searchName.toUpperCase() + "%"; 
//		List<Employee> list2 = sqlSession.selectList(namespace + ".findByLastName", searchName);
//		for (Employee emp : list2) {
//			System.out.println(emp);
//		}
//		
//		System.out.println("==================== 부서명 포함 전체사원 조회(테이블 조인) ========================");
//		List<Map<String, Object>> list3 = sqlSession.selectList(namespace + ".findByJoin");
//		for (Map<String, Object> row : list3) {
//			BigDecimal empId = (BigDecimal) row.get("id");
//			String firstName = (String) row.get("firstName");
//			String lastName = (String) row.get("lastName");
//			String departmentName = (String) row.get("departmentName");
//			System.out.println(empId + "\t" + firstName + "\t" + lastName + "\t" + departmentName);
//		}
//		
//		System.out.println("==================== ResultMap을 이용한 전체사원 조회 ========================");
//		List<Employee> list4 = sqlSession.selectList(namespace + ".findByAll2");
//		for (Employee emp : list4) {
//			System.out.println(emp);
//		}
//		
		
//		객체생성
//		System.out.println("==================== 사원 등록 ========================");
//		Employee emp = new Employee();
//		emp.setFirstName("KiJung");
//		emp.setLastName("Kim");
//		emp.setEmail("kimkijung@gmail.com");
//		emp.setPhoneNumber("010.9179.87087");
//		emp.setHireDate("2023-01-01");
//		emp.setJobId("IT_PROG");
//		emp.setSalary(50000);
//		emp.setManagerId(150);
//		emp.setDepartmentId(60);

		
//		SQL 쿼리 전송
//		sqlSession.insert(namespace + ".create", emp);
//		sqlSession.commit();
		//sqlSession.rollback();
//		System.out.println("신규사원 등록 완료");
//		
//		Employee updateEmp = new Employee();
//		updateEmp.setId(200);
//		updateEmp.setFirstName("볶이");
//		updateEmp.setLastName("홍박사");
//		updateEmp.setSalary(54321);
//		sqlSession.update(namespace + ".update2", updateEmp);
//		sqlSession.delete(resource);
//		sqlSession.commit();
//		System.out.println("사원정보 수정 완료");
		
		System.out.println("==================== 검색타입별 사원 검색(동적SQL 활용) ========================");
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("searchType", "id");
		searchParams.put("searchValue", 150);

		searchParams.put("searchType", "name");
		searchParams.put("searchValue", "E%");

		List<Employee> searchList = sqlSession.selectList(namespace + ".search", searchParams);
		for (Employee searchEmp : searchList) {
			System.out.println(searchEmp); 
		}
	
	}
	
}











