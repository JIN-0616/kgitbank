package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import data.gameRoom.GameRoom;
import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import data.user.User;
import game.bingo.BingoGameHandler;
import ui.game.bingo.BingoRoomUI;
import ui.game.bingo.BingoUserInfo;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class WrGameRoomJoinNetwork {
	ClientNetworkInfo clientNetwork;
	Map response;
	WaitingRoomUI waitingRoomUI;
	BingoRoomUI bingoRoomUI;
	
	// 로그인 성공 및 실패
	public static int SUCCESS = 2011;
	public static int FAILED = 2012;

	// 리스너를 위한 생성자
	public WrGameRoomJoinNetwork(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	// 요청을 보내고 서버로부터 답장을 받는 쓰레드

	public void gameRoomJoin(Map response) {
		int result = (int) response.get("result");
		if (result == SUCCESS) {
			JOptionPane.showMessageDialog(waitingRoomUI, "게임방 조인 성공");
			
			waitingRoomUI.dispose();
			waitingRoomUI.setVisible(false);
			
			GameRoom gameRoom = (GameRoom) response.get("gameRoom");
			clientNetwork.user.gameRoom = gameRoom;
			
			ClientListManager.gameRoomsCreated.put(gameRoom.roomNumber, gameRoom);
			Map<User,Integer> serverResponseJoinedUsers = gameRoom.joinedUsers;
			System.out.println("[WrGameRoomJoinNet] gameRoom null? :" + (gameRoom == null));
			System.out.println("[WrGameRoomJoinNet] serverResponseJoindeUsers :" + serverResponseJoinedUsers);
			
			
			gameRoom = ClientListManager.gameRoomsCreated.get(gameRoom.roomNumber);
			gameRoom.joinedUsers = serverResponseJoinedUsers;
			
			// User가 게임방에 들어갔다고 알려준다
			clientNetwork.user.location = User.inGameRoom;

			bingoRoomUI = new BingoRoomUI(clientNetwork, gameRoom);
			bingoRoomUI.setVisible(true);
			
	        BingoGameHandler bgh = new BingoGameHandler(clientNetwork,bingoRoomUI);
	        bgh.start();
			
			Set<Entry<User, Integer>> nJULSet = serverResponseJoinedUsers.entrySet();
			for (Entry<User, Integer> e : nJULSet) {
				if (!clientNetwork.user.equals(e.getKey())) {
					User newUser = e.getKey();
					int index = e.getValue();
					
					
					if (bingoRoomUI.panelUser2 == null) {
						bingoRoomUI.panelUser2 = new BingoUserInfo(newUser);
						bingoRoomUI.panelUser2.setBounds(487, 89, 200, 200);
						bingoRoomUI.add(bingoRoomUI.panelUser2);
						
						bingoRoomScreenImageRefresh();
						
					} else if (bingoRoomUI.panelUser3 == null) {
						bingoRoomUI.panelUser3 = new BingoUserInfo(newUser);
						bingoRoomUI.panelUser3.setBounds(749, 89, 200, 200);
						bingoRoomUI.add(bingoRoomUI.panelUser3);
						
						bingoRoomScreenImageRefresh();
					}
				}
				// if
			}
			// for
			bingoRoomUI.revalidate();
			bingoRoomUI.repaint();
			
			
			
			
			
		} else if (result == FAILED) {
			JOptionPane.showMessageDialog(waitingRoomUI, "게임방 조인 실패");
		}
		
	}

	
	// 요청할대 사용되는 생성자
	public WrGameRoomJoinNetwork(ClientNetworkInfo clientNetwork) {
		this.clientNetwork = clientNetwork;
	}
	
	// 게임방에 참가하고 싶을때 서버에 요청을 보낼때 사용되는 메소드.
	// UI에서 불러온다
	public boolean sendJoinGameRoom (GameRoom gameRoom) {
		Map<String, Object> request = new Hashtable<String, Object>();
		request.put("mode", "joinGameRoom");
		request.put("gameRoom", gameRoom);
		try {
			clientNetwork.oos.writeObject(request);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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
