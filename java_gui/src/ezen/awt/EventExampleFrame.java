package ezen.awt;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 복합관계 클레스
 * 
 * @author 송우성
 *
 */

public class EventExampleFrame extends Frame {

	Button button1, button2;
	TextField tf;
	Choice choice;

	// 생성자 초기화: 어플리케이션 클래스에서 타이틀을 설정하기위한 생성
	public EventExampleFrame() {
		this("");
	}

	// 프레임 초기화 메소드

	public EventExampleFrame(String title) {
		super(title);
		// 버튼
		button1 = new Button("등록");
		button2 = new Button("목록");

		// 텍스트 입력칸
		tf = new TextField(20);

		// 선택칸 메소드
		choice = new Choice();
		choice.add("T1");
		choice.add("젠지");
		choice.add("담원");
		choice.add("징동");

	}

	// 컴포넌트 배치 - 변수선언을 위한 메소드
	public void init() {

		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(tf);
		add(choice);
	}

	// 이벤트 처리시 메시지를 출력하는 메소드
	public void showMessage(String message) {
		System.out.println(message);

	}
	
	public void showDialog() {
		//자기자신 클래스 참조   (생성자 , 모달 true 선택시 뒤에꺼가 선택이 안됨)
		Dialog dialog = new Dialog(this, true);
		//dialog 사이즈 출력
		dialog.setSize(300 , 200);
		//dialog가 보이게 하기
		dialog.setVisible(true);
	}

	// 시스템을 종료시키는 메소드
	public void exit() {
		setVisible(false);
		// frame class = os로 부터 얻어온 그래픽 처리 리소스 반납
		dispose();
	}

	// 이벤트 처리
	public void eventHandling() {
//		MouseListener listener = new MouseEventHandler(); //내부클래스로 적용시엔 () 클래스를 따로 적용시엔 (this)
//		button1.addMouseListener(listener);

		// 이름 있는 지역 내부 클래스 - 현재 메소드안에 넣어서 사용중 (사용하고 나면 사라지기때문에 메모리 관리목적)
		// 멤버 내부클래스 - default
		class MouseEventHandler extends MouseAdapter {

//			EventExampleFrame frame; - 멤버 내부 클래스로 적용할땐 필요없음 

			// 원리 1. EventExampleFrame frame 에서 생성자호출로 ouseListener listener = new
			// MouseEventHandler(this); 호출
			// (this) = EventExampleFrame (자기자신 클래스) EventExampleFrame frame 매게 변수로 대입
			// frame -> this.frame 값이동

//			Default 생성자 또한 내부 클래스로 적용시엔 필요없음.
//			public MouseEventHandler(EventExampleFrame frame) {
//				this.frame=frame;
//			}

			// 마우스 클릭햇을때 이벤트 처리
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("Mouse Clicked");
//				바깥 메소드를 통해 처리 
//				showMessage를 통해 sysout 기능을 만들어놨으므로 메소드 기능 사용
//				showMessage("Mouse Clicked..");
				// 마우스 클릭시 종료기능 활성화 해보기
				exit();

			}

			// 마우스를 눌렀을때

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mouse pressed");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			// 마우스가 들어왔을때 : hover

			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setBackground(Color.BLUE);

			}

			// 마우스가 빠져나왔을때
			@Override
			public void mouseExited(MouseEvent e) {
				button2.setBackground(Color.green);

			}

		}
//		MouseListener listener = new MouseEventHandler(); //내부클래스로 적용시엔 () 클래스를 따로 적용시엔 (this)

		// 익명객체를 이용한 이벤트 처리
		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int buttonType = e.getButton();
				// 오른쪽 버튼을 눌렀을때만 IF 메소드를 실행하겠다.
				if (buttonType == MouseEvent.BUTTON3) {
					showMessage("MouseClick....");
				}

				if (buttonType == MouseEvent.BUTTON2) {
					exit();
				}
				
			}

		});
		
		ActionListener al =( (e)-> {
		
			System.out.println("12312312");
			
		});
		
		
		button2.addActionListener ((e)-> System.out.println("삭제혀라") );
	
		// window class
		addWindowListener(new WindowAdapter() {
			//닫기버튼을 눌러 시스템을 종료시키기
			
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				exit();
			}
			
			
			//시스템 종료시 출력되는 문자
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("System return sucessed");
				
			}
			
			// 최소화 했을때 출력되는 이벤트
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowIconified(e);
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				showDialog();
			}
			
			
			
		});

		
		
		
		
		
	}

	// 메인 메소드 - 적용
	public static void main(String[] args) {
		EventExampleFrame frame = new EventExampleFrame("이벤트 처리 예제");
		frame.init();
		frame.eventHandling();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}
