package ezen.chat.client;

public class EzenTalk {

	public static void main(String[] args) {
		
		//ChatFrame 클래스 초기화 (연결)
		ChatFrame chatFrame = new ChatFrame("고장난 컴퓨터 에어컨 삽니다");
		//chatFrame 클래스 사이즈 지정 (px , px)
		chatFrame.setSize(400, 500);
		
		//만들어둔 프레임 메소드 호출 
		chatFrame.init();
		
		
		//chatFrame 클래스 실행 - boolean
		chatFrame.setVisible(true);
		
		
	}

}
