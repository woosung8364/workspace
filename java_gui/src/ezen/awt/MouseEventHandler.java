package ezen.awt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter{

	EventExampleFrame frame;
	
	public MouseEventHandler (EventExampleFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	
}
