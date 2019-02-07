package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.Account;
import common.Message;
import common.Room;

public class PersonalServer extends Thread {

	static List<SocketAddress> pools;	// ����� ����ڵ��� �����ּҸ� ���� �÷���
	static DatagramSocket alramSocket;	// ��Ŷ���۽� ����� UDP ����

	static Map<String, Account> allAccounts;	// ���������� ������ ���� �÷���  
	static List<Account> connectors;	// ���������ؼ� ������ ����ڵ� ������ ����Ʈ�� �÷���
	static List<Message> chatLogs;	// ����ڵ��� �߻��ϴ� Message ��ü�� ������ ����Ʈ�� �÷���
	static Room[] rooms;	// ���������� ������ ����� ������ �迭 ��ü
	
	static {
		allAccounts = new Hashtable<>();	// File���� �о�� ���� ������ ����.
		allAccounts.put("����",new Account("����", "1111"));
		allAccounts.put("����",new Account("����", "1111"));
		allAccounts.put("���",new Account("���", "1111"));
		allAccounts.put("����",new Account("����", "1111"));
		allAccounts.put("����",new Account("����", "1111"));
		allAccounts.put("����",new Account("����", "1111"));
		allAccounts.put("�κ�",new Account("����", "1111"));
		allAccounts.put("����Ű",new Account("����Ű", "1111"));
		allAccounts.put("���",new Account("���", "1111"));
		
		pools = new ArrayList<>();
		connectors = new Vector<>();
		chatLogs = new Vector<>();
		rooms = new Room[9];
		
		rooms[0] = new Room(new Account("������","1111"));
		rooms[0].enter(new Account("������2","1111"));
		rooms[3] = new Room(new Account("�׽���","1111"));
		
		try {
			alramSocket = new DatagramSocket(56789);
		} catch (IOException e) {
			System.out.println("alramSocket create failed " + e.toString());
		}
	}

	static void sendAlramToAll(String alram) {
		DatagramPacket p = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
		for (SocketAddress sa : pools) {
			p.setSocketAddress(sa);
			try {
				alramSocket.send(p);
			} catch (IOException e) {
				System.out.println("[server-Thread] send alarm failed target : " + sa);
			}
		}
	}
	//===========================================================================================
	
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	Account onUser;	
	long accessTime;
	int idx;
	// �� ���������� ������ ��ü�� �˼� �ְ� ������ ��Ƶ�. (�����Ǵ� ������ �Ʒ�)��

	PersonalServer(Socket soc) {
		socket = soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("[server-" + getName() + "] connected " + soc.getRemoteSocketAddress());
		} catch (IOException e) {
			System.out.println("[server-" + getName() + "] socket error " + soc.getRemoteSocketAddress());
			throw new RuntimeException();
		}
	}

	public void run() {
		while (!socket.isClosed()) {
			String req;
			try {
				req = (String) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				pools.remove(socket.getRemoteSocketAddress());
				connectors.remove(onUser);
				break;
			}
			System.out.println("[server-" + getName() + "] received request : " + req);
			String[] reqs = req.split("#");
			switch (reqs[0]) {
			case "join":	// join#�����ϰ����ϴ´г�#�׿��������
				joinRequestHandle(reqs[1], reqs[2]);
				break;
			case "auth":	// auth#�����ϰ����ϴ´г�#�׿��������
				authRequestHandle(reqs[1], reqs[2]);
				break;
			case "all":
				allRequestHandle();
				break;
			case "exit":
				exitRequestHandle();
				break;
			case "chat":
				chatRequestHandle(reqs[1]);
				break;
			case "chatLog":
				chatLogRequestHandle();
				break;
			case "roomList":
				roomListRequestHandle();
				break;
			case "enter" :
				enterRequestHandle(Integer.parseInt(reqs[1]));
				break;
			case "leave" :
				leaveRequestHandle(reqs[1]);
				break;
			default :
				
			}
		}
		System.out.println("[server-" + getName() + "] disconnect  : " + socket.getRemoteSocketAddress());
	}
	// ������ ��ûó��
	private void leaveRequestHandle(reqs[1]) {
		
		
	}

	// ������ ��ûó��
	private void enterRequestHandle(int idx) {
		if(rooms[idx] == null) {
			rooms[idx] = new Room(onUser);
			sendRepsonse(rooms[idx]);
			sendAlramToAll("changeRooms");
		}else {
			boolean f = rooms[idx].enter(onUser);
			if(f) {
				sendRepsonse(rooms[idx]);
				sendAlramToAll("changeRooms");
			}else {
				sendRepsonse(null);
			}
		}
	}
	// �� ��� ��û ġ��
	private void roomListRequestHandle() {
		sendRepsonse(rooms);	// Room �迭 �����ְ� �˾Ƽ� ó���ǰ�.		
	}
	
	
	private void chatRequestHandle(String txt) {
		boolean b= chatLogs.add(new Message(onUser.nick, txt));
//		sendRepsonse(b);
		sendAlramToAll("newChat");
	}

	private void chatLogRequestHandle() {
		// sendResponse(chatLogs);
		// chatLogs.subList(fromIndex, toIndex)
		// sendRequest(chatLogs.subList(idx, chatLogs.size()) ;	
		// subList�� ������� List�� �������� ���ٰ� ������ ��. 
		
		List<Message> sub = new ArrayList<>();
		sub.addAll(chatLogs.subList(idx, chatLogs.size()));
		sendRepsonse(sub);
	}
	

	// ���� ������ ����� �� : ������ try - catch �� ����.
	private void sendRepsonse(Object obj) {
		try {
			// ObjectOutputStream �� ��µ� ��ü�� ��ü���� ��ü������ ����� �ϰ� ��.
			// ���� ����ؾߵǴ� ��ü��, �̹� ��µ� ���� �ִ� ��ü��, �׳� �װ� �ٽ� �����.
			// �Ź� ���ο� ��ü�� ��µǰ� �Ѵٰų�
			oos.reset();	// ��������� ����.
			oos.writeObject(obj);
		}catch(IOException e) {
			System.out.println("[server-" + getName() + "] i/o error  : " + e.toString());
			pools.remove(socket.getRemoteSocketAddress());
			connectors.remove(onUser);
			stop();
		}
	}
	
	private void exitRequestHandle() {
		pools.remove(socket.getRemoteSocketAddress());
		connectors.remove(onUser);
		sendAlramToAll("changeUsers");
		stop();
	}
	
	//=====================================================================
	private void allRequestHandle() {
		// Object[] ar = connectors.toArray();
		// sendRepsonse(ar);	// Object[] �迭��..
		// Vector t = new Vector();
		// t.addAll(connectors);
		// sendResponse(t);
		sendRepsonse(connectors);	// �׳� �������� List�����ְ�, �˾Ƽ� ó���϶�� �غ���.
	}	
	
	private void authRequestHandle(String nick, String pass) {
		if(allAccounts.containsKey(nick) 
				&& allAccounts.get(nick).getPass().equals(pass)) {
			
			sendRepsonse(true);
			sendAlramToAll("changeUsers");
			
			pools.add(socket.getRemoteSocketAddress());
			onUser = allAccounts.get(nick);
			accessTime = System.currentTimeMillis();
			idx = chatLogs.size();
			connectors.add(onUser);
		}else {
			sendRepsonse(false);
		}
	}

	private void joinRequestHandle(String nick, String pass) {
		if(allAccounts.containsKey(nick) ) {
			sendRepsonse(false);
		}else {
			allAccounts.put(nick, new Account(nick, pass));
			sendRepsonse(true);
		}
	}

}
