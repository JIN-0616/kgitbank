package server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class BankServerMain2 {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		Gson gson = new Gson();
		BankPool pool = null;
		System.out.println("[bank-Server] starting bank server");
		System.out.println("[bank-Server] initiate bank pool");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bank.log"))) {
			Object obj = ois.readObject();
			if(obj instanceof BankPool) {
				pool = (BankPool)obj;
				System.out.println("[bank-Server] load exist bank pool");
				System.out.println(pool);
			}else {
				pool = new BankPool();
				System.out.println("[bank-Server] create new bank pool");
			}
		} catch (IOException | ClassNotFoundException e) {
			pool = new BankPool();
			System.out.println("[bank-Server] create new bank pool");
		}
		
		try (DatagramSocket socket = new DatagramSocket(54321);) {
			long t2 = System.currentTimeMillis();
			System.out.println("[bank-Server] server startup in " + (t2 - t1) + " ms");

			while (socket.isBound()) { // 소켓이 열려있는 동안
				System.out.print("[bank-Server] ");
				DatagramPacket reqPacket = new DatagramPacket(new byte[1024], 1024);
				socket.receive(reqPacket);
				SocketAddress from = reqPacket.getSocketAddress();
				String recv = new String(reqPacket.getData(), 0, reqPacket.getLength());
				HashMap<String, String> map = gson.fromJson(recv, HashMap.class);	
				String resp = "";
				System.out.println(recv + " from " + from.toString());				
				switch (map.get("order")) {
				default:
					resp = "unknown";
					break;
				case "create":
					resp = pool.create();
					break;
				case "get":
					resp = pool.get(map.get("id"), map.get("pw"));
					break;
				case "add":
					resp = pool.add(map.get("id"),map.get("pw"), Integer.parseInt(map.get("money")));
					break;
				case "sub":
					resp = pool.sub(map.get("id"), map.get("pw"), Integer.parseInt(map.get("money")));
					break;
				case "transfer":
					resp = pool.transfer(map.get("id"), map.get("pw"), Integer.parseInt(map.get("money")), map.get("toid"));
					break;
				case "pass" :
					resp = pool.modifypass(map.get("id"), map.get("pw"));
					break;
				case "newpass" :
					resp = pool.modifypass(map.get("id"), map.get("pw"), map.get("money"));
					break;
				case "exist":
					resp = pool.exist(map.get("id"));	// id 존재 유무
					break;
				case "close":
					resp = "is closed";
					return;
				}
				String aa = gson.toJson(resp);
				DatagramPacket respPacket = new DatagramPacket(aa.getBytes(), aa.getBytes().length, from);
				socket.send(respPacket);
				System.out.println("[bank-Server] " + resp + " to " + from.toString());
			}
		} catch (IOException e) {
			System.err.println("[bank-Server] critical error ocuured " + e.toString());
		} finally {
			System.out.println("[bank-Server] server stopped");
		//	String id = gson.toJson(pool);
			System.out.println(pool);
			try(ObjectOutputStream oos 
					= new ObjectOutputStream(new FileOutputStream("bank.log"))) {
				System.out.print("output try..");
				oos.writeObject(pool);
				System.out.println("success!");
			} catch (IOException e) {
				System.out.println("failed.."+e.toString());
			}
		}
	}
}
// 계좌 이체(#), 계좌 출금, 계좌 비번번경 구현 check
// 서버 구현 후 클라이언트 생성 scanner or GUI 등등 이용
// 기본 # split / Gson 사용도 가능
// 로그인 개념은 없음, 트렌젝션마다 id pw 입력 필요함
// 서버 종료시에 id 파일로 남겼으면 더 좋음- check 	