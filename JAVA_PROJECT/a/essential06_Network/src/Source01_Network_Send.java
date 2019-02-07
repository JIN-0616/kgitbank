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
		 * 그 쪽으로 데이터를 보내는 프로그램을 만들어보자.
		 */
		try(DatagramSocket soc = new DatagramSocket();){
			int port =  soc.getLocalPort();
			System.out.println("[시스템] 네트워크 가능! 포트 : " +port);
			
			// Send용 패킷은.. 
			// 보내고자 하는 데이터를 byte[] 로 만들어서, 패킷 생성해주고
			// 목적지까지도 설정해서 생성시켜야 함.
			// 보내고자하는 데이터 ▷ String ▷ byte[] 
			String data ="윤형호";
			byte[] b = data.getBytes();
			/*
			InetAddress address = InetAddress.getByName("192.168.10.27");
			System.out.println(address);
			DatagramPacket packet = new DatagramPacket(b, b.length, address, 49552);
			*/
			SocketAddress address = new InetSocketAddress("192.168.10.27", 49552);
			DatagramPacket packet = new DatagramPacket(b, b.length, address);
			
			soc.send(packet);

			System.out.println("[시스템] 패킷 전송함!");
			
			
		}catch(IOException e) {
			System.out.println("[시스템] 네트워크 오류" +e.toString());
		}
		
		
		
	}
}
