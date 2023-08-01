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
		// 연결하고자 하는 컴퓨터 id , 포트번호
		// 현재는 서버,클라이언트 둘다 내 컴퓨터

		String serverIp =  "192.168.20.20";
//		String serverIp = "localhost";
//		String serverIp = "192,168.20.35";
		int serverPort = 7777;

		Scanner scanner = new Scanner(System.in);

		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("채팅 서버와 TCP 연결됨 ...");

			// 스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());
			DataInput in = new DataInputStream(socket.getInputStream());

			while (true) {

				// 임시 익명 스레드 생성 및 시작
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						String chatMessage;
						try {
							while (true) {
								chatMessage = in.readUTF();
								if (chatMessage.equalsIgnoreCase("q")) {
									break;
								}
								System.out.println(chatMessage);
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});

				thread.start();

				System.out.println("[송우성] : ");
				String inputMessage = scanner.nextLine();

				// q를 입력받으면 자동으로 종료되도록
				if (inputMessage.equalsIgnoreCase("q")) {
					// 서버에 보내는 메시지
					out.writeUTF("q");
					break;
				}

				// 서버에 메시지 전송
				out.writeUTF("[송우성] : " + inputMessage);

			}

			socket.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("??? 서버와 연결할 수 없습니다");
		}

	}

}
