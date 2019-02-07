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

public class PersonalServer extends Thread{
	//--static---------------------------------------------------------------------------------------
	static DatagramSocket alramSocket;  //  ��Ŷ���۽� ����� UDP ����
	static Map<String,Account> allAccounts;		// ���������� ������ ���� �÷���
	static List<Account> connectors;			// ���������ؼ� ������ ����ڸ� ������ ����Ʈ�� �÷���
	
	static List<SocketAddress> pools;	// ����� ����ڵ��� �����ּҸ� ���� �÷���
	static List<Message> chatLog;		// ����ڵ��� �߻��ϴ� Message ��ü�� ������ ����Ʈ�� �÷���
	static Room[] rooms;				// ���������� ������ ����� ������ �迭 ��ü
	
	static {		
		allAccounts = new Hashtable<>();
		//  File���� �о�� ���� ������ ����
			allAccounts.put("admin", new Account("admin", "admin"));
			allAccounts.put("test1", new Account("test1", "test1"));
			allAccounts.put("test2", new Account("test2", "test2"));
			allAccounts.put("test3", new Account("test3", "test3"));
			allAccounts.put("test4", new Account("test4", "test4"));

		pools = new ArrayList<>();
		connectors = new Vector<>();
		chatLog = new Vector<>();
		rooms = new Room[9];
			rooms[0] = new Room(new Account("������", "1111"));
			rooms[0].enter(new Account("������2","1111"));
			
			rooms[3] = new Room(new Account("�׽���","1111"));
			
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
	// ing.......................................
	static void sendRoomRefreshAlram(String alram, Room r) {		
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
	//-----------------------------------------------------------------------------------------------
	Socket socket;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	Account onUser; 
	long accessTime;
	int idx;
	// �� ���������� ������ ��ü�� �˼� �ְ� ������ ��Ƶ� ( ���������� �Ʒ�)
	
	PersonalServer(Socket soc) {		
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//pools.add(socket.getRemoteSocketAddress()); -> ���������ؾ� �˶������ϹǷ� ���⼭�� �ʿ����
			System.out.println("[server-"+getName()+"] socket ready " + soc.getRemoteSocketAddress());
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
				pools.remove(socket.getRemoteSocketAddress());
				connectors.remove(onUser);
				break;
			}
			System.out.println("[server-"+getName()+"] received request : " + req);
			String[] reqs = req.split("#"); 			
			switch (reqs[0]) {
			case "join":		
				joinRequestHandle(reqs[1],reqs[2]);
				break;
			case "auth":				
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
				roomListReqiestHandle();
				break;
			case "enter":
				roomMakeEnterHandle(reqs[1]);				
				break;
			case "leave":
				roomLeaveHandle();
				break;
			case "myRoom":
				roomInfoHandle();
			default:
				
			}
		}
		System.out.println("[server-"+getName()+"] disconnect  : " + socket.getRemoteSocketAddress());
	}
	
		

		private void roomInfoHandle() {
			int inx = onUser.roomNum;
			sendRepsonse(rooms[idx]);
		
		}
		private void roomLeaveHandle() {
			// ���ȣ�� ����Ű���� �ƴϳ��� ����
			
			/*  1. ��ȣ��� ����
			for (int i = 0; i < rooms.length; i++) {
				if(rooms[i] == null) 
					continue;
				if(rooms[i].joiner.contains(onUser)) {
					idx = i;
					break;
				}
			}
			*/
			//  2. account�� ���
			int idx = onUser.roomNum;			
			sendRepsonse(rooms[idx].leaved(onUser));
			if(rooms[idx].isEmpty()) {
				rooms[idx] = null;
			}
			sendAlramToAll("changeRooms");
			sendRoomRefreshAlram("refresh", rooms[idx]);
			// 3. �����忡 ���
			/*
			// idx = currentRoomIdx;
			idx = onUser.room;
			
			Room r = rooms[idx];	
			boolean rst = r.leave(onUser);
			sendRepsonse(rst);
			if(r.isEmpty()) {
				rooms[idx] = null;
			}
			sendAlramToAll("changeRooms");
			currentRoomIdx = -1;
			onUser.room = -1;
			*/
		}


