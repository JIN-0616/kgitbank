package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class BankServerMain {
	public static void main(String[] args) {
		long t1= System.currentTimeMillis();
		System.out.println("[bank-Server] starting bank server");
		BankPool pool = new BankPool();
		
		try(DatagramSocket socket = new DatagramSocket(45454);) {
			long t2= System.currentTimeMillis();
			System.out.println("[bank-Server] server startup in " + (t2-t1) +" ms");
			
			while(socket.isBound()) {
				System.out.print("[bank-Server] ");
				DatagramPacket reqPacket = new DatagramPacket(new byte[1024], 1024);
				socket.receive(reqPacket);
				SocketAddress from = reqPacket.getSocketAddress();
				String recv = new String(reqPacket.getData(), 0, reqPacket.getLength());
				System.out.println(recv +  " from " + from.toString());
				String[] req = recv.split("#");
				String resp;
				switch(req[0]) {
				default : 
					resp = "unknown";
					break;
				case "create":
					resp = pool.create();
					break;
				case "get":
					resp = pool.get(req[1], req[2]);	// id, pass
					break;
				case "add":
					resp = pool.add(req[1], req[2], Integer.parseInt(req[3]) );	// id, pass, 금액
					break;
				case "exist":
					resp = pool.exist(req[1]);	// id 존재 유무
					break;
				case "transfer":
					resp = pool.transfer(req[1],req[2],req[3], Integer.parseInt(req[4]));
					break;
				}
				DatagramPacket respPacket = new DatagramPacket(resp.getBytes(), resp.getBytes().length, from);
				socket.send(respPacket);
				System.out.println("[bank-Server] " +resp + " to " + from.toString());
			}
			
		}catch(IOException e) {
			System.err.println("[bank-Server] critical error ocuured " + e.toString());
		}finally {
			System.out.println("[bank-Server] server stopped");
		}
	}
}
