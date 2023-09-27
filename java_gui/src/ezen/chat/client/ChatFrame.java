package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ChatFrame extends Frame {
	
	Label nicknameL;
	TextField nicknameTF, inputTF;
	Button loginB, sendB;
	TextArea messageTA, listTA;
	Panel northP, southP;
	
	
	public ChatFrame() {
		this("No-Title");
	}
//		생성자 선언 해주면서 생성
	public ChatFrame(String title) {
		super(title);
//		복함연관		
		nicknameL = new Label("별 명");
		nicknameTF = new TextField();
		inputTF = new TextField();
		loginB = new Button("로그인");
		loginB.setBackground(new Color(128,128,255));
		loginB.setForeground(Color.white);
//		loginB.setFont(new Font("궁서", Font.BOLD, 13));
		
		sendB = new Button("보내기");
		messageTA = new TextArea();
		listTA = new TextArea(10, 10);
		northP = new Panel(new BorderLayout(5, 5));
		southP = new Panel(new BorderLayout(5, 5));		
	}
//	컴포넌트 배치
	public void init() {
//		Frame에 디폴트레이아웃매니저 - BorderLayout
		northP.add(nicknameL, BorderLayout.WEST);
		northP.add(nicknameTF, BorderLayout.CENTER);
		northP.add(loginB, BorderLayout.EAST);
		
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(listTA, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
	}
	
}
