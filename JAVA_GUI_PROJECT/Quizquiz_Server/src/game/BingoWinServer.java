package game;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.BingoGameRoomRequestHandler;

public class BingoWinServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	BingoGameRoomRequestHandler bingoGameRoomRequestHandler;

	public BingoWinServer(ServerNetworkStart serverNet, Map request,
			BingoGameRoomRequestHandler bingoGameRoomRequestHandler) {
		
		this.serverNet = serverNet;
		this.request = request;
		this.bingoGameRoomRequestHandler = bingoGameRoomRequestHandler;
	}
	
	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			bingoWin(request);			
		}
	}
		
	public void bingoWin(Map<String, Object> request)  {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "bingoWin");
		response.put("user", serverNet.user);
		
		serverNet.user.gameRoom.isStarted = false;
		
		for (BingoGameRoomRequestHandler h : ListManager.gameRoomChannels.get(serverNet.user.gameRoom)) {
			try {
				response.put("talker", serverNet.user.nickname);
				h.serverNet.oos.writeObject(response);
				System.out.println(h.serverNet.user.nickname + "Àü¼Û");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ListManager.gameRoomChannels.put(serverNet.user.gameRoom, ListManager.gameRoomChannels.get(serverNet.user.gameRoom));

	}

}
