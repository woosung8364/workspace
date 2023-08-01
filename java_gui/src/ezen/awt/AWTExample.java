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
//		Frame 클래스 임포트 필수 , 생성자가 String
		Frame frame = new Frame("프레임 타이틀 입니다");
//		자바는 px 단위밖에없다. setSize 메소드에 가로 , 세로 픽셀값을 입력;
		frame.setSize(800, 600);
//		실행 : boolean 타입
		frame.setVisible(true);
//		Frame이 디폴트 레이아웃 매니저 (BorderLayout) 변경
//		frame.setLayout(new FlowLayout());
		
//		패널의 디폴트 레이아웃 매니저 FlowLayout
//		Panel panel = new Panel();
//		패널과 플로우래이아웃 (정렬) 클래스를 통하여 출력화면 정리하기
//		FlowLayout.LEFT 상수를 통하여 북쪽에 중앙정렬된 폰트를 
//		왼쪽정렬로 이동하였음
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel.add(new Label("이름 :  "));
//      검색입력창 () 숫자를 입력하면 가로 길이가 더 늘어남
		panel.add(new TextField(20));
		
//		비주얼 컴포넌트 생성 및 컨테이너에 부착(배치)
		Button button = new Button("ABC");
//		클래스 자동 형변환 이용하여 컴포넌트에 부착
		frame.add(button, BorderLayout.CENTER);
		//북쪽
		frame.add(panel, BorderLayout.NORTH);
		//남쪽
		frame.add(new Label("이름: "), BorderLayout.SOUTH);
		//서쪽
		frame.add(new Label("이름: "), BorderLayout.WEST);
		//동쪽
		frame.add(new Label("이름: "), BorderLayout.EAST);
	
	}

}
