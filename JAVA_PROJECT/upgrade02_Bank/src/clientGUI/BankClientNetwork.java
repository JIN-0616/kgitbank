package clientGUI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class BankClientNetwork {
	DatagramSocket ds;
	SocketAddress sa;
	public BankClientNetwork(String string) {
		try {
			 ds = new DatagramSocket();
			 sa = new InetSocketAddress("127.0.0.1",54321);
			System.out.println("[client] network start");
		} catch (IOException e) {
			System.out.println("[client] network error"+e.toString());
		}
	}


	public String sendAndReceive(String req) {
		try {
			DatagramPacket dp = new DatagramPacket(req.getBytes(), req.getBytes().length);
			ds.send(dp);
			DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
			ds.receive(resp);
			return new String(resp.getData(), 0, resp.getData().length);
		} catch (IOException e) {
			System.out.println("[client] sandAndReceive Error");
			return "error";
		}
	}

}
