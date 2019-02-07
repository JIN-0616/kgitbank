package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class BankClientNetwork {
	SocketAddress target;
	DatagramSocket socket;
	
	public BankClientNetwork(String ip) {
		try {
			socket= new DatagramSocket();
			target = new InetSocketAddress(ip, 45454);
			System.out.println("[bank-client] network start");
		}catch(IOException e) {
			System.out.println("[bank-client] network error");
		}
	}
	
	public String sendAndReceive(String req) {
		try {
			DatagramPacket request = new DatagramPacket(req.getBytes(), req.getBytes().length, target);
			socket.send(request);
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			socket.receive(response);
			
			return new String(response.getData(), 0, response.getLength());
		}catch(IOException e) {
			System.out.println("[bank-client] network error");
			return "error";
		}
	}
	
	
}
