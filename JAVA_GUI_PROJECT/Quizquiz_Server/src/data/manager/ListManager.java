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

	// 로그인 된 유저 리스트
	public static List<LoginServer> usersLoggedIn;
	static {
		usersLoggedIn = new Vector<LoginServer>();
	}
	
	
	// 대기방에 있는 유저 리스트
	public static List<WaitingRoomHandler> usersInWaitingRoom;
	static {
		usersInWaitingRoom = new Vector<WaitingRoomHandler>();
	}
	
	// 생성된 게임방 리스트
	public static Map<Integer,GameRoom> gameRoomsCreated;
	static {
		gameRoomsCreated = new Hashtable<Integer,GameRoom>();
	}
		
	// 게임방과 해당 게임방안에 있는 유저들의 핸들러 정보
	public static Map<GameRoom, List<BingoGameRoomRequestHandler>> gameRoomChannels;
	static {
		gameRoomChannels = new Hashtable<GameRoom, List<BingoGameRoomRequestHandler>>();
	}
	
}
