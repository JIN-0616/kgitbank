package game;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.BingoGameRoomRequestHandler;
import manager.handler.WaitingRoomHandler;
import pregame.waitingRoom.GameRoomRefreshServer;

public class GameStartTellingServer extends Thread {
	public ServerNetworkStart serverNet;
	public  Map request;
	BingoGameRoomRequestHandler bingoGameRoomRequestHandler;

	public GameStartTellingServer(ServerNetworkStart serverNet, Map request,
			BingoGameRoomRequestHandler bingoGameRoomRequestHandler) {
		
		this.serverNet = serverNet;
		this.request = request;
		this.bingoGameRoomRequestHandler = bingoGameRoomRequestHandler;
	}
	
	
	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			gameStartTelling(request);
		}
	}


	private void gameStartTelling(Map<String, Object> request) {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "gameStartTelling");
		response.put("start", true);

		List<BingoGameRoomRequestHandler> list = ListManager.gameRoomChannels.get(serverNet.user.gameRoom);
		list.get(0).serverNet.user.myTurn = true;
		list.get(0).serverNet.user.gameRoom.isStarted = true;
		ListManager.gameRoomsCreated.get(serverNet.user.gameRoom.roomNumber).isStarted = true;
		
		for (int i=0; i<list.size(); i++) {
			try {
				list.get(i).serverNet.oos.writeObject(response);
				System.out.println("[GAME-START-TELLING] started sent to " + list.get(i).serverNet.user.id);
			} catch (IOException e) {
				System.out.println("[GAME-START-TELLING] [FAILED] started sent to " + list.get(i).serverNet.user.id);
				e.printStackTrace();
			}
		}
		
		// 대기방에 있는 사람들에게 방 리스트 새로고침
		System.out.println("[BINGO-Room- Start] refresh action");
		System.out.println("[BINGO-Room- Start] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			GameRoomRefreshServer grs = new GameRoomRefreshServer(h.serverNet, null, h);
			grs.gameRoomListRefresh();					
		}
		
	}

}
