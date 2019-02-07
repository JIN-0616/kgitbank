import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
/*
 * client �� server ���� ������ packet�� �����͸� ���� ���ؼ�, ������ �ϰ� �ִµ�
 * 
 * ����, ���������� ���ְ� ���� ����� �ջӸ� �ƴ϶�, �ִ밪, ��� �̷��͵� ���ְ� 
 * �ʹٸ�..���?
 * 	1. ��Ʈ���� ������ ������ �� ���� ���� (�� 60000�� ��, 60001�� ���...) - ��ȿ������.
 *  1. �̸����� ���α׷� ���� ���� (��Ŷ�� ���û������ ���� ����, ��û�� ���� �ٸ� ó��) - ȿ������
 *  
 *   
 */
public class Exercise01_Server2 {
	public static void main(String[] args) {
		System.out.println("[server] starting");
		Gson gson = new Gson();

		try (DatagramSocket ds = new DatagramSocket(54321);) {
			System.out.println("[server] started");
			
			for(int cnt=1; cnt<=10; cnt++) {
				System.out.print("[server] listen,  ");
				DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
				ds.receive(resp);
				String data = new String(resp.getData(), 0, resp.getLength());
				System.out.println("received data " + data);
				Map map = gson.fromJson(data, Map.class);
				String mode = (String)map.get("mode");
				
				String result;
				switch(mode) {
				case "sum":
					List<Double> d= (List)map.get("data");
					System.out.println(d);
					result = "sum error";
					break;
				case "avg":
					result = "avgerage error";
					break;
				case "max":
					result = "max error";
					break;
				default:
					result = "unknown mode";
				}
				
				byte[] b = result.getBytes();
				DatagramPacket req = new DatagramPacket(b, b.length, resp.getSocketAddress());
				ds.send(req);
				System.out.println("[server] data sent : "+ result);
			}
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("[server] terminated by error " + e.toString());
		} finally {
			System.out.println("[server] shutdown");
		}

	}
}
