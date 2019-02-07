package data.manager;

import java.util.Hashtable;
import java.util.Map;

import data.gameRoom.GameRoom;

public class ClientListManager {
	public static Map<Integer,GameRoom> gameRoomsCreated;	
	static {
		gameRoomsCreated = new Hashtable<Integer,GameRoom>();
	}
}
