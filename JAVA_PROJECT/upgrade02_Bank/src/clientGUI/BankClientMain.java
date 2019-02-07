package clientGUI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class BankClientMain {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println("[bank-Client] starting bank Client");
		Gson gson = new Gson();
		try (DatagramSocket ds = new DatagramSocket()) {
			long t2 = System.currentTimeMillis();
			System.out.println("[bank-Client] Client startup in " + (t2 - t1) + " ms");
			
			while(ds.isBound()) {
				System.out.print("[bank-Client] ");
				Scanner sc = new Scanner(System.in);				
				String data = sc.nextLine();			
				String[] dd = data.split("#");
				Map<String, String> map = new HashMap();
				switch (dd.length) {
				case 5:
					map.put("toid",dd[4]);
				case 4:
					map.put("money",dd[3]);
				case 3:
					map.put("pw",dd[2]);
				case 2:
					map.put("id",dd[1]);
				case 1:
					map.put("order", dd[0]);
				default:
					break;
				}
					
				String datas = gson.toJson(map);
				System.out.println(datas);
				
				byte[] b = datas.getBytes();
				String ip = "127.0.0.1";
				SocketAddress sa = new InetSocketAddress(ip, 54321);
				DatagramPacket sp = new DatagramPacket(b, b.length, sa);
				ds.send(sp);
				if(data.equals("close")) {
					ds.close();
				}
				System.out.println("[bank-Client] request sending...");
				
				DatagramPacket rp = new DatagramPacket(new byte[1024], 1024);
				ds.receive(rp);
				String re = new String(rp.getData(), 0, rp.getLength());	
				String resp = gson.fromJson(re, String.class);
				System.out.println("[bank-Client] "+resp);		

			}
		} catch (IOException e) {
			System.err.println("[bank-Client] critical error ocuured " + e.toString());
		} finally {
			System.out.println("[bank-Client] Client stopped");
		}
	}
}
