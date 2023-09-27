package ezen.ams.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JOptionPane;

import ezen.ams.app.AMS;
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountType;
import ezen.ams.domain.MinusAccount;

public class AMSFrame extends Frame {

	Panel p1, p2, p3;
	Label accountType, accountNum, accountOwner, passwd, borrowMoney, inputMoney, accountList, won;
	Choice typeC;
	Button foundB, delB, searchB, addB, accountListB;
	TextField numF, ownerF, passwdF, inputF, borrowF;
	TextArea listTA;
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public AMSFrame() {
		this("제목없음");
	}

	public AMSFrame(String title) {
		super(title);
		accountType = new Label("계좌종류", Label.CENTER);
		typeC = new Choice();
//		typeC.add("전체");
//		typeC.add("입출금계좌");
//		typeC.add("마이너스계좌");

//		enum 사용해서 choice 목록 추가 및 한글 확장
		AccountType[] accountTypes = AccountType.values();
		for (AccountType accountType : accountTypes) {
			typeC.add(accountType.getName());
		}

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		accountNum = new Label("계좌번호");
		numF = new TextField(15);
		foundB = new Button("조회");
		delB = new Button("삭제");
		accountOwner = new Label("예금주명");
		ownerF = new TextField(15);
		searchB = new Button("검색");
		passwd = new Label("비밀번호");
		passwdF = new TextField(15);
		inputMoney = new Label("입금금액");
		inputF = new TextField(15);
		borrowMoney = new Label("대출금액");
		borrowF = new TextField(15);
		addB = new Button("신규등록");
		accountListB = new Button("전체조회");
		accountList = new Label("계좌목록");
		listTA = new TextArea();
		won = new Label("(단위 : 원)", Label.RIGHT);
	}

//	그리드 백레이아웃에 붙이는 메소드
	private void gbladd(Component c, int x, int y, int h, int w) {
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbl.setConstraints(c, gbc);
		add(c);
	}
	
	public void init() {
		gbl = new GridBagLayout();
		setLayout(gbl);
		gbc = new GridBagConstraints();

//		버튼 패널
		p1.add(foundB);
		p1.add(delB);

		p2.add(searchB);

		p3.add(addB);
		p3.add(accountListB);

		gbladd(p1, 2, 1, 1, 1);
		gbladd(p2, 2, 2, 1, 1);
		gbladd(p3, 2, 4, 1, 1);

		gbladd(accountType, 0, 0, 1, 1);
		gbladd(typeC, 1, 0, 1, 1);
		gbladd(accountNum, 0, 1, 1, 1);
		gbladd(numF, 1, 1, 1, 1);
//		gbladd(foundB, 2, 1, 1, 1);
//		gbladd(delB, 3, 1, 1, 1);
		gbladd(accountOwner, 0, 2, 1, 1);
		gbladd(ownerF, 1, 2, 1, 1);
//		gbladd(searchB, 2, 2, 1, 1);
		gbladd(passwd, 0, 3, 1, 1);
		gbladd(passwdF, 1, 3, 1, 1);
		gbladd(inputMoney, 2, 3, 1, 1);
		gbladd(inputF, 3, 3, 1, 1);
		gbladd(borrowMoney, 0, 4, 1, 1);
		gbladd(borrowF, 1, 4, 1, 1);

//		gbladd(addB, 2, 4, 1, 1);
//		gbladd(accountListB, 3, 4, 1, 1);
		gbladd(accountList, 0, 5, 1, 1);
		gbladd(listTA, 0, 6, 3, 6);
		gbladd(won, 3, 5, 1, 1);

	}

//	TextArea에 보여지는 헤더
	private void printHeader() {
		listTA.append("--------------------------------------------------------\n");
		listTA.append("계좌번호\t예금주\t비밀번호\t잔액\t대출금액\n");
		listTA.append("--------------------------------------------------------\n");
	}

	public void allList() {
		listTA.setText("");
		printHeader();
		List<Account> list = AMS.repository.getAccounts();
		for (Account account : list) {
			listTA.append(account.toString() + "\n");
		}
	}

	public void selectAccountType(AccountType accountType) {
		switch (accountType) {
		case GENERAL_ACCOUNT:
			borrowF.setEnabled(false);
			break;
		}

	}

	public void addAccount() {
		Account account = null;

//		계좌번호는 자동 생성하기 때문에 입력 받지 않아도 됨
//		String accountNum = accNumTF.getText();
//		if(!Validator.hasText(accountNum)) {
//			accNumTF.setText("계좌번호 입력혀라...");
//		}

		// 편의상 정상 입력되었다 가정
		String accountOwner = ownerF.getText();
		int password = Integer.parseInt(passwdF.getText());
		long inputMoney = Long.parseLong(inputF.getText());

		String selectedItem = typeC.getSelectedItem();
		// 입출금 계좌 등록
		if (selectedItem.equals(AccountType.GENERAL_ACCOUNT.getName())) {
			account = new Account(accountOwner, password, inputMoney);
		} else if (selectedItem.equals(AccountType.MINUS_ACCOUNT.getName())) {
			long loanMoney = Long.parseLong(borrowF.getText());
			account = new MinusAccount(accountOwner, password, inputMoney, loanMoney);
		}

		AMS.repository.addAccount(account);
//		System.out.println("ADD Compliete!!!");
		JOptionPane.showMessageDialog(this, "정상 등록 처리되었습니다.");
	}


//	종료메소드
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void event() {
		class ActionHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if (eventSource == addB) {
					addAccount();
				} else if (eventSource == accountListB) {
					allList();
				}
			}
		}
		ActionListener actionListener = new ActionHandler();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				allList();
			}
		});
		
		// 계좌 등록
		addB.addActionListener(actionListener);
		// 계좌 선택
		typeC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (typeC.getSelectedItem().equals("입출금계좌")) {
						selectAccountType(AccountType.GENERAL_ACCOUNT);
					}
				}

			}
		});

		// 전체계좌 조회
		accountListB.addActionListener(actionListener);

	}

	public static void main(String[] args) {
		AMSFrame ams = new AMSFrame("EZEN-BANK AMS");
		ams.init();
//		ams.setSize(650, 700);
//		ams.setResizable(false);
		ams.pack();
		ams.event();
		ams.setVisible(true);
	}

}
