package pregame.waitingRoom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import manager.handler.BingoGameRoomRequestHandler;
import manager.handler.WaitingRoomHandler;

/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * ���濡�� ���ӹ� ���ӽ� ��û�� ó�����ִ� ����
 *
 */

public class GameRoomJoinServer {
	ServerNetworkStart serverNet;
	Map request;
	WaitingRoomHandler handler;
		
	// ���� ���� �� ����
	public static int SUCCESS = 2011;
	public static int FAILED = 2012;
	
	// ������
	public GameRoomJoinServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) {
		this.serverNet = serverNet;	
		this.request = request;	
		this.handler = handler;
	}
	

//		if () {
//			WaitingRoomServer.usersInWaitingRoom.remove(user);			
//		}

		// �α��� �޼ҵ�
		/* 
		 * �α��� �� : 
		 */
	public void joinGameRoom(Map request) {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "joinGameRoom");
		int result = 0;
		
		GameRoom gameRoom = (GameRoom)request.get("gameRoom");
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom null? : " + (gameRoom == null));
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom room number : " + gameRoom.roomNumber);
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom started? : " + gameRoom.isStarted);
		
		Map<Integer, GameRoom> cGRL = ListManager.gameRoomsCreated;

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���� ���ӹ��� ������ �Ǿ��ְ� �� ������ ������
		// ����
		if (cGRL.containsValue(gameRoom) && gameRoom.isFull == false && gameRoom.isStarted == false) {
			GameRoom gameRoomToManage = ListManager.gameRoomChannels.get(gameRoom).get(0).gameRoom;
			// ���ӹ濡 ���� ������ �Է� ������ && �������� ������
			for (int i=0; i<3; i++) {
				System.out.println("[GAMEROOM JOIN SERVER] join iteration: " + i + "th.\n "
						+ "user yes? : " + (gameRoomToManage.joinedUsers.containsValue(i)));

				if (gameRoomToManage.joinedUsers.containsValue(i) == false) {
					System.out.println("[GAMEROOM JOIN SERVER] adding user started " + serverNet.user.id);
					// ���� ä�� ���� �ʿ� ����
					gameRoomToManage.joinedUsers.put(serverNet.user, i);
					System.out.println("[GAMEROOM JOIN SERVER] gameRoomToManage user added " + serverNet.user.id);
					System.out.println("[GAMEROOM JOIN SERVER] gameRoomToManage : " + gameRoomToManage.joinedUsers);
//					// ������ ���� ����Ʈ �ʿ� ����
//					cGRL.get(gameRoom.roomNumber).joinedUsers.put(serverNet.user, i);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
//					// �������� ���� ���ӹ� ������ ����
//					gameRoom.joinedUsers.put(serverNet.user, i);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
					
					break;
				}
				
			}
			//for
			
			// ������ ���� ����Ʈ �ʿ� ����
			cGRL.get(gameRoom.roomNumber).joinedUsers = gameRoomToManage.joinedUsers;
			System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
			System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
			// �������� ���� ���ӹ� ������ ����
			gameRoom.joinedUsers = gameRoomToManage.joinedUsers;
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom user added " + serverNet.user.id);
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom :  " + gameRoom.joinedUsers);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom joined users list : " + gameRoom.joinedUsers);
			
			// ���ӹ濡 ���� �߰���, ���ӹ� ���� ����
			if (gameRoom.joinedUsers.size() == gameRoom.maxPlayers) {
				System.out.println("[GAMEROOM JOIN SERVER] setFull started");
				gameRoomToManage.isFull = true;
				cGRL.get(gameRoom.roomNumber).isFull = true;
				gameRoom.isFull = true;
			}
			// ���� ����Ʈ���� �������� ����
			ListManager.usersInWaitingRoom.remove(handler);
			serverNet.user.location = User.inGameRoom;
			serverNet.user.gameRoom = gameRoom;
			result = SUCCESS;
			response.put("result", result);
			System.out.println("[GAMERoom-SERVER] ok join gameRoom Number " + gameRoom.roomNumber);
		}
		// �ƴҰ��
		else {
			result = FAILED;
			response.put("result", result);
		}
		
		// ���ӹ� �� ���ӷ� ����Ʈ�� �����ش�
		response.put("gameRoom", gameRoom);
		response.put("gameRoomList", cGRL);
			
		try {
			serverNet.oos.writeObject(response);
			System.out.println("[GAMERoomJOIN-SERVER] response sent" + response.get("result"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == SUCCESS) {
			// ������ ���濡�� ������ ��
			ListManager.usersInWaitingRoom.remove(handler);
			
			// �ش� ���ӹ濡 �ִ� ����鿡�� ��� ���ٴ°��� �˷���
			System.out.println("[GAMERoomJOIN-SERVER] game joined notice");
			List<BingoGameRoomRequestHandler> listUsersInGameRoom = ListManager.gameRoomChannels.get(gameRoom);
			response = new Hashtable<String, Object>();
			response.put("mode", "gameRoomUsersModified");
			response.put("gameRoom", gameRoom);
			response.put("newUser", serverNet.user);
			System.out.println("[GAMERoomJOIN-SERVER] gameRoom joinedUsers : " + gameRoom.joinedUsers);
			for (BingoGameRoomRequestHandler h : listUsersInGameRoom) {
				if (h.serverNet.equals(this.serverNet) == false) {
					try {
						h.serverNet.oos.reset();
						h.serverNet.oos.writeObject(response);
						System.out.println("[GAMERoomJOIN-SERVER] new user joined data sent to " + h.serverNet.user.id);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			// for
		}
		// if
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���濡 �ִ� ����鿡�� �� ����Ʈ ���ΰ�ħ
		System.out.println("[GAMERoomJOIN-SERVER] refresh action");
		System.out.println("[GAMERoomJOIN-SERVER] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			GameRoomRefreshServer grs = new GameRoomRefreshServer(h.serverNet, null, h);
			grs.gameRoomListRefresh();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(h.serverNet, null, h);
			rcus.refreshConnectedUsers();
		}
		
	}
	
	
	
}
