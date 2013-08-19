package socket.client;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 1234);
		socket.setOOBInline(true);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter outWriter = new OutputStreamWriter(out);
		outWriter.write(67); // ������������ַ�"C"
		outWriter.write("hello world\r\n");
		socket.sendUrgentData(65); // ������������ַ�"A"
		socket.sendUrgentData(322); // ������������ַ�"B"
		outWriter.flush();
		socket.sendUrgentData(214); // ����������ͺ��֡��С�
		socket.sendUrgentData(208);
		socket.sendUrgentData(185); // ����������ͺ��֡�����
		socket.sendUrgentData(250);
		socket.close();
	}
}
