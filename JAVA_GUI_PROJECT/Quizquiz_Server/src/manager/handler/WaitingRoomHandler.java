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
 * ���濡�� Ŭ���̾�Ʈ ��û�� ��� ��鷯(����)
 *
 */

public class WaitingRoomHandler {
	public ServerNetworkStart serverNet;
	
	WaitingRoomHandlerThread wrhThread;
	
	// ������
	public WaitingRoomHandler(ServerNetworkStart serverNet) {
		this.serverNet = serverNet;
		
		// �α����� �����ϱ� �������� �̵� : ���� ����Ʈ�� �߰�
		ListManager.usersInWaitingRoom.add(this);
		System.out.println("users in waitingroom number : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
		}
		
		// ���� ���ӹ� ����Ʈ ��������
		GameRoomRefreshServer grrs = new GameRoomRefreshServer(serverNet, null, this);
		grrs.gameRoomListRefresh();
		
		// ���濡 �ִ� ����鿡�� �� ������ ���Դٰ� �˷��ش�
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(h.serverNet, null, h);
			rcus.refreshConnectedUsers();
		}
	}
	
	
	
	// ���濡�� ä��, ���ӹ�����, ���ӹ� refresh, ���ӹ� ����� 
	
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
