package ezen.chat.protocol;

/**
 * 채팅메시지 빌더 유틸리티
 * @author 김기정
 *
 */
public class MessageBuilder {
	
	public static final String delimeter = "★";
	// ... : 비정형인자 
	public static String build(MessageType messageType, String... tokens) {
		StringBuilder sb = new StringBuilder();
		sb.append(messageType);
		//구분자로 토큰화 하기위해 구분자를 반복문으로 붙여주는 작업
		for (String token : tokens) {
			sb.append(delimeter);
			sb.append(token);
		}
		return sb.toString();
	}
	
	
	//토큰을 분리하는 작업
	public static String[] parse(String  message) {
		String[] tokens = message.split(delimeter);
		return tokens;
	}
	
	// 테스트 main
	public static void main(String[] args) {
		String message = MessageBuilder.build(MessageType.CONNECT, "방그리");
		message = MessageBuilder.build(MessageType.CHAT_MESSAGE, "방그리", "하이루");
		message = MessageBuilder.build(MessageType.DIS_CONNECT, "방그리");
		System.out.println(message);
		
		String[] tokens = parse(message);
		for (String token : tokens) {
			System.out.println(token);
		}
	}

}
