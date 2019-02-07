package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import game.CardGameServer;
import manager.handler.WaitingRoomHandler;

public class CreateRoomServer {
	ServerNetworkStart serverNet;
	WaitingRoomHandler handler;
	
	
	public static int SUCCESS = 1031;									//�� ���� �����ڵ� 1031
	public static int FAILED = 1032;									//�� ���� �����ڵ� 1032
	ListManager createdGameRoom;
	GameRoom gameRoom;
	
	// ��Ʈ��ũ ����
	public Map<String, Object> request;

	public CreateRoomServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) { 	// ������
		this.serverNet = serverNet;
		this.request = request;
		this.handler = handler;
	}

	public void createRoom(Map<String, Object> request) {				//createRoom �޼ҵ�	
		Map<String, Object> response = new Hashtable<String, Object>();
		String game = (String) request.get("game");
			switch (game) {												//game ��忡 ���� �۵�
			case "bingo": {												//bingo ���
				if (ListManager.gameRoomsCreated.size() == 6) {			//�� ������ 6���� ��� ���̻� ����� �����Ƿ� ������ �ʰ� ����� ����
					response.put("mode", "createGameRoom");
					response.put("game", game);
					response.put("bingo", gameRoom);
					response.put("result", FAILED);
				} else {					
				//���� ���� �� �ִ� ��� �� ����
				gameRoom = new GameRoom(3);
				// ������ ����
				String title = (String) request.get("title");
				gameRoom.title = title;
				// �濡 �ִ� ���� ������ �ڽ��� �߰�
				gameRoom.joinedUsers.put(serverNet.user, 0);
				ListManager.gameRoomsCreated.put(gameRoom.roomNumber, gameRoom);
				System.out.println("[CREATEROOM-SERVER] bingoRoom:" + gameRoom + " " + gameRoom.roomNumber);
				System.out.println("[CREATEROOM-SERVER] bingoRoom joineduser null?:" + (gameRoom.joinedUsers == null));
				serverNet.user.isOwner = true;
				// ������ ���ӹ濡 ���ٰ� �˷��ش�
				serverNet.user.gameRoom = gameRoom;
				serverNet.user.location = User.inGameRoom;								
				
				
				
				
				response.put("mode", "createGameRoom");
				response.put("game", game);
				response.put("bingo", gameRoom);
				response.put("result", SUCCESS);

				}
			}
			break;
			case "card": {												//card ���
				if (createdGameRoom.gameRoomsCreated.size() == 6) {			//�� ���� 6������ Ȯ��
					response.put("mode", "createGameRoom");
					response.put("game", "card");
					response.put("bingo", gameRoom);
					response.put("result", FAILED);
				} else {													//���� ���� �� �ִ� ��� �� ����
					gameRoom = new GameRoom(3);
					gameRoom.joinedUsers.put(serverNet.user, 0);
					ListManager.gameRoomsCreated.put(gameRoom.roomNumber, gameRoom);
					serverNet.user.isOwner = true;
					serverNet.user.location = User.inGameRoom;
					serverNet.user.gameRoom = gameRoom;
				
					// ī����� ���� ��ŸƮ
					CardGameServer cg = new CardGameServer();
					cg.start();					
					response.put("mode", "createGameRoom");
					response.put("game", "card");
					response.put("bingo", gameRoom);
					response.put("result", SUCCESS);
//					response.put("result", FAILED);
				}
			}
			break;
		}
		//switch
		try {
			//����� ����
			serverNet.oos.writeObject(response);
			System.out.println("[CreateRoomServer] response sent to " + serverNet.user.id);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ���濡 �ִ� ����鿡�� �� ����Ʈ ���ΰ�ħ
		System.out.println("[CREATEROOMSEVER] refresh action");
		ListManager.usersInWaitingRoom.remove(handler);
		System.out.println("[CREATEROOMSERVER] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
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
