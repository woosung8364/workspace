package ezen.ams.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import ezen.ams.app.AMS;
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.AccountType;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.util.Validator;
import ezen.jdbc.JdbcAccountRepository;

/**
 * 은행결제 프로그램
 * 
 * @author 송우성
 */

public class AMSFrame extends Frame {

	/**
	 * 
	 */
	
	private static AccountRepository repository;
	private static final long serialVersionUID = 6130667702523229133L;

	// 그리드백 사용을 위한 호출
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	// 컴포넌트 배치를 위한 변수선언
	// 라벨 (총 8개)
	Label acNum, acType, acOwner, acPasswd, deMoney, BwMoney, acList, unit;

	// 버튼 (총 5개)
	Button check, delete, search, addNew, searchAll;

	// 텍스트 필드 (총 5개)
	TextField acNumTF, acOwnerTF, acPasswdTF, deMoneyTF, bwMoneyTF;

	// 입출금 , 마이너스 계좌
	Choice choice;

	// 계좌 목록 - 하단 출력화면
	TextArea acListMonitor;

	
	Dialog checkDG, deleteDG, searchDG, addNewDG, searchAllDG;

//	AMSFrame 생성자 초기화

	public AMSFrame() {
		this("asdf");
	}

	public AMSFrame(String title) {
		super(title);
		
		try {
			repository = new JdbcAccountRepository();
		} catch (Exception e) {
			dispose();
			System.exit(0);
		}

		// GridBag 기능을 사용하기 위한 초기화
		// Label
		acType = new Label("계좌종류");
		acNum = new Label("계좌번호");
		acOwner = new Label("예금주명");
		acPasswd = new Label("비밀번호");
		BwMoney = new Label("대출금액");
		acList = new Label("계좌목록");
		deMoney = new Label("입금금액");
		unit = new Label("(단위 : 원)");

		// Choice
		choice = new Choice();
		choice.add("전체");
		choice.add("입출금계좌");
		choice.add("마이너스계좌");

		// Button

		check = new Button("조회");
		delete = new Button("삭제");
		search = new Button("검색");
		addNew = new Button("신규등록");
		searchAll = new Button("전체조회");

		// TextField
		acNumTF = new TextField(17);
		acOwnerTF = new TextField(17);
		acPasswdTF = new TextField(17);
		deMoneyTF = new TextField(17);
		bwMoneyTF = new TextField(17);

		// TextAria
		acListMonitor = new TextArea();
	}

	// GridBag 생성자
	public void layout(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
		c.insets = new Insets(10, 10, 10, 10);
		c.weighty = 0.0;
		c.weightx = 0.0;
		c.gridx = gridx; // 시작위치 x
		c.gridy = gridy; // 시작위치 y
		c.gridwidth = gridwidth; // 컨테이너 너비
		c.gridheight = gridheight; // 컨테이너 높이
		gridbag.setConstraints(component, c);
		add(component);
		c.anchor = GridBagConstraints.CENTER;

	}

	public void init() {

		setLayout(gridbag);
		// 첫줄 - 계좌종류 , 선택
		layout(acType, 0, 0, 1, 1);
		layout(choice, 1, 0, 1, 1);

		// 둘째줄 - 계좌번호 , 텍스트칸1 , 조회 , 삭제
		layout(acNum, 0, 1, 1, 1);
		layout(acNumTF, 1, 1, 1, 1);
		layout(check, 2, 1, 1, 1);
		layout(delete, 2, 1, 2, 1);

		// 셋째줄 - 예금주명 , 텍스트칸2 , 검색
		layout(acOwner, 0, 2, 1, 1);
		layout(acOwnerTF, 1, 2, 1, 1);
		layout(search, 2, 2, 1, 1);

		// 넷째줄 - 비밀번호 , 텍스트칸 3 , 입금금액 , 텍스트칸 4
		layout(acPasswd, 0, 3, 1, 1);
		layout(acPasswdTF, 1, 3, 1, 1);
		layout(deMoney, 2, 3, 1, 1);
		layout(deMoneyTF, 3, 3, 3, 1);

		// 다섯째줄 - 대출금액 , 텍스트칸5 , 전체조회 , 신규등록
		layout(BwMoney, 0, 4, 1, 1);
		layout(bwMoneyTF, 1, 4, 1, 1);
		layout(addNew, 3, 4, 1, 1);
		layout(searchAll, 1, 4, 5, 1);

		// 계좌목록 , 단위 원
		layout(acList, 0, 5, 1, 1);
		layout(unit, 4, 5, 1, 1);

		// 상태창
		layout(acListMonitor, 0, 6, 9, 1);
		
	}

	/*
	 * 메소드 추가 라인
	 */

	// 출력창 맨윗부분에 표시되는 내용
	private void printHeader() {
		acListMonitor.append("---------------------------------------------\n");
		acListMonitor.append("계좌번호 예금주 비밀번호  잔액 대출금액\n");
		acListMonitor.append("=============================================\n");
	}

	
	
	// 전체계좌목록 출력하는 메소드
	public void allList() {
		//
		acListMonitor.setText("");
		// 기본 틀 출력메소드 끌어오기
		printHeader();
		// 전체계좌 배열 가져오기
		List<Account> list = repository.getAccounts();
		// 배열이므로 향상 for문 사용
		for (Account account : list) {
			acListMonitor.append(account.toString() + "\n");
		}
	}

