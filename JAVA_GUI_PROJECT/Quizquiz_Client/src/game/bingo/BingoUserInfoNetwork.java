package game.bingo;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Set;

import data.gameRoom.GameRoom;
import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import data.user.User;
import ui.game.bingo.BingoRoomUI;
import ui.game.bingo.BingoUserInfo;

public class BingoUserInfoNetwork extends Thread {
	ClientNetworkInfo clientNetwork;
	Map response;
	BingoRoomUI bingoRoomUI;
	
	
	public BingoUserInfoNetwork(ClientNetworkInfo clientNetwork, Map response, BingoRoomUI bingoRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.bingoRoomUI = bingoRoomUI;
	}
	
	@Override
	public void run() {
		if (clientNetwork.socket.isBound()) {
			bingoUserInfoNetwork(response);
		}
	}

	public void bingoUserInfoNetwork(Map response) {
		System.out.println("[BingoUserInfoNet] response got: " + response);
		GameRoom gameRoom = (GameRoom) response.get("gameRoom");
		System.out.println("[BingoUserInfoNet] gameRoom got : " + gameRoom);
		System.out.println("[BingoUserInfoNet] gameRoom got joinedUsers : " + gameRoom.joinedUsers);
		
		User newUser = (User)response.get("newUser");
		if (bingoRoomUI.panelUser2 == null) {
			bingoRoomUI.panelUser2 = new BingoUserInfo(newUser);
			bingoRoomUI.panelUser2.setOpaque(false);
			bingoRoomUI.panelUser2.setBounds(487, 89, 200, 200);
			bingoRoomUI.add(bingoRoomUI.panelUser2);
			
			bingoRoomScreenImageRefresh();
			
		} else if (bingoRoomUI.panelUser3 == null) {
			bingoRoomUI.panelUser3 = new BingoUserInfo(newUser);
			bingoRoomUI.panelUser2.setOpaque(false);
			bingoRoomUI.panelUser3.setBounds(749, 89, 200, 200);
			bingoRoomUI.add(bingoRoomUI.panelUser3);
			
			bingoRoomScreenImageRefresh();
		}

		
		
		bingoRoomUI.revalidate();
		bingoRoomUI.repaint();
		gameRoom = ClientListManager.gameRoomsCreated.get(gameRoom.roomNumber);
		clientNetwork.user.gameRoom = gameRoom;
		
//		Map<User,Integer> serverResponseJoinedUsers = gameRoom.joinedUsers;
//		System.out.println("[BingoUserInfoNet] gameRoom null? :" + (gameRoom == null));
//		System.out.println("[BingoUserInfoNet] serverResponseJoindeUsers :" + serverResponseJoinedUsers);
//		
//		System.out.println(ClientListManager.gameRoomsCreated);
//		System.out.println("[BingoUserInfoNet] gameRoom null? : " + (gameRoom == null));
//		gameRoom.joinedUsers = serverResponseJoinedUsers;
//		System.out.println("[BingouserInfoNet] user " + clientNetwork.user.id + " gameRoom joinedUsers : " + gameRoom.joinedUsers);
//		
//		System.out.println("[BingouserInfoNet] user gameRoom : " + clientNetwork.user.gameRoom.joinedUsers);
//		
//		
//		
//		Set<Entry<User, Integer>> nJULSet = serverResponseJoinedUsers.entrySet();
//		for (Entry<User, Integer> e : nJULSet) {
//			if (!clientNetwork.user.gameRoom.joinedUsers.containsKey(e.getKey())) {
//				User newUser = e.getKey();
//
//				if (bingoRoomUI.panelUser2 == null) {
//					bingoRoomUI.panelUser2 = new BingoUserInfo(newUser);
//					bingoRoomUI.panelUser2.setBounds(487, 89, 200, 200);
//					bingoRoomUI.add(bingoRoomUI.panelUser2);
//				} else if (bingoRoomUI.panelUser3 == null) {
//					bingoRoomUI.panelUser3 = new BingoUserInfo(newUser);
//					bingoRoomUI.panelUser3.setBounds(749, 89, 200, 200);
//					bingoRoomUI.add(bingoRoomUI.panelUser3);
//				}
//			}
//			// if
//		}
//		// for
		
	}
	
	private void bingoRoomScreenImageRefresh() {
		if (bingoRoomUI.bingoScreen != null) {
			bingoRoomUI.remove(bingoRoomUI.bingoScreen);
			bingoRoomUI.bingoScreen = new JLabel("");
			bingoRoomUI.bingoScreen.setIcon(new ImageIcon("src\\image\\\uBE59\uACE0\uB8F82.jpg"));
			bingoRoomUI.bingoScreen.setOpaque(false);
			bingoRoomUI.bingoScreen.setBounds(0, 0, 994, 671);
			bingoRoomUI.getContentPane().add(bingoRoomUI.bingoScreen);			
		}
	}
	
	

}
