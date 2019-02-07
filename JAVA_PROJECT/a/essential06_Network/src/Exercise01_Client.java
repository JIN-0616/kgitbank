import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/*
	이 main은 사용자에게 배포시킬 프로그램으로
	서버측로 패킷를 보낸후, 서버에서 처리된 패킷을 확인하는 작업을 구현할거다.
*/
public class Exercise01_Client {
	public static void main(String[] args) {
		System.out.println("[client] starting");
		String ip = "192.168.10.27";
		try (DatagramSocket ds = new DatagramSocket();) {
			SocketAddress addr = new InetSocketAddress(ip, 54321);
			System.out.println("[client] started");
			String[] mode = new String[] { "sum", "avg", "max" };

			String data = mode[(int) (Math.random() * mode.length)];
			int limit = 3 + (int) (Math.random() * 5);
			int sum = 0;
			int max = 0;
			for (int cnt = 1; cnt <= limit; cnt++) {
				int n = 10 + (int) (Math.random() * 90);
				data += " " + n;
				sum += n;
				if (cnt == 1)
					max = n;
				else
					max = Math.max(max, n);
			}
			System.out.println("sum = " + sum + ", max = " + max + ", avg = " + (double) sum / limit);

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
