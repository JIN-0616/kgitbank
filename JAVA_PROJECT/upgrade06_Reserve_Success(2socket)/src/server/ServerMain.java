package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	public static void main(String[] args) {
		List<String> seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("4-H");
		System.out.println("[server] starting");
		long t1 = System.currentTimeMillis();
		try {
			ServerSocket server = new ServerSocket(56789); // �������� ������ ��Ʈ
			long t2 = System.currentTimeMillis();
			System.out.println("[server] startup in " + (t2 - t1) + " ms");

			while (!server.isClosed()) {
				Socket socket = server.accept(); //
				System.out.println("[server] connected by " + socket.getRemoteSocketAddress());
				Thread p = new ServerPersonal(socket);
				p.start();
			}
			server.close();
		} catch (IOException e) {
			System.out.println("[server] main error : " + e.toString());
			System.out.println("[server] terminated");
		}

	}
}
/*
 * �̷��� �ؼ�,
 *  �����带 �̿��� ����ó���� ����ڵ��� ���������� ó���ϸ�,
 *  ������ ��� ����ڵ��� �䱸�� ó���ϴ� ������ ������ �����غ��Ҵ�.
 *  
 * �̹�����, A,B,C��� ����ڰ� �� ���α׷��� ���� �ִ� ��Ȳ����
 *  A��� ����ڰ� �� �۾��� B, C ����ڿ��Ե� �ٷ� �˼��ְ� ���α׷���
 *  �����غ����� �Ѵ�.
 *  
 * (����� ���� ���� ������ �ִ� ���α׷� : ä��, ...�˸� ���� �ǽð� ����)
 * 
 *  Ŭ���̾�Ʈ�� �׻� write �Ҽ� �־�� �ϰ�
 *  ������ �׻� read�� ���Ǿ�� �Ѵ�.
 *  
 *  ���� 
 *  server - read, write
 *  client - write, read
 *  
 *  
 *  server - ���� read �ϰ� ����� write�ϴ°� ������
 *         �ٸ� ����ڿ��Ե� ��� �˷���� �ϴ� ���� 
 *         
 *  
 *  1. ���� 2�� �����
 *  1. 1�������� ����ġ�� 
 *  
 *  1���� ��Ʈ���� tcp 2���� �ȿ�������
 *  tcp/udp�� ���ÿ� �����ϴ�
 *  
 * 
 */ 
