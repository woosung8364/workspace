package ezen.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) {
//		String serverIp = "192.168.20.35";
//		String serverIp = "localhost";
		String serverIp = "127.0.0.1";
		int serverPort = 7777;
		try {
			Socket socket = new Socket(serverIp, serverPort);
			System.out.println("타임 서버와 TCP 연결됨...");
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String time = in.readLine();
			System.out.println("서버에서 수신한 시간 : " + time);
			socket.close();
		} catch (IOException e) {
			System.out.println("??? 서버와 연결할 수 없습니다..");
		}
	}
}








