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
			ServerSocket server = new ServerSocket(56789); // 서버에서 개방할 포트
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
 * 이렇게 해서,
 *  쓰레드를 이용한 동시처리로 사용자들의 다중접속을 처리하며,
 *  접속한 모든 사용자들의 요구를 처리하는 형태의 서버를 구현해보았다.
 *  
 * 이번에는, A,B,C라는 사용자가 이 프로그램을 쓰고 있는 상황에서
 *  A라는 사용자가 한 작업을 B, C 사용자에게도 바로 알수있게 프로그램을
 *  개조해보려고 한다.
 *  
 * (사용자 간에 서로 영향을 주는 프로그램 : 채팅, ...알림 같은 실시간 서비스)
 * 
 *  클라이언트가 항상 write 할수 있어야 하고
 *  서버는 항상 read가 대기되어야 한다.
 *  
 *  기존 
 *  server - read, write
 *  client - write, read
 *  
 *  
 *  server - 에서 read 하고 결과를 write하는건 같으나
 *         다른 사용자에게도 모두 알려줘야 하는 구조 
 *         
 *  
 *  1. 소켓 2개 사용방식
 *  1. 1개가지고 돌려치기 
 *  
 *  1개의 포트에서 tcp 2개는 안열리지만
 *  tcp/udp는 동시에 가능하다
 *  
 * 
 */ 
