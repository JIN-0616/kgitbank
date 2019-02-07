package manager.handler;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import game.BingoChatServer;
import game.BingoGameActionServer;
import game.BingoGameRoomExitServer;
import game.BingoWinServer;
import game.GameStartTellingServer;

public class BingoGameRoomRequestHandler {
	public ServerNetworkStart serverNet;
	
	public GameRoom gameRoom;
	public List<BingoGameRoomRequestHandler> usersInThisGameRoom; 
	
	public BingoGameRoomRequestHandler(ServerNetworkStart serverNet) {
		this.serverNet = serverNet;
		this.gameRoom = serverNet.user.gameRoom;
		
		if (!ListManager.gameRoomChannels.containsKey(gameRoom)) {
			usersInThisGameRoom = new Vector<BingoGameRoomRequestHandler>();
			usersInThisGameRoom.add(this);
			
			ListManager.gameRoomChannels.put(gameRoom, usersInThisGameRoom);
		} else {
			usersInThisGameRoom = ListManager.gameRoomChannels.get(gameRoom);
			usersInThisGameRoom.add(this);
			
			ListManager.gameRoomChannels.put(gameRoom, usersInThisGameRoom);
		}
		
	}
	
	public void bingoGameRoomRequestHandler(Map request) {
		String mode = (String)request.get("mode");
		System.out.println("[BingoGAMEROOM-Handler] mode " + mode);
		switch(mode) {
		// ���ӹ�ȿ��� ä�� �Ҷ�
		case "bingoChat":
			BingoChatServer bcs = new BingoChatServer(serverNet, request, this);
			bcs.start();
			break;
		// ������ �����϶� ������ ��ȣ
		case "bingoWin":
			BingoWinServer bws = new BingoWinServer(serverNet, request, this);
			bws.start();
			break;
			
			// ���� ����������	
		case "gameStart":
			GameStartTellingServer gsts = new GameStartTellingServer(serverNet, request, this);
			gsts.start();
			break;
			// ������ ������ӿ� ���� �׼� ó��
		case "bingoGameAction":
			// Turn�� ����� Action�� �޾���
			if (serverNet.user.myTurn) {
				BingoGameActionServer bgas = new BingoGameActionServer(serverNet, request, this);
				bgas.start();				
			} else {
				System.out.println("[BINGO-ACTION] user " + serverNet.user.id + " is not allowed to play.");
			}
			break;
		
		// ������ ���ӹ��� ������
		case "bingoGameRoomExit":
			BingoGameRoomExitServer bge = new BingoGameRoomExitServer(serverNet, request, this);
			bge.start();
			break;
		default: 
			break;
		}
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		BingoGameRoomRequestHandler otherH = (BingoGameRoomRequestHandler) obj;
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
