import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Source01_Network_Send {
	public static void main(String[] args) {
		/*
		 * 데이터를 받는 프로그램이 완성이 됬으니까,
		 *  그 쪽으로 데이터를 보내는 프로그램을 만들어보자.
		 */
		try(DatagramSocket soc = new DatagramSocket();) {
			int port = soc.getLocalPort();
			System.out.println("[시스템] 네트워크 가능! 포트 : "+port);
			
			// send용 패킷은...
			// 보내고자 하는 데이터를 byte[] 로 만들어서, 패킷 생성해주고
			// 목적지까지도 설정해서 생성시켜야 함
			
			// 보통) String --> getBytes() --> byte[] 가장 편한방법
			
			// 보내고자하는 데이터 ▷ String ▷ byte[]
			String data = "윤형호";
			byte[] b = data.getBytes();
			
			/*
		    //1 --------------ip + port 따로-----------------------
			InetAddress address = InetAddress.getByName("192.168.10.27"); //ip or 도메인(자동ip)
			System.out.println(address);			
													//1024 최대상한치(받을때보통설정)
			DatagramPacket packet = new DatagramPacket(b, b.length, address, 49550);
			// (byte[] buf , int length, SokectAddress address) -2개를 동시에 관리해주는 객체
			// (byte[] buf , int length, InetAddress address, int port)
			*/
			
			//2 --------------ip+port 동시관리---------------------
			SocketAddress address = new InetSocketAddress("192.168.10.155", 49604);
			DatagramPacket packet = new DatagramPacket(b, b.length, address);
			
			soc.send(packet);
		
			System.out.println("[시스템] 패킷 전송함!");
			
		} catch (IOException e) {
			System.out.println("[시스템] 네트워크 오류"+e.toString());
		}
	}
}
