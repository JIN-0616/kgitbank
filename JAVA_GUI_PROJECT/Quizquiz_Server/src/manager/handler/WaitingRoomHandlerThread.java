package manager.handler;

import java.util.Map;

import data.network.ServerNetworkStart;
import pregame.waitingRoom.ChatServer;
import pregame.waitingRoom.GameRoomRefreshServer;
import pregame.waitingRoom.RefreshConnectedUsersServer;

public class WaitingRoomHandlerThread extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	WaitingRoomHandler waitingRoomHandler;

	public WaitingRoomHandlerThread(ServerNetworkStart serverNet, Map request, WaitingRoomHandler waitingRoomHandler) {
		this.serverNet = serverNet;
		this.request = request;
		this.waitingRoomHandler = waitingRoomHandler;
	}
	
	@Override
	public void run() {
		String mode = (String)request.get("mode");
		switch(mode) {
		case "chat":
			ChatServer cs = new ChatServer(serverNet, request, waitingRoomHandler);
			cs.start();
			break;
		case "refreshGameRoomList":
			GameRoomRefreshServer grs = new GameRoomRefreshServer(serverNet, request, waitingRoomHandler);
			grs.start();
			break;
		case "refreshConnectedUsers":
			RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(serverNet, request, waitingRoomHandler);
			rcus.start();
			break;
		}
	
	}

}
