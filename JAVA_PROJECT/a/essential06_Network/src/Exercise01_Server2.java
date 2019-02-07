import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
/*
 * client → server 으로 전달한 packet의 데이터를 합을 구해서, 전송을 하고 있는데
 * 
 * 만약, 서버측에서 해주고 싶은 기능이 합뿐만 아니라, 최대값, 평균 이런것도 해주고 
 * 싶다면..어떻게?
 * 	1. 포트별로 역할을 나눠서 다 따로 설계 (예 60000은 합, 60001은 평균...) - 비효율적임.
 *  1. 이름관리 프로그램 같이 설계 (패킷에 어떤요청인지를 같이 전송, 요청에 따라 다른 처리) - 효율적임
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
