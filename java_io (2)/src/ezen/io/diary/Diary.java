package ezen.io.diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Diary extends Frame{
	
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem newMI, openMI, saveMI, exitMI;
	Label todayL;
	TextArea contentsTA;
	
	private static int contentLength = 0;
	
	public Diary() {
		this("제목없음");
	}
	
	public Diary(String title) {
		super(title);
		menuBar = new MenuBar();
		fileMenu = new Menu("파일");
		newMI = new MenuItem("새로 만들기");
		openMI = new MenuItem("열기");
		saveMI = new MenuItem("저장");
		exitMI = new MenuItem("끝내기");
		
		todayL = new Label("", Label.RIGHT);
		contentsTA = new TextArea();
	}
	
	public void init() {
		setMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
		
		contentsTA.setFont(new Font("나눔고딕", Font.BOLD, 20));
		add(todayL, BorderLayout.NORTH);
		add(contentsTA, BorderLayout.CENTER);
	}
	
	private void setToday() {
		todayL.setBackground(Color.BLACK);
		todayL.setForeground(Color.WHITE);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					String format = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
					todayL.setText(format);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
				
			}
		}).start();
	}
	
	private void setNew() {
		contentsTA.setText("");
	}
	
	private void openFile() throws IOException {
		String openDirectoryName = "files";
		String contetns = null;
		
		File openDirectory = new File(openDirectoryName);
		if(!openDirectory.exists()) {
			openDirectory.mkdir();
		}
		
		FileDialog fd = new FileDialog(this, "일기 열기", FileDialog.LOAD);
		fd.setDirectory(openDirectory.getAbsolutePath());
		fd.setVisible(true);
		String openFile = fd.getFile();
		if(openFile != null) {
			File file = new File(openFile);
			DataInputStream in = new DataInputStream(new FileInputStream(openDirectory.getAbsolutePath( ) + "/" + openFile));
//			String contents= in.readUTF();
			
			byte[] bytes = new byte[1024];
			int count = in.read(bytes);
			contentsTA.setText(new String(bytes, 0, count));
			
			/*
			String contents = "";
			for (int i=0; i<contentLength; i++) {
				contents += in.readChar();
			}
			contentsTA.setText(contents);
			*/
			setTitle(openFile);
			
		}
	}
	
	/*
	private void saveFile() throws IOException {
		String saveDirectoryName = "files";
		String saveFileName = String.format("%1$tF.txt", Calendar.getInstance());
		String saveTitle = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
		String contetns = contentsTA.getText();
		
		if(contetns.length() == 0) {
			JOptionPane.showMessageDialog(this, "저장할 내용이 없습니다..", "저장 오류", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		File saveDirectory = new File(saveDirectoryName);
		if(!saveDirectory.exists()) {
			saveDirectory.mkdir();
		}
		
		FileDialog fd = new FileDialog(this, "일기 저장", FileDialog.SAVE);
		fd.setFile(saveFileName);
		fd.setDirectory(saveDirectory.getAbsolutePath());
		fd.setVisible(true);
		
		String saveFile = fd.getFile();
		
		// 저장위치 현재 프로젝트아래 files 폴더
//		String fileName = "2023-5-26.dat";
		// 오늘날짜 : 2023-5-26 금요일
		// 읽기 내용.....
		if(saveFile != null) {
			PrintWriter out = new PrintWriter(saveDirectory.getAbsolutePath() + "/" +saveFile, Charset.forName("utf-8"));
			out.println(saveTitle);
			out.println("-----------------------------");
			out.println(contetns);
			out.close();
			setTitle(saveFile);
		}
	}
	*/
	
	
// 	DataoutputStream 활용
	private void saveFile() throws IOException {
		String saveDirectoryName = "files";
		String saveFileName = String.format("%1$tF.dif", Calendar.getInstance());
		String saveTitle = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
		String contetns = contentsTA.getText();
		
		if(contetns.length() == 0) {
			JOptionPane.showMessageDialog(this, "저장할 내용이 없습니다..", "저장 오류", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		File saveDirectory = new File(saveDirectoryName);
		if(!saveDirectory.exists()) {
			saveDirectory.mkdir();
		}
		
		FileDialog fd = new FileDialog(this, "일기 저장", FileDialog.SAVE);
		fd.setFile(saveFileName);
		fd.setDirectory(saveDirectory.getAbsolutePath());
		fd.setVisible(true);
		
		String saveFile = fd.getFile();
		
		if(saveFile != null) {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(saveDirectory.getAbsolutePath() + "/" +saveFile));
//			out.writeUTF(saveTitle);

//			out.writeBytes(saveTitle);
//			out.writeBytes("-----------------------------");
//			out.writeBytes(contetns.getBytes());
			
			out.write(contetns.getBytes());
			
			/*
			contentLength = contetns.length();
			for (int i=0; i<contetns.length(); i++) {
				out.writeChar(contetns.charAt(i));
			}
			*/
			
			out.close();
			setTitle(saveFile);
		}
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void addEventListener() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == newMI) {
					setNew();
				}else if(eventSource == openMI) {
					try {
						openFile();
					} catch (IOException e1) {
						System.err.println(e1);
						JOptionPane.showMessageDialog(null, "일기 열기중 오류가 발생하였습니다.", "열기 오류", JOptionPane.ERROR_MESSAGE);
					}
				}else if(eventSource == saveMI) {
					try {
						saveFile();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "일기 저장중 오류가 발생하였습니다.", "저장 오류", JOptionPane.ERROR_MESSAGE);
					}
				}else if(eventSource == exitMI) {
					exit();
				}
			}
		}
		ActionListener actionListener = new ActionHandler();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				setToday();
			}
		});
		
		newMI.addActionListener(actionListener);
		openMI.addActionListener(actionListener);
		saveMI.addActionListener(actionListener);
		exitMI.addActionListener(actionListener);
	}
	
	public static void main(String[] args) {
		Diary diary = new Diary();
		diary.init();
		diary.setSize(700, 500);
		diary.addEventListener();
		diary.setVisible(true);
	}
}
