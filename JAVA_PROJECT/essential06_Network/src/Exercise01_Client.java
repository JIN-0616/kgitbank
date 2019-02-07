import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/*
	이거는 사용자에게 배포시킬 프로그램으로
	서버쪽으로 패킷을 보낸 후 , 서버에서 처리된 패킷을 확인하는 작업을 구현
	 
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
			
			// 보낼데이터는 String 변환추천 --byte[] 변환 위해서
			
			System.out.println("[client] send : "+data);
			
			byte[] b = data.getBytes();
			//DatagramPacket dp = new DatagramPacket(b, b.length);
			DatagramPacket req = new DatagramPacket(b, b.length, addr);
			ds.send(req);
			
			System.out.println("[client] request send... then...");
			
			// 보낸패킷을 다시 받는데 사용하면 안되는 이유
			// ==> 패킷의 길이 문제 (보낼때는 길이지정, 받을때는 여유롭게)
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
