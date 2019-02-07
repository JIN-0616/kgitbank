import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Source01_Network_Send {
	public static void main(String[] args) {
		/*
		 * �����͸� �޴� ���α׷��� �ϼ��� �����ϱ�,
		 * �� ������ �����͸� ������ ���α׷��� ������.
		 */
		try(DatagramSocket soc = new DatagramSocket();){
			int port =  soc.getLocalPort();
			System.out.println("[�ý���] ��Ʈ��ũ ����! ��Ʈ : " +port);
			
			// Send�� ��Ŷ��.. 
			// �������� �ϴ� �����͸� byte[] �� ����, ��Ŷ �������ְ�
			// ������������ �����ؼ� �������Ѿ� ��.
			// ���������ϴ� ������ �� String �� byte[] 
			String data ="����ȣ";
			byte[] b = data.getBytes();
			/*
			InetAddress address = InetAddress.getByName("192.168.10.27");
			System.out.println(address);
			DatagramPacket packet = new DatagramPacket(b, b.length, address, 49552);
			*/
			SocketAddress address = new InetSocketAddress("192.168.10.27", 49552);
			DatagramPacket packet = new DatagramPacket(b, b.length, address);
			
			soc.send(packet);

			System.out.println("[�ý���] ��Ŷ ������!");
			
			
		}catch(IOException e) {
			System.out.println("[�ý���] ��Ʈ��ũ ����" +e.toString());
		}
		
		
		
	}
}