	// 시스템 종료를 위한 메소드
	public void exit() {
		// setVisible - false 더이상 화면을 보여주지 않음
		// dispose() - 그래픽 처리 리소스 반납
		setVisible(false);
		dispose();
		System.exit(0);
	}

	// 계좌 생성
	public void addAccount() {
		Account account = null;

		// 계좌번호가 제대로 입력되었는지 유효성 검증을 해주는 메소드
		// 변수 accountNum은 계좌번호 텍스트칸에 입력한 글자이다.
		 String accountNum = acNumTF.getText();

		// 만약 Validaor 클래스에 저장된 hasText() 메소드를 통해
		// 계좌번호가 맞지 않을시 계좌번호 텍스트에 "계좌번호를 입력하라 출력"

		 if(!Validator.hasText(accountNum)) {
		 acNumTF.setText("계좌번호가 맞지 않습니다");
		 }

		 //오류
		String accountOwner = acOwner.getText();
		int password = Integer.parseInt(acPasswd.getText());
		long inputMoney = Long.parseLong(deMoney.getText());

		
		
		// 선택칸
		// getSelectedItem : 선택한 값을 리턴해주는 기능
		String selectedItem = choice.getSelectedItem();

		// 입출금 계좌 등록
		// GENERAL_ACCOUNT , MINUS_ACCONUT 상수로 둘다 Account Type 폴더위치

		// 만약 선택한값이 enum 클래스:AccountType 에 있는 일반계좌와 같다면
		// account는 Account 클래스의 생성자이다.
		if (selectedItem.equals(AccountType.GENERAL_ACCOUNT.getName())) {
			account = new Account(accountOwner, password, inputMoney);

		// 만약 선택한값이 enum 클래스:AccountType 에 있는 마니어스 계좌 상수와 같다면
		// account는 MinusAccount 클래스의 생성자이다.
		} else if (selectedItem.equals(AccountType.MINUS_ACCONUT.getName())) {
			long bwMoney = Long.parseLong(bwMoneyTF.getText());
			account = new MinusAccount(accountOwner, password, inputMoney, bwMoney);
		}

		repository.addAccount(account);
		showDialog();
		JOptionPane.showMessageDialog(this, "정상 등록 처리되었습니다.");
	}

	
	
	//Dialog 활성 메소드
	
	
	
	
		public void showDialog() {
			//자기자신 클래스 참조   (생성자 , 모달 true 선택시 뒤에꺼가 선택이 안됨)
			Dialog dialog = new Dialog(this, false);
			//dialog 사이즈 출력
			dialog.setSize(300 , 200);
			//dialog가 보이게 하기
			dialog.setVisible(true);
		}


	
	
	
	// 계좌번호로 계좌를 조회하는 메소드

	public void searchAccountNum() {
		
		Account account = new Account();
		ListAccountRepository repository = new ListAccountRepository();
			
		//계좌번호칸 텍스트에 입력된 문자를 insertedNum에 대입
		String insertedNum = acNumTF.getText();
		Account list = repository.searchAccount(insertedNum);
		
		showDialog();
		
		if(insertedNum.equals(account.getAccountNum())) {
			list();
		} else {
			
		}
		
	}
				
			
	
	
	

	// CHOICE - 계좌유형을 어떤걸 선택했는지에 따라
	// 출력내용을 다르게 보여주는 스위치 메소드
	public void selectAccountType(AccountType accountType) {

		// 매게변수 accountType = anum 클래스로 상수로 만들어진 일반계좌 , 마이너스계좌
		// 상수가 저장되어있다.

		switch (accountType) {

		// 일반계좌를 선택했을시 입금하기 구획 텍스트칸은 활성화시키고
		// 대출금액 텍스트칸은 비활성화 시킨다.
		case GENERAL_ACCOUNT:
			deMoneyTF.setEnabled(true);
			bwMoneyTF.setEnabled(false);
			break;

		// 위 내용과 반대입니다.
		case MINUS_ACCONUT:
			bwMoneyTF.setEnabled(true);
			deMoneyTF.setEnabled(false);
			break;
		}

	}

	/*
	 * 이벤트처리를 위한 메소드 구역
	 */
	// 매개변수 ActionEvent e 를 대입받으면
	// eventSource 변수에 action 이 실행된 컨텐츠의 모든 속성을 저장시킨다
	// if = 만약 그 이벤트가 발생한곳이 addNew (계정추가) 일시
	// addAccount 계정을 추가하는 메소드를 발생시키고
	// else if = 만약 searchAll(전체조회) 에 이벤트가 발생했다면
	// allList (전체계정조회) 메소드를 발생시킨다.
	// 내부클래스 ActionHandler - ActionListener (인터페이스)
	
	public void addEventListener() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == addNew) {
					addAccount();
				} else if(eventSource == searchAll) {
					allList();
				}			
			}
		}
		ActionListener actionListener = new ActionHandler();
		
		
		// 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		// 창이 열릴때
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//allList();
			}
		});
		
		// 계좌 등록
		addNew.addActionListener(actionListener);
		// 계좌 선택
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(choice.getSelectedItem().equals("입출금계좌")) {
						selectAccountType(AccountType.GENERAL_ACCOUNT);					
					}					
				}
			}
		});
		
		// 전체계좌 조회
		searchAll.addActionListener(actionListener);
	}

	public static void main(String[] args) {
		AMSFrame frame = new AMSFrame("EZEN_BANK_AMS");
		frame.addEventListener();
		frame.init();
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
