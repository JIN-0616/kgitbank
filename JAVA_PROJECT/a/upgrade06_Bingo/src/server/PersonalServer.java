package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class PersonalServer  extends Thread {

	static List<SocketAddress> pools;
	static DatagramSocket alramSocket;
	
	static {
		pools = new ArrayList<>();
		try {
			alramSocket = new DatagramSocket(56789);
		}catch(IOException e) {
			System.out.println("alramSocket create failed " +e.toString());
		}
	}
	
	static void sendAlramToAll(String alram) {
		DatagramPacket p = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
		for(SocketAddress sa : pools) {
			p.setSocketAddress(sa);
			try {
				alramSocket.send(p);
			} catch (IOException e) {
				System.out.println("[server-Thread] send alarm failed target : " + sa);
			}
		}
	}
	
	
	Socket socket;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	PersonalServer(Socket soc) {
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
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
			
			String resp=null;
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
