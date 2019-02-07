package manager.handler;

import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import pregame.waitingRoom.ChatServer;
import pregame.waitingRoom.CreateRoomServer;
import pregame.waitingRoom.GameRoomJoinServer;
import pregame.waitingRoom.GameRoomRefreshServer;
import pregame.waitingRoom.RefreshConnectedUsersServer;


/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * 대기방에서 클라이언트 요청을 듣는 헨들러(서버)
 *
 */

public class WaitingRoomHandler {
	public ServerNetworkStart serverNet;
	
	WaitingRoomHandlerThread wrhThread;
	
	// 생성자
	public WaitingRoomHandler(ServerNetworkStart serverNet) {
		this.serverNet = serverNet;
		
		// 로그인이 됬으니까 대기방으로 이동 : 대기방 리스트에 추가
		ListManager.usersInWaitingRoom.add(this);
		System.out.println("users in waitingroom number : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
		}
		
		// 대기방 게임방 리스트 리프레쉬
		GameRoomRefreshServer grrs = new GameRoomRefreshServer(serverNet, null, this);
		grrs.gameRoomListRefresh();
		
		// 대기방에 있는 사람들에게 이 유저가 들어왔다고 알려준다
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(h.serverNet, null, h);
			rcus.refreshConnectedUsers();
		}
	}
	
	
	
	// 대기방에서 채팅, 게임방접속, 게임방 refresh, 게임방 만들기 
	
	public void waitingRoomRequestHandler(Map request) {
		String mode = (String)request.get("mode");
		System.out.println("[WAITINGROOM-SERVER] mode " + mode);
		switch(mode) {
		case "joinGameRoom":
			GameRoomJoinServer gs = new GameRoomJoinServer(serverNet, request, this);
			gs.joinGameRoom(request);;
			break;
		case "createRoom":
			CreateRoomServer crs = new CreateRoomServer(serverNet, request, this);
			crs.createRoom(request);;
			break;
		default:
			WaitingRoomHandlerThread wrhThread = new WaitingRoomHandlerThread(serverNet, request, this);
			wrhThread.start();
			break;
		}
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		WaitingRoomHandler otherH = (WaitingRoomHandler) obj;
		if (this.serverNet.user.equals(otherH.serverNet.user)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return serverNet.user.hashCode();
	}
	
	
	
}
