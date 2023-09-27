package ezen.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class AWTExample {

	public static void main(String[] args) {

//		Container 생성 및 화면 보이기
		Frame frame = new Frame("프레임 타이틀입니다.");
		frame.setSize(800, 600); // px 단위
		frame.setVisible(true);
//		frame의 디폴트레이아웃 매니저(BorderLayout) 변경
//		frame.setLayout(new FlowLayout());
		
//		Panel panel = new Panel(new FlowLayout()); // 디폴트 값
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		
//		패널의 디폴트 레이아웃매니저 FlowLayout
		panel.add(new Label("이름 : "));
		panel.add(new TextField(20));
		
		
//		비주얼 컴포넌트 생성 및 컨테이너에 배치
		Button button = new Button("ADD");
//		클래스 자동 형변환 이용하여 컴포넌트 배치
		frame.add(button, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(new Label("이름 : "), BorderLayout.WEST);
		frame.add(new Label("이름 : "), BorderLayout.EAST);
		frame.add(new Label("이름 : "), BorderLayout.SOUTH);
		
		
		
		
		
		
	}

}
