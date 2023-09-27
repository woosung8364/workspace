package ezen.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventExampleFrame extends Frame {

	Button button1, button2, button3;
	TextField tf;
	Choice choice;
	Checkbox javaCB, cCB, pythonCB;

	public EventExampleFrame() {
		this("No-Title");
	}

//	생성자 선언 해주면서 생성
	public EventExampleFrame(String title) {
		super(title);
		button1 = new Button("등록");
		button2 = new Button("목록");
		button3 = new Button("삭제");
		tf = new TextField(20);
		choice = new Choice();
		choice.add("LG");
		choice.add("두산");
		choice.add("삼성");
		choice.add("롯데");
		javaCB = new Checkbox("자바", true);
		cCB = new Checkbox("C");
		pythonCB = new Checkbox("자바");

	}

//	컴포넌트 배치
	public void init() {
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(button3);
		add(tf);
		add(choice);
		add(javaCB);
		add(cCB);
		add(pythonCB);
	}

//	기능 메소드들
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	public void showList() {
		System.out.println("showList");
	}

	public void removeList() {
		System.out.println("removeList");
	}
	
	public void exit() {
		setVisible(false);
//		OS로부터 얻어온 그래픽리소스 반납
		dispose();
		System.exit(0);
	}
	
	public void selectTeam(String team) {
		System.out.println(team + "select");
	}
	
	public void showDialog() {
		Dialog dialog = new Dialog(this, true);
		dialog.setSize(200, 200);
		dialog.setVisible(true);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
		}
		
		}); 
			
	}
	
	

//		멤버 내부클래스	
//	class MouseEventHandler extends MouseAdapter{
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			showMessage("mouseClicked");  
////		exit(); 외부클래스의 메소드를 호출해서 사용.
//		}
//		@Override
//		public void mouseEntered(MouseEvent e) {}
//		@Override
//		public void mouseExited(MouseEvent e) {}
//	
//	}

//		이벤트 처리
	public void eventHandling() {
//		이름 있는 지역 내부클래스 정의 (중복 재사용이 많을 때는 이름있는 지역 내부클래스를 만드는게 좋다.)
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == button2) {
					showList();
				}else if(eventSource == button3) {
					removeList();
				}
			}
			
		}

//		내부클래스
		class ItemHandler implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					Object eventSource = e.getSource();
					if(eventSource == javaCB) {
						EventExampleFrame.this.setBackground(Color.YELLOW);
					}else if(eventSource == cCB) {
						EventExampleFrame.this.setBackground(Color.BLUE);
					}else {
						EventExampleFrame.this.setBackground(Color.GREEN);
					}
			}
			
		}
	}
//			이름 있는 지역 내부클래스	
//			class MouseEventHandler extends MouseAdapter{
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					showMessage("mouseClicked");  
////					exit(); 외부클래스의 메소드를 호출해서 사용.
//				}
//				@Override
//				public void mouseEntered(MouseEvent e) {}
//				@Override
//				public void mouseExited(MouseEvent e) {}
//			
//			}
//			
//			MouseListener listener = new MouseEventHandler();
//			button1.addMouseListener(listener);

//			익명 객체를 이용한 이벤트 처리
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int buttonType = e.getButton();
				if (buttonType == MouseEvent.BUTTON1) {
					System.out.println("Mouse Clicked...");
				}
			}
		});

//		목록버튼 액션이벤트 처리
		
		button2.addActionListener(new ActionHandler());
		
//		삭제버튼 액션이벤트 처리
		
		button3.addActionListener(new ActionHandler());
		
//		아이템 이벤트 처리
		
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedTeam = null;
				if(e.getStateChange() == ItemEvent.SELECTED) {
					selectedTeam = (String)e.getItem();
				}
				selectTeam(selectedTeam);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
			
//			@Override
//			public void windowOpened(WindowEvent e) {
//				showDialog();
//			}
		});
		
		javaCB.addItemListener(new ItemHandler());
		cCB.addItemListener(new ItemHandler());
		pythonCB.addItemListener(new ItemHandler());

	}

	public static void main(String[] args) {
		EventExampleFrame frame = new EventExampleFrame("이벤트 처리 예제");
		frame.init();
		frame.eventHandling();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
