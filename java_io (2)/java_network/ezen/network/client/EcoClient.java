package ezen.network.client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EcoClient {

	public static void main(String[] args) {
		// 연결하고자 하는 컴퓨터 id , 포트번호
		// 현재는 서버,클라이언트 둘다 내 컴퓨터

//		String serverIp =  "192.168.20.19";
//		String serverIp = "localhost";
		String serverIp = "127.0.0.1";
		int serverPort = 7777;

		Scanner scanner = new Scanner(System.in);

		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("에코 서버와 TCP 연결됨 ...");
			// 출력 스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());
			DataInput in = new DataInputStream(socket.getInputStream());
			
			
			
			while (true) {
				System.out.println("서버에 전송하고자 하는 메시지 입력 : ");
				String inputMessage = scanner.nextLine();
				
				//q를 입력받으면 자동으로 종료되도록
				if (inputMessage.equalsIgnoreCase("q")) {
					//서버에 보내는 메시지
					out.writeUTF("q");
					break;
				}

					out.writeUTF(inputMessage);
					String echoedMessage = in.readUTF();
					System.out.println("에코메시지" + echoedMessage);
			
				}

			socket.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("??? 서버와 연결할 수 없습니다");
		}

	}

}
