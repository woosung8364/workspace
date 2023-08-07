package gradle_basic;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
public class GradleTest {
	
//	@BeforeEach - @test 어노테이션이 실행될때마다 실행됨
//	@BeforeAll  - 맨 처음 딱 한번만 실행됨 , 대신 메소드에 static 을 붙여야함
	
	@BeforeAll
	static void initAll( ) {
		System.out.println("딱 한번 초기화 메소드");
	}
	
	@Test
	@Order(3) 
	@DisplayName("사용자 로그인 체크 기능")
	public void myTest() {
		System.out.println("JUnit Test 111111");
	}
	
	@Test
	@Order(2) 
//	@Disabled : 기능이 발동하지 않음 
	public void myTest2() {
		System.out.println("JUnit Test 222222");
	}
	
	@Test
	@Order(1)  //메소드 실행순서를 직접 지정함 : 첫번째로 실행되라~~
	public void myTest3() {
		System.out.println("JUnit Test 3333333");
	}
	
//	@AfterEach : @test 가 실행된 이후에 실행됨 , @test가 실행될때마다 같이 실행된다
//	@AfterAll : 마지막에 딱 한번만 실행됨 , 메소드에 static 을 붙여야함
	
	@AfterEach
	void destroy() {
		System.out.println("자원 해제 코드 ....");
	}
	
	@AfterAll
	static void destoryAll() {
		System.out.println("마지막 한번만 실행 되는 코드");
	}
}


