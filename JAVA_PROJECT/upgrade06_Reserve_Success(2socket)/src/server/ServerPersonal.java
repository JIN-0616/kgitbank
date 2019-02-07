package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ServerPersonal extends Thread {
	static List<String> seats;
	static List<SocketAddress> pools;
	static DatagramSocket alramSocket;
	static {
		seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("4-H");
		pools = new ArrayList<>();
		try {
			alramSocket = new DatagramSocket(56789);	
		} catch (IOException e) {
			System.out.println("alramSocket create fail "+e.toString());
		}		
	}
	
	static void sendAlramToAll(String alram) {
		DatagramPacket p = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
		for (SocketAddress sa : pools) {
			p.setSocketAddress(sa);
			try {
				alramSocket.send(p);				
			} catch (IOException e) {
				System.out.println("[sever-Thread] send alarm failed target "+ sa);
			}
		}
	}
	
	Socket socket;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	ServerPersonal(Socket soc) {		
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			pools.add(socket.getRemoteSocketAddress());
		} catch (IOException e) {
			System.out.println("[server-"+getName()+"] socket error " + soc.getRemoteSocketAddress());
			throw new RuntimeException();
		}
	}
	
	
	public void run() {
		while (!socket.isClosed()) {
			String req;
			try {
				req = (String) ois.readObject();
			} catch (IOException|ClassNotFoundException	e) {
				break;
			}
			System.out.println("[server-"+getName()+"] received request : " + req);
			String[] reqs = req.split("#");
			String resp = null;
			switch (reqs[0]) {
//			case "port":							// »ó´ë¹æ Ip
//				pools.add(new InetSocketAddress(socket.getInetAddress(),Integer.parseInt(reqs[1])));
			case "reserve":
				synchronized (seats) {
					if (seats.contains(reqs[1])) {
						resp = "false";
					} else {
						resp = "true";
						seats.add(reqs[1]);
						sendAlramToAll("seatChange");
					}
				}
				break;
			case "cancel":
				synchronized (seats) {
					if (seats.contains(reqs[1])) {
						resp = "true";
						seats.remove(reqs[1]);
						sendAlramToAll("seatChange");
					} else {
						resp = "false";
					}
				}
				break;
			case "all":
				resp = seats.toString().replace("[", "").replace("]", "").replace(" ", "").replace(",", "#");
				break;
			default:
				resp = "unknown";
			}
			
			try {
				oos.writeObject(resp);
				System.out.println("[server-"+getName()+"] sent response : " + resp);
			}catch(IOException e) {
				break;
			}
		}
		System.out.println("[server-"+getName()+"] disconnect  : " + socket.getRemoteSocketAddress());
	}
}
