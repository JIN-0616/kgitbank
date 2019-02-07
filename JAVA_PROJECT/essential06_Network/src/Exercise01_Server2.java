import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Exercise01_Server2 {
	public static void main(String[] args) {
		System.out.println("[server] start");
		Gson gson = new Gson();
		try (DatagramSocket soc = new DatagramSocket(54321);) {
			for(;;) {
				DatagramPacket pk = new DatagramPacket(new byte[1024], 1024);
				soc.receive(pk);
				System.out.println("[server] data receive...ready...");
				
				String data = new String(pk.getData(), 0, pk.getLength());
				System.out.println("[server] receive : "+data);
				
				Map map = gson.fromJson(data, Map.class);
				String mode = (String)map.get("mode"); 	//������Ÿ�� �ȴٴ� �����Ͽ� �ɽ����ʿ� 
				
				// �� �ȿ� ������ ��µǴ� Ÿ�Ե�
				// String = String
				// ���� = Double
				// Map = List
				
				// �� ����� ������ , ==> String �������� ����ó������ ������ ����
				double rst = 0;
				String[] dd = data.split(" ");
				if(mode.equals("sum")) {
					List<Double> d = (List)map.get("data");
					System.out.println(d);
					for (Double a : d) {
						rst += a;
					}// ---------------���ĺκ� ������ ��Ź
				}else if(mode.equals("avg")) {
					List<Double> d = (List)map.get("data");
					for (int i = 1; i < dd.length; i++) {
						rst += Integer.parseInt(dd[i]);
					}
					rst = rst / (dd.length-1);
				}else if(mode.equals("max")) {
					ArrayList<String> a = new ArrayList<>();
					for (int i = 1; i < dd.length; i++) {
						a.add(dd[i]);
					}
					Collections.sort(a);
				}
				System.out.println("[server] result = "+dd[0]+" : "+((dd[0].equals("avg"))? rst:(int)rst));
				
				String res = String.valueOf(rst);
				byte[] b = res.getBytes();
				DatagramPacket sdpk = new DatagramPacket(b, b.length, pk.getSocketAddress());
				soc.send(sdpk);
				System.out.println("[server] resultdata send");
			}
		} catch (IOException e) {
			System.out.println("[server] termnated by error " + e.toString());

		}
	}
}
