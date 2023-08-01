package ezen.chat.client;

public class EzenTalk {

	
	/**
	 * 과제목표
	 * hashMap 배열에서 호출해서 리스트를 받아와 채팅회원목록과 채팅유형 (일반채팅 ,귓속말) 만들기
	 * 귓속말 기능 구현하기 - enum 클래스 활용하여
	 * @param args
	 */
	public static void main(String[] args) {
		ChatFrame chatFrame = new ChatFrame("::: 재밌는 대화 나누세요.. :::");
		chatFrame.setSize(400, 500);
		chatFrame.init();
		chatFrame.addEventListener();
		chatFrame.setVisible(true);
		
		
	}

}
