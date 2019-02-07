package game;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.BingoGameRoomRequestHandler;

public class BingoGameActionServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	BingoGameRoomRequestHandler bingoGameRoomRequestHandler;

	public BingoGameActionServer(ServerNetworkStart serverNet, Map request,
			BingoGameRoomRequestHandler bingoGameRoomRequestHandler) {

		this.serverNet = serverNet;
		this.request = request;
		this.bingoGameRoomRequestHandler = bingoGameRoomRequestHandler;
	}
	
	@Override
	public void run() {
		Map<String, Object> response = new Hashtable<String, Object>();
		// Request has
		// 1. "mode" : "bingoGameAction"
		// 2. "index" : integer => 숫자 몇을 눌렀는지
		response.put("mode", "bingoGameAction");
		response.put("index", (String)request.get("index"));
		response.put("bingoNumber", (int)request.get("bingoNumber"));
		response.put("user", serverNet.user);
		int turn = serverNet.user.gameRoom.joinedUsers.get(serverNet.user);
		System.out.println("[BingoGameActionServer] room size " + serverNet.user.gameRoom.joinedUsers.size());
		// serverNet이 들어가는 모든 객체에는 아래 값이 변한다
		// 그 말은 즉 : 밑에 list에서 serverNet을 get해도 변해져 있을 것이다
		serverNet.user.myTurn = false;
		System.out.println("[BingoGameActionServer] it was turn to : " + turn);
		turn = (turn + 1)%serverNet.user.gameRoom.joinedUsers.size();
		System.out.println("[BingoGameActionServer] it's turn to : " + turn);
		
		response.put("turnIndex", turn);
		
		
		List<BingoGameRoomRequestHandler> list = ListManager.gameRoomChannels.get(serverNet.user.gameRoom);
		
		for (int i=0; i<list.size(); i++) {
			ServerNetworkStart userNet = list.get(i).serverNet;
			if (userNet.user.gameRoom.joinedUsers.get(userNet.user) == turn) {
				userNet.user.myTurn = true;
			}
//			response.put("user", userNet.user);
			try {
				list.get(i).serverNet.oos.reset();
				list.get(i).serverNet.oos.writeObject(response);
				System.out.println("[GAME-GAMEACTION] sent to " + list.get(i).serverNet.user.id);
			} catch (IOException e) {
				System.out.println("[GAME-GAMEACTION] [FAILED]  sent to " + list.get(i).serverNet.user.id);
				e.printStackTrace();
			}
		}
	}

}
