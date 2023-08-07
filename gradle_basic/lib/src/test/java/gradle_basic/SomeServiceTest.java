package gradle_basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * SomeServiceImpl 클래스의 테스트 클래스
 */

public class SomeServiceTest {

	SomeServiceImpl someServiceImpl;

	@BeforeEach
	void createSomeService() {
		someServiceImpl = new SomeServiceImpl();
	}

//	실행순서 createSomeService -> sumTest
//	createSomeService 에서 이미 객체생성이 완료되었으므로
//	바로 someServiceImpl 의 기능을 사용할 수 있다

	@Test
	void sumTest() {
		int result = someServiceImpl.sum(15, 20);
		// 내가 예상하는 값 , 결과값
		assertEquals(35, result);

		String str = "김기정";
//		assertNull () : null 이면 true
//		asserNotNull () : null 이 아니면 true
		assertNotNull(str);
		
//		result가 35와 같고 20보다 큰지 비교
//		assertThat : 지정대상
//		isEqualTo : 35랑 비교
//		isGreaterThan : 20보다 큰지
		assertThat(result).isEqualTo(35).isGreaterThan(20);
	}

	@Test
	void getMessageTest() {
//		someServiceImpl.getMessage() : return 값 - "Hello Junit~~~"
//		null 이 아니므로 통과
		assertNotNull(someServiceImpl.getMessage());
		
//		(a, b)  a와 b가 같은지 비교하겠다~
		assertEquals("Hello Junit~~~", someServiceImpl.getMessage());
		
//		someServiceImpl.getMessage() 가 null 이 아니고 내용중 hello 가 포함됬는지 확인
		assertThat(someServiceImpl.getMessage()).isNotNull().contains("Hello");
		
//		given
		String message = "안녕하세요. 김기정입니다..";
//		when
		String result = someServiceImpl.getMessage();
//		then
//		assertThat(result)message.isPositive().isEven().isEqualTo(300);
		
	}
	
	@Test
	void xxxTest() {
//		반드시 error 가 뜨게 하는 기능 
//		아직 구현이 미완료되었을때 임시적으로 사용
//		fail("아직 구현 안된 메소드입니다");
	}

}
