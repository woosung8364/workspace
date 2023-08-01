package ezen.ams.exception;

/**
 * 사용자 정의 예외 클래스
 * 
 * @author 송우성
 *
 */
public class NotBalanceException extends Exception {
//	String message;  - 상속시 기본적으로 부모에 String 이 있기때문에 쓰지 않아도 자동으로 변수에 저장된다
	private int errorCode;

//	생성자 호출
	public NotBalanceException() {
		super("예기치 않은 오류가 발생하였습니다. 관리자에게 문의하세요..");
	}

	public NotBalanceException(String message) {
		super(message);
		
	}
	public NotBalanceException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

//	getter setter
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	
	@Override
	public String toString() {

		return getMessage() + " [에러코드 : "  +errorCode+"]";
	}
	
	
}

