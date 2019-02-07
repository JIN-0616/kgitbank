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

	static List<SocketAddress> pools;	// 연결된 사용자들의 소켓주소를 모을 컬렉션
	static DatagramSocket alramSocket;	// 패킷전송시 사용할 UDP 소켓

	static Map<String, Account> allAccounts;	// 계정정보를 저장할 맵형 컬렉션  
	static List<Account> connectors;	// 인증성공해서 접속한 사용자들 저장할 리스트형 컬렉션
	static List<Message> chatLogs;	// 사용자들이 발생하는 Message 객체를 저장할 리스트형 컬렉션
	static Room[] rooms;	// 서버측에서 관리할 방들을 관리할 배열 객체
	
	static {
		allAccounts = new Hashtable<>();	// File에서 읽어내야 되지 않을까 싶음.
		allAccounts.put("루피",new Account("루피", "1111"));
		allAccounts.put("조로",new Account("조로", "1111"));
		allAccounts.put("우솝",new Account("우솝", "1111"));
		allAccounts.put("나미",new Account("나미", "1111"));
		allAccounts.put("샹디",new Account("샹디", "1111"));
		allAccounts.put("쵸파",new Account("쵸파", "1111"));
		allAccounts.put("로빈",new Account("쵸파", "1111"));
		allAccounts.put("프랑키",new Account("프랑키", "1111"));
		allAccounts.put("브룩",new Account("브룩", "1111"));
		
		pools = new ArrayList<>();
		connectors = new Vector<>();
		chatLogs = new Vector<>();
		rooms = new Room[9];
		
		rooms[0] = new Room(new Account("개발팀","1111"));
		rooms[0].enter(new Account("개발팀2","1111"));
		rooms[3] = new Room(new Account("테스터","1111"));
		
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
	int currentRoomIdx;
	// 이 개별서버의 주인을 객체가 알수 있게 변수로 잡아둠. (설정되는 지점은 아래)ㄴ

	PersonalServer(Socket soc) {
		currentRoomIdx = -1;
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
			case "leave":
				leaveRequestHandle();
				break;
				
			case "join":	// join#가입하고자하는닉넴#그에따른비번
				joinRequestHandle(reqs[1], reqs[2]);
				break;
			case "auth":	// auth#인증하고자하는닉넴#그에따른비번
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
			default :
				
			}
		}
		System.out.println("[server-" + getName() + "] disconnect  : " + socket.getRemoteSocketAddress());
	}

	// 방퇴장요청처리
	private void leaveRequestHandle() {
		int idx = -1;	// 사용자가 있는 방번호를 얻어서
		/*
		for(int i=0; i<rooms.length; i++) {
			if(rooms[i] == null)
				continue;
			if(rooms[i].joiner.contains(onUser)) {
				idx  = i;
				break;
			}
		} 
		*/
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
		
	}

	// 방입장요청처리
	private void enterRequestHandle(int idx) {
		if(rooms[idx] == null) {
			rooms[idx] = new Room(onUser);
			sendRepsonse(rooms[idx]);
			sendAlramToAll("changeRooms");
			currentRoomIdx = idx;
			onUser.room = idx;
		}else {
			boolean f = rooms[idx].enter(onUser);
			if(f) {
				sendRepsonse(rooms[idx]);
				sendAlramToAll("changeRooms");
				currentRoomIdx = idx;
				onUser.room = idx;
			}else {
				sendRepsonse(null);
			}
		}
	}

	private void roomListRequestHandle() {
		sendRepsonse(rooms);	// Room 배열 보내주고 알아서 처리되게.		
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
		// subList에 만들어진 List는 보낼수가 없다고 에러가 뜸. 
		
		List<Message> sub = new ArrayList<>();
		sub.addAll(chatLogs.subList(idx, chatLogs.size()));
		sendRepsonse(sub);
	}
	

	// 응답 보낼때 사용할 것 : 일일이 try - catch 가 힘듬.
	private void sendRepsonse(Object obj) {
		try {
			// ObjectOutputStream 로 출력된 객체는 객체값을 자체적으로 기억을 하게 됨.
			// 만약 출력해야되는 객체가, 이미 출력된 적이 있는 객체면, 그냥 그걸 다시 출력함.
			// 매번 새로운 객체를 출력되게 한다거나
			oos.reset();	// 기억정보를 날림.
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
		// sendRepsonse(ar);	// Object[] 배열로..
		// Vector t = new Vector();
		// t.addAll(connectors);
		// sendResponse(t);
		sendRepsonse(connectors);	// 그냥 관리중인 List보내주고, 알아서 처리하라고 해보자.
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
