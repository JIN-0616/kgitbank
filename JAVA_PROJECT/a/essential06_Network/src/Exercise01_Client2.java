import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

/*
	이 main은 사용자에게 배포시킬 프로그램으로
	서버측로 패킷를 보낸후, 서버에서 처리된 패킷을 확인하는 작업을 구현할거다.
*/
public class Exercise01_Client2 {
	public static void main(String[] args) {
		System.out.println("[client] starting");
		Gson gson = new Gson();
		String ip = "192.168.10.27";
		try (DatagramSocket ds = new DatagramSocket();) {
			SocketAddress addr = new InetSocketAddress(ip, 54321);
			System.out.println("[client] started");
			
			Map map = new LinkedHashMap<>();
			
			
			map.put("mode", "sum");
			map.put("data", new int[] {1,34,54,613,5});
			
			String data = gson.toJson(map);
			
			
			
			System.out.println("[client] data : " + data);
			byte[] b = data.getBytes();
			DatagramPacket req = new DatagramPacket(b, b.length, addr);
			ds.send(req);
			System.out.print("[client] packet sent..then ");
			DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
			ds.receive(resp);
			System.out.println("received");
			String result = new String(resp.getData(), 0, resp.getLength());
			System.out.println("[client] result : " + result);

		} catch (IOException e) {
			System.out.println("[client] terminated by error " + e.toString());
		} finally {
			System.out.println("[client] shutdown");
		}

	}
}
