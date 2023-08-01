package ezen.network.client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
//		String serverIp = "192.168.20.35";
//		String serverIp = "localhost";
		String serverIp = "127.0.0.1";
		int serverPort = 7777;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("에코 서버와 TCP 연결됨...");
			
//			스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());
			DataInput in = new DataInputStream(socket.getInputStream());
			
			while(true) {
				System.out.print("서버에 전송하고자 하는 메시지 입력 : ");
				String inputMessage = scanner.nextLine();
				if(inputMessage.equalsIgnoreCase("q")) {
					out.writeUTF("q");
					break;
				}
				
				// 서버에 메시지 전송
				out.writeUTF(inputMessage);
				String echoedMessage = in.readUTF();
				System.out.println("에코메시지 : " + echoedMessage);
			}
			
			socket.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("에코 서버와 연결할 수 없습니다..");
		}
	}
}








