package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

/**
 * 복합관계 클레스 
 * @author 송우성
 *
 */

public class ChatFrame extends Frame {
	
	//클래스와 변수선언
	//닉네임 표시
	Label nicknameL; 
	//닉네임 입력칸
	TextField nicknameTF , inputTF;
	//로그인버튼 , 메시지보내기 버튼
	Button loginB , sendB;
	// 채팅입력창과 닉네임리스트
	TextArea messageTA , nickNameList;
	
	
	
	Panel northP , southP;
	
	//생성자 초기화: 어플리케이션 클래스에서 타이틀을 설정하기위한 생성
	public ChatFrame() {
		this("");
	}
	
	//프레임 초기화 메소드
	
	public ChatFrame(String title) {
		super(title);
		
		// 복합연관 Class - chatFrame 이 사라지면 이 메소드도 죽음
		nicknameL = new Label("별명");
		nicknameTF = new TextField(30);
		inputTF = new TextField(20);
		
		
		loginB = new Button("로그인");
//		버튼에 색상을 입혀보자
		loginB.setBackground(new Color(0, 60, 172));
//		글자 색깔을 바꿔보자 
		loginB.setForeground(Color.WHITE);
//		폰트를 바꿔보자 setFont(new Font(서식 , 폰트 스타일 , 사이즈))
		loginB.setFont(new Font("궁서",Font.BOLD , 35));;
		
		
		sendB = new Button("보내기");
		messageTA = new TextArea(10, 30); //행 , 컬럼
		nickNameList = new TextArea(10, 10);
		//FlowLayout = () 안에 방향 지정 left center right ..
		//BorderLayout() 안에 가로 여백 , 세로 여백
		northP = new Panel(new BorderLayout(20,10));
		southP = new Panel(new BorderLayout(10,10));
	}
	
	
	
	//컴포넌트(프레임) 배치시키는 메소드
	
	public void init() {
		// Frame의 디폴트 레이아웃 매니저 : BorderLayout
		
		northP.add(nicknameL , BorderLayout.WEST);
		northP.add(nicknameTF , BorderLayout.CENTER);
		northP.add(loginB , BorderLayout.EAST);
		add(northP , BorderLayout.NORTH);
		add(messageTA , BorderLayout.CENTER);
		add(inputTF , BorderLayout.EAST);
		
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		add(nickNameList , BorderLayout.EAST);
		add(southP , BorderLayout.SOUTH);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