		private void roomMakeEnterHandle(String index) {
			int idx = Integer.parseInt(index);
			if(rooms[idx] == null) {
				rooms[idx] = new Room(onUser);
				sendRepsonse(rooms[idx]);
				sendAlramToAll("changeRooms");
				onUser.roomNum = idx;
				sendRoomRefreshAlram("refresh",rooms[idx]);
			}else if(rooms[idx] != null) {
				if(rooms[idx].enter(onUser)) {
					sendRepsonse(rooms[idx]);
					sendAlramToAll("changeRooms");
					onUser.roomNum = idx;
					sendRoomRefreshAlram("refresh",rooms[idx]);
				}else {
					sendRepsonse(null);
				}
			}			
		}


		private void roomListReqiestHandle() {			
			sendRepsonse(rooms);	// Room�迭�� �����ְ� �˾Ƽ�
			
		}


		private void chatLogRequestHandle() {
			// chatLogs.subList(fromIndex, toIndex)
			
			// sendRequest(chatLog.subList(idx, chatlog.size());
			// subList�� ������� List�� �������� ���ٰ� ������ �� (not Sireialized?)
			
			/*	===========idx �̿� ���============
			List<Message> sub = new ArrayList<>();
			sub.addAll(chatLog.subList(idx, chatLog.size()));
			sendRepsonse(sub);
			*/
			List<Message> timeLog = new Vector<>();
			for (Message m : chatLog) {
				if(accessTime<m.getTime()) {
					timeLog.add(m);
				}
			}
			sendRepsonse(timeLog);
			
		//	sendRepsonse(chatLog);			
		}
		private void chatRequestHandle(String log) {
//			boolean b = chatLog.add(new Message(onUser.nick, log));
//			sendRepsonse(b);
			chatLog.add(new Message(onUser.nick, log));
			sendAlramToAll("newChat");
			//�ð��� �����ϴ� �� �����غ���
		}

		// ���� ������ ����� �� : ������ try - catch �� ����.
		private void sendRepsonse(Object obj) {
			try {
				synchronized (oos) {					
					// ObjectOutputStream�� ��µ� ��ü�� ��ü���� ��ü������ ����� �ϰ� ��
					// ���� ����ؾߵǴ� ��ü��, �̹� ��µ� ���� �ִ� ��ü��, �׳� �װ� �ٽ� �����
					// �Ź� ���ο� ��ü�� ��µǰ� �Ѵٰų�
					oos.reset(); // ��������� ����				
					oos.writeObject(obj);
				}
			}catch(IOException e) {
				System.out.println("[server-" + getName() + "] i/o error  : " + e.toString());
				pools.remove(socket.getRemoteSocketAddress());
				connectors.remove(onUser);
				stop();
			}
		}		
	
		
		
		//=====================================================================
		private void allRequestHandle() {	//  1 ,  2  ,  3 
		//	Object[] ar = connectors.toArray();
		//	sendRepsonse(ar);
		
		//	Vector t = new Vector<>();
		//	t.addAll(connectors);
			sendRepsonse(connectors);	// �׳� �������� List�����ְ�, �˾Ƽ� ó���϶�� �غ���			
		}

		private void authRequestHandle(String nick, String pass) {
			if(allAccounts.containsKey(nick) 
					&& allAccounts.get(nick).getPass().equals(pass)) {
				if(!connectors.contains(allAccounts.get(nick))) {
					sendRepsonse(true);
					pools.add(socket.getRemoteSocketAddress());
					
					onUser = allAccounts.get(nick);
					accessTime = System.currentTimeMillis();
					connectors.add(onUser);
					sendAlramToAll("changeUsers");
					idx = chatLog.size();										
				}else {
					sendRepsonse(false);
				}
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
		
		private void exitRequestHandle() {
			pools.remove(socket.getRemoteSocketAddress());
			connectors.remove(onUser);
			sendAlramToAll("changeUsers");
			this.stop();
		}
}
