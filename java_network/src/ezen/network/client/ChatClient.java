package ezen.network.client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
//		String serverIp = "localhost";
		String serverIp = "127.0.0.1";
		int serverPort = 7777;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("채팅 서버와 TCP 연결됨...");
			
//			스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());
			DataInput in = new DataInputStream(socket.getInputStream());
			
			while(true) {
				// 임시 익명 스레드 생성 및 시작
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						String chatMessage;
						try {
							while(true) {
								chatMessage = in.readUTF();
								if(chatMessage.equalsIgnoreCase("q")) {
									break;
								}
								System.out.println(chatMessage);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				thread.start();

				
				System.out.print("[김기정] : ");
				String inputMessage = scanner.nextLine();
				if(inputMessage.equalsIgnoreCase("q")) {
					out.writeUTF("q");
					break;
				}
				
				// 서버에 메시지 전송
				out.writeUTF("[김기정] : " + inputMessage);
				
			}
			
			socket.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("채팅 서버와 연결할 수 없습니다..");
		}
	}
}








