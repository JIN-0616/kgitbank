
/*
 * 이제까지 만들어본 프로그램 형태와는 다르게, 
 * 이번에는 java.net 패키지의 객체들을 이용해서 
 * 기계적으로 연결되어 있지 않은 서로 다른 머신간에 
 * 데이터를 주고 받는 네트워킹 작업에 대하여 알아보자.
 * 
 *  네트워크를 이용한 데이터 전송은 TCP 방식과 UDP 방식이 존재한다.
 *   TCP - 통화 방식 (안전한방식)
 *   	(서로 먼저 연결이 일어나야 하고 그 후에 데이터를 주고 받다가 
 *   		더 이상 주고 받을 데이터가 없다면 연결이 끊으면 됨)
 *   UDP - 문자 방식 (비안전한 방식)
 *   	(상대방의 주소만 알고 있으면 별도의 연결과정없이 보내고 받기가 가능함) 	 
 *  
 * 프로그래머는 실제 전송원리보다는, 각 전송방식이 어떤 특징을 가지고 있고,
 * 	방식에 따라 사용하는 객체와 쓰는법이 다르니 여기에 대해서 익혀나가면 된다.
 * 
 * 대부분 네트워크 전송은 TCP를 베이스로 잡고 구축하는경우가 많다.
 * 	구현자체는 UDP가 좀더 쉽기 때문에, 이것부터 살펴보고 TCP를 main으로 알아보자.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Source01_Network_Receive {
	public static void main(String[] args) {
		/* 
		 * UDP 방식으로
		 * 원격 컴퓨터로부터 데이터를 전송받아서 그 전송받은 데이터를
		 * 확인해보는 작업을 해보려고 한다. 
		 */
		System.out.println("[시스템] 스타트");
		/*
		 * UDP 방식의 경우에는 
		 * DatagramSocket : (메신저 역할) 
		 * DatagramPacket : (문자 역할)
		 * 객체 두개를 사용하면 된다.
		 */
		DatagramSocket socket= null;
		try {
			socket = new DatagramSocket(45454);	// 1~65535	
			// 만들면서 port 번호를 몇번 쓸껀지를 결정해야되는데 기본 생성시엔, 알아서 설정이 됨.
			// 지정시엔 원하는 번호를 사용할수 있지만, 이미 사용중이거나 없는 번호면 Exception이 뜸.
			int port = socket.getLocalPort();
			System.out.println("[시스템] 소켓 확보됨! " + port);
			for(int cnt=1;cnt<=100;cnt++) {
				// 받는 작업을 해보려고 하는데,
				// Packet 객체를 생성하는데 byte[] 배열 생성시 설정해주고, 뒤에 배열 크기를 설정해주면 됨.
				byte[] t = new byte[1024];
				DatagramPacket packet = new DatagramPacket(t, 1024);
				// DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);	
				System.out.print("[시스템] 수신대기..");
				socket.receive(packet);	// receive 설정 해두면.. 대기에 있다가, 실제 전달 받으면..
				SocketAddress addr = packet.getSocketAddress();
				System.out.println("완료 .. "+ addr.toString() );	// 풀리고
				byte[] b = packet.getData();
				System.out.println((b == t)   + "? ");
				int len = packet.getLength();
				// System.out.println(b.length+ ".. " + len);
				// byte[]  ▷ String  (▷ parse or split)
				String recv = new String(b, 0, len);
				System.out.println("[시스템] 받은 패킷의 데이터 : " + recv);
				/*
					System.out.println(b.length);
					for(int i=0; i<10; i++) {
						System.out.println(b[i]);
					}
				*/
			}
			
			socket.close();	// try with resource 문 으로 짜도 됨.
			
		} catch(SocketException se ) {
			System.out.println("[시스템] 소켓 오류! (포트 충돌)" + se.toString());
		} catch(IOException e) {
			System.out.println("[시스템] 소켓 오류! (포트 충돌)" + e.toString());
		} finally {
			if(socket != null)
				socket.close();
		}
		
		
		
		
	}
}














