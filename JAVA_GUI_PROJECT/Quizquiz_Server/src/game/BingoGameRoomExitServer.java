package game;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import manager.handler.BingoGameRoomRequestHandler;
import manager.handler.WaitingRoomHandler;
import pregame.waitingRoom.GameRoomRefreshServer;

public class BingoGameRoomExitServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	BingoGameRoomRequestHandler bingoGameRoomRequestHandler;
	

	public BingoGameRoomExitServer(ServerNetworkStart serverNet, Map request,
			BingoGameRoomRequestHandler bingoGameRoomRequestHandler) {
		
		this.serverNet = serverNet;
		this.request = request;
		this.bingoGameRoomRequestHandler = bingoGameRoomRequestHandler;
	}
	
	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			bingoGameRoomExit(request);			
		}
	}


	private void bingoGameRoomExit(Map<String, Object> request) {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "bingoGameRoomExit");

		List<BingoGameRoomRequestHandler> list = ListManager.gameRoomChannels.get(serverNet.user.gameRoom);
		GameRoom listManagerGameRoom = ListManager.gameRoomsCreated.get(serverNet.user.gameRoom.roomNumber);
		listManagerGameRoom.joinedUsers.remove(serverNet.user);
		serverNet.user.gameRoom.joinedUsers.remove(serverNet.user);
		
		// isFull?
		if (listManagerGameRoom.isFull) {
			listManagerGameRoom.isFull = false;
			serverNet.user.gameRoom.isFull = false;
			list.get(0).gameRoom.isFull = false;
		}
		
		
		System.out.println("[BingoGameExitServer] " + serverNet.user.id + " quitted the gameRoom " + serverNet.user.gameRoom.roomNumber);
		serverNet.user.gameRoom = null;
		serverNet.user.location = User.inWaitingRoom;
		
		response.put("user", serverNet.user);
		
		// 빙고룸 안에 있는 사람들에게 정보를 보내줌
		for (int i=0; i<list.size(); i++) {
			try {
				list.get(i).serverNet.oos.writeObject(response);
				System.out.println("[BingoGameExitServer] sent to " + list.get(i).serverNet.user.id);
			} catch (IOException e) {
				System.out.println("[BingoGameExitServer] [FAILED] sent to " + list.get(i).serverNet.user.id);
				e.printStackTrace();
			}				
		}		
		list.remove(bingoGameRoomRequestHandler);
		
		if (serverNet.user.isOwner) {
			serverNet.user.isOwner = false;
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		
		// 대기방에 있는 사람들에게 방 리스트 새로고침
		System.out.println("[BINGOGAMERROM-EXIT] refresh action");
		System.out.println("[BINGOGAMERROM-EXIT] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			GameRoomRefreshServer grs = new GameRoomRefreshServer(h.serverNet, null, h);
			grs.gameRoomListRefresh();					
		}
		
		
	}

}
