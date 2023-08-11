package com.ezen.spring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.spring.core.Unit;



// 스프링 컨테이너 생성 및 테스트 클래스 생성 및 등록
@SpringBootTest

public class UnitTest {
	
	@Autowired
	Unit unit;
	
	@Test
	public void offenceTest() {
		unit.offense();
	}
	
}
