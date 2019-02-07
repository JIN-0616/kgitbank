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
	static DatagramSocket alramSocket;  //  패킷전송시 사용할 UDP 소켓
	static Map<String,Account> allAccounts;		// 계정정보를 저장할 맵형 컬렉션
	static List<Account> connectors;			// 인증성공해서 접속한 사용자를 저장할 리스트형 컬렉션
	
	static List<SocketAddress> pools;	// 연결된 사용자들의 소켓주소를 모을 컬렉션
	static List<Message> chatLog;		// 사용자들이 발생하는 Message 객체를 저장할 리스트형 컬렉션
	static Room[] rooms;				// 서버측에서 관리할 방들을 관리할 배열 객체
	
	static {		
		allAccounts = new Hashtable<>();
		//  File에서 읽어내야 되지 않을까 싶음
			allAccounts.put("admin", new Account("admin", "admin"));
			allAccounts.put("test1", new Account("test1", "test1"));
			allAccounts.put("test2", new Account("test2", "test2"));
			allAccounts.put("test3", new Account("test3", "test3"));
			allAccounts.put("test4", new Account("test4", "test4"));

		pools = new ArrayList<>();
		connectors = new Vector<>();
		chatLog = new Vector<>();
		rooms = new Room[9];
			rooms[0] = new Room(new Account("개발자", "1111"));
			rooms[0].enter(new Account("개발팀2","1111"));
			
			rooms[3] = new Room(new Account("테스터","1111"));
			
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
	// 이 개별서버의 주인을 객체가 알수 있게 변수로 잡아둠 ( 생성지점은 아래)
	
	PersonalServer(Socket soc) {		
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//pools.add(socket.getRemoteSocketAddress()); -> 인증성공해야 알람가게하므로 여기서는 필요없음
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
			// 방번호를 기억시키느냐 아니냐의 문제
			
			/*  1. 번호기억 없이
			for (int i = 0; i < rooms.length; i++) {
				if(rooms[i] == null) 
					continue;
				if(rooms[i].joiner.contains(onUser)) {
					idx = i;
					break;
				}
			}
			*/
			//  2. account에 기억
			int idx = onUser.roomNum;			
			sendRepsonse(rooms[idx].leaved(onUser));
			if(rooms[idx].isEmpty()) {
				rooms[idx] = null;
			}
			sendAlramToAll("changeRooms");
			sendRoomRefreshAlram("refresh", rooms[idx]);
			// 3. 쓰레드에 기억
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
			sendRepsonse(rooms);	// Room배열을 보내주고 알아서
			
		}


		private void chatLogRequestHandle() {
			// chatLogs.subList(fromIndex, toIndex)
			
			// sendRequest(chatLog.subList(idx, chatlog.size());
			// subList에 만들어진 List는 보낼수가 없다고 에러가 뜸 (not Sireialized?)
			
			/*	===========idx 이용 방법============
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
			//시간대 적용하는 것 생각해볼것
		}

		// 응답 보낼때 사용할 것 : 일일이 try - catch 가 힘듬.
		private void sendRepsonse(Object obj) {
			try {
				synchronized (oos) {					
					// ObjectOutputStream로 출력된 객체는 객체값을 자체적으로 기억을 하게 됨
					// 만약 출력해야되는 객체가, 이미 출력된 적이 있는 객체면, 그냥 그걸 다시 출력함
					// 매번 새로운 객체를 출력되게 한다거나
					oos.reset(); // 기억정보를 날림				
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
			sendRepsonse(connectors);	// 그냥 관리중인 List보내주고, 알아서 처리하라고 해보자			
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
