package socket.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(1234);
		System.out.println("�������Ѿ��������˿ںţ�1234");
		while (true) {
			Socket socket = serverSocket.accept();
			socket.setOOBInline(true);
			InputStream in = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader bReader = new BufferedReader(inReader);
			System.out.println(bReader.readLine());
			System.out.println(bReader.readLine());
			socket.close();
		}
	}
}
