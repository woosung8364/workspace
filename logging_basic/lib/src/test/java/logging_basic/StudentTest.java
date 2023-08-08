package logging_basic;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentTest {
	
	
	@Test
	void createStudent() {
		Student student = new Student(10 , "김기정");
		student.setName("홍박사님을아세요?");
		log.debug("학생 : {}" , student.toString());
	}
	
	
	
	
}
