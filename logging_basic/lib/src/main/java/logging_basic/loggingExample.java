package logging_basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggingExample {
	
	
	private static final Logger log = LoggerFactory.getLogger(loggingExample.class);
	
	public static void main(String[] args) {
		int result = 10;
		
//		logging_basic / lib / log 폴더안에 log 파일이 생성됨
//		log.trace("trace 기록");
		log.debug("x : {} " , result);
//		logback.xml 에서 root level 이 info 로 설정되어있기때문에 info 보다 아래단계의 log 명령어는 무시됨
		log.info("x : {} " , result);
		log.warn("x : {} " , result);
		log.error("x : {} " , result);
		
	}
}
