import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/*
	�̰Ŵ� ����ڿ��� ������ų ���α׷�����
	���������� ��Ŷ�� ���� �� , �������� ó���� ��Ŷ�� Ȯ���ϴ� �۾��� ����
	 
*/
public class Exercise01_Client {
	public static void main(String[] args) {
		String ip = "192.168.10.155";
		System.out.println("[client] start");
		try (DatagramSocket ds = new DatagramSocket();) {
			SocketAddress addr = new InetSocketAddress(ip, 54321);
			
			System.out.println("[client] started");
			
			String[] mode = new String[] {"sum", "avg", "max"};
			String data = mode[(int)(Math.random()*mode.length)];
			int limit = 3+(int)(Math.random()*5);
			for (int cnt = 1; cnt <=limit; cnt++) {
				int n = 10+(int)(Math.random()*90);
				data += " "+n;
			}
			
			// ���������ʹ� String ��ȯ��õ --byte[] ��ȯ ���ؼ�
			
			System.out.println("[client] send : "+data);
			
			byte[] b = data.getBytes();
			//DatagramPacket dp = new DatagramPacket(b, b.length);
			DatagramPacket req = new DatagramPacket(b, b.length, addr);
			ds.send(req);
			
			System.out.println("[client] request send... then...");
			
			// ������Ŷ�� �ٽ� �޴µ� ����ϸ� �ȵǴ� ����
			// ==> ��Ŷ�� ���� ���� (�������� ��������, �������� �����Ӱ�)
			//------------------------------------------------------------------			
			DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
			ds.receive(resp);
			
			System.out.println("[client] response received");
			
			String result = new String(resp.getData(), 0, resp.getLength());
			
			System.out.println("[client] result = "+data.split(" ")[0]+" : "+result);
			
			
		} catch (IOException e) {
			System.out.println("[client] termnated by error " + e.toString());
		}
		
	}
}
