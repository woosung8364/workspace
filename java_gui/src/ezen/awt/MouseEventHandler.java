package ezen.awt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 인터페이스 상속
 * @author 송우성
 *
 */


//인터페이스는 불필요한 메소드까지 전부 적어야하는것에 비해 
//마우스 어뎁터를 상속하면 필요한 메소드만 골라서 사용할 수 있다.
public class MouseEventHandler extends MouseAdapter {
	
	EventExampleFrame frame;
	
	
	//  원리 1. EventExampleFrame frame 에서 생성자호출로 ouseListener listener = new MouseEventHandler(this); 호출
	//  (this) = EventExampleFrame (자기자신 클래스)  EventExampleFrame frame 매게 변수로 대입 
	//  frame -> this.frame 값이동
	public MouseEventHandler(EventExampleFrame frame) {
		this.frame=frame;
	}

		// 마우스 클릭햇을때 이벤트 처리
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked");
		
	}

		//마우스를 눌렀을때
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	//마우스가 들어왔을때 : hover 
	
	@Override
	public void mouseEntered(MouseEvent e) {
		frame.button1.setBackground(Color.BLUE);
		
	}

	// 마우스가 빠져나왔을때 
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Exit....");
		
	}

}
