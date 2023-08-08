package com.ezen.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberMapperTest {
	SqlSession sqlSession;	
	
	@BeforeEach
	public void setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	public void findAllTest(){
		
		System.out.println("==================== 전체멤버 조회 ========================");
		
//		myBatis 에서 mapper proxy 라는 EmployeeMapper 인터페이스의 구현체 클래스를 만들어서 리턴
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		
//		{} : 값 , mapper 변수의 값을 로그로 출력하는 코드
		log.debug("{}", mapper);
		
		List<Employee> list = mapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		sqlSession.close();
	}
	
	@Test
	public void findByLastNameTest(){
		System.out.println("==================== 사원이름으로 사원조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> findEmployees = mapper.findByLastName("E");
//		자바 스크립트식 forEach 사용하기
		findEmployees.forEach( (employee)  ->{
			log.debug("검색된 사원 : {}",employee);
		});
	
		sqlSession.close();
	}
	
	
	@Test
	public void createTest(){
		System.out.println("==================== 사원등록 ========================");
		
//		객체에 속성들 설정
		Employee emp = new Employee();
		emp.setFirstName("박사님을아세요?");
		emp.setLastName("홍");
		emp.setEmail("hong@gmail.com");
		emp.setPhoneNumber("0070");
		emp.setHireDate("2023-01-11");
		emp.setJobId("IT_PROG");
		emp.setSalary(5000011);
		emp.setManagerId(200);
		emp.setDepartmentId(60);
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		설정한 객체를 SQL 쿼리를 만들어둔 CREATE 쿼리를 통해 데이타베이스로 요청하기
		mapper.create(emp);
		log.debug("사원등록 완료 : {}", emp);
	
		sqlSession.close();
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







