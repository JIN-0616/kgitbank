package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalServer extends Thread {
	static boolean[][] map;
	static DatagramSocket alarmSocket; // ��Ŷ���۽� ����� UDP ����
	static List<SocketAddress> addresses;
	static int treasureRow;
	static int treasurCol;
	static {
		map = new boolean[30][30];
		addresses = new ArrayList<>();
		
		treasureRow =(int) (Math.random() * 30);
		treasurCol = (int) (Math.random() * 30);
		
		try {
			alarmSocket = new DatagramSocket();
		} catch (SocketException e) {
			throw new RuntimeException();
		}
	}
	
	private static void sendAlertToAll(String alarm) {
		DatagramPacket p = new DatagramPacket(alarm.getBytes(), alarm.getBytes().length);
		for (SocketAddress addr : addresses) {
			p.setSocketAddress(addr);
			try {
				alarmSocket.send(p);
			} catch (IOException e) {
				System.out.println("[server-Thread] send alarm failed target : " + addr);
			}
		}
	}
	// ===========================================================================================
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	// �� ���������� ������ ��ü�� �˼� �ְ� ������ ��Ƶ�. (�����Ǵ� ������ �Ʒ�)
	int currRow;
	int currCol;

	PersonalServer(Socket soc) {
		socket = soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			addresses.add(socket.getRemoteSocketAddress());
			for(;;) {
				currRow = (int) (Math.random() * 30);
				currCol = (int) (Math.random() * 30);
				if(map[currRow][currCol]!=true && (currRow!=treasureRow) && (currCol != treasurCol)) {
					map[currRow][currCol]=true;
					break;
				}
			}
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public void run() {
		while (!socket.isClosed()) {
			String req;
			try {
				req = (String) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				break;
			}
			String[] reqs = req.split("#");
			switch (reqs[0]) {
			case "status":
				statusRequestHandle();
				break;
			case "move":
				moveRequestHandle(reqs[1]);
			}
		}
	}

	private void moveRequestHandle(String mode) {
		int tRow = currRow;
		int tCol = currCol;
		switch (mode) {
		case "up":
			tRow--;
			break;
		case "down":
			tRow++;
			break;
		case "left":
			tCol--;
			break;
		case "right":
			tCol++;
			break;
		}
		if(tRow >=0 && tRow<30 && tCol>=0 && tCol<30 && map[tRow][tCol]!=true) {
			sendAlertToAll("moved");
			map[currRow][currCol]= false;
			currRow = tRow;
			currCol = tCol;
			map[currRow][currCol]= true;
			if(currRow==treasureRow && currCol== treasurCol) {
				sendAlertToAll("found");
				treasureRow =(int) (Math.random() * 30);
				treasurCol = (int) (Math.random() * 30);
				sendResponse(true);
			}else {
				sendResponse(false);
			}
		}else {
			sendResponse(false);
		}
	}



	private void statusRequestHandle() {
		Map datas = new HashMap<>();
			datas.put("map", map);
			datas.put("currRow", currRow);
			datas.put("currCol", currCol);
		sendResponse(datas);
	}	
	
	private void sendResponse(Object obj) {
		try {
			oos.reset();
			oos.writeObject(obj);
		} catch (IOException e) {
			System.out.println("["+getName()+"] io error");
			stop();
		}
	}

}
