package pregame.waitingRoom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.WaitingRoomHandler;

/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * 대기방에서 게임방 리스트를 새로고침 요청을 처리해주는 서버
 *
 */

public class GameRoomRefreshServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	WaitingRoomHandler handler;
	
	// 리프레쉬 성공 및 실패
	public static int SUCCESS = 2021;
	public static int FAILED = 2022;
		
	public GameRoomRefreshServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) {
		this.serverNet = serverNet;	
		this.request = request;
		this.handler = handler;
	}
	

	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			gameRoomListRefresh();
		}
	}
	
//	private void gameRoomListRefresh(Map<String, Object> request) {
//		Map<String, Object> response = new Hashtable<String, Object>();
//		response.put("mode", "refreshGameRoomList");
//		
//		Map<Integer, GameRoom> cGRL = ListManager.gameRoomsCreated;
//		
//		response.put("gameRoomList", cGRL);
//		if (cGRL == null || cGRL.isEmpty()) {
//			response.put("result", false);
//		} else {
//			response.put("reuslt", true);
//		}
//			
//		try {
//			serverNet.oos.writeObject(response);
//			System.out.println("[GAMERoomREFRESH-SERVER] response sent" + response.get("result"));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void gameRoomListRefresh() {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "refreshGameRoomList");
		
		
		Map<Integer, GameRoom> cGRL = ListManager.gameRoomsCreated;
		System.out.println("[GAMEROOM REFRESH SERVER] cGRL null? : " + (cGRL == null));
		System.out.println("[GAMEROOM REFRESH SERVER] cGRL size : " + cGRL.size());
		
		Set<Entry<Integer, GameRoom>> cGRLSet = cGRL.entrySet();
		for (Entry<Integer, GameRoom> e : cGRLSet) {
			if (cGRL.get(e.getKey()).joinedUsers.size() == 0) {
				cGRL.remove(e.getKey());
			}
		}
		
		response.put("gameRoomList", cGRL);
		if (cGRL == null || cGRL.isEmpty()) {
			response.put("result", false);
		} else {
			response.put("result", true);
		}
			
		try {
			serverNet.oos.reset();
			serverNet.oos.writeObject(response);
			System.out.println("[GAMERoomREFRESH-SERVER] response sent " + serverNet.user.id + response.get("result"));
			System.out.println("[GAMERoomREFRESH-SERVER] cGRL size " + cGRL.size());
			System.out.println("[GAMERoomREFRESH-SERVER] cGRL sent size " + ((Map)response.get("gameRoomList")).size());
			System.out.println("[GAMERoomREFRESH-SERVER] cGRL :  " + ((Map)response.get("gameRoomList")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
			
		}
	}
	
	
}
