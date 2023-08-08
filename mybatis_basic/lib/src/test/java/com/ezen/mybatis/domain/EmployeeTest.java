package com.ezen.mybatis.domain;



import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.employee.dto.Employee;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EmployeeTest {

	private static final String namespace = "com.ezen.mybatis.domain.employee.mapper.EmployeeMapper";
	private SqlSession sqlSession = null;
	
	@BeforeEach
	void init () {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			// 리소스로부터 리더(Reader)를 가져옵니다.
			// 이 리더는 설정 파일을 읽는 데 사용됩니다.
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		openSession : default 값이 false; 현재 true 임으로 auto comiit 활성화중
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	@Test
	void selectAll() {
		List<Employee> employeeList = sqlSession.selectList(namespace + ".findAll");
		log.debug("=== 사원 전체목록 ===");
		// 조회된 직원 데이터를 반복문을 통해 출력합니다.
		for (Employee employee : employeeList) {
			log.debug("사원정보 : {}" , employee);
		}
		
		assertThat(employeeList).isNotNull().isNotEmpty();
	}
	
	@Test
	void selectByIdTest() {
//		given
		int employeeId = 150;
//		when
//		employeeMapper.xml 에서 findById select 를 통해 검색한 값을 employee 변수에 대입
		Employee employee=sqlSession.selectOne(namespace + ".findById", employeeId);
//		test : employee 객체가 null 이 아닐시 통과
		assertThat(employee).isNotNull();
//		then
	}
	
}
