package data.manager;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import data.gameRoom.GameRoom;
import manager.handler.BingoGameRoomRequestHandler;
import manager.handler.WaitingRoomHandler;
import pregame.login.LoginServer;

public class ListManager {

	// �α��� �� ���� ����Ʈ
	public static List<LoginServer> usersLoggedIn;
	static {
		usersLoggedIn = new Vector<LoginServer>();
	}
	
	
	// ���濡 �ִ� ���� ����Ʈ
	public static List<WaitingRoomHandler> usersInWaitingRoom;
	static {
		usersInWaitingRoom = new Vector<WaitingRoomHandler>();
	}
	
	// ������ ���ӹ� ����Ʈ
	public static Map<Integer,GameRoom> gameRoomsCreated;
	static {
		gameRoomsCreated = new Hashtable<Integer,GameRoom>();
	}
		
	// ���ӹ�� �ش� ���ӹ�ȿ� �ִ� �������� �ڵ鷯 ����
	public static Map<GameRoom, List<BingoGameRoomRequestHandler>> gameRoomChannels;
	static {
		gameRoomChannels = new Hashtable<GameRoom, List<BingoGameRoomRequestHandler>>();
	}
	
}
