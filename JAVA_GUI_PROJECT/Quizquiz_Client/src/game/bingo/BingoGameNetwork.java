package game.bingo;

import java.awt.Color;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import data.network.ClientNetworkInfo;
import data.user.User;
import ui.game.bingo.BingoRoomUI;

public class BingoGameNetwork extends Thread {

	public ClientNetworkInfo clientNetwork;
	Map response;
	public BingoRoomUI bingoGameUI;
	public String number;
	public static int[] BINGOROW;
	public static int[] BINGOCOL;
	public static int BINGO=0;
	public static int[] DIAGONAL;

	public BingoGameNetwork(ClientNetworkInfo clientNetwork, Map response, BingoRoomUI bingoGameUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.bingoGameUI = bingoGameUI;
	}

	@Override
	public void run() {
		String mode = (String) response.get("mode");
		switch (mode) {
		case "bingoGameAction": {			
			// 자기 턴이면 알려준다
			int turnIndex = (int) response.get("turnIndex");
			if (clientNetwork.user.gameRoom.joinedUsers.get(clientNetwork.user) == turnIndex) {
				clientNetwork.user.myTurn = true;
				bingoGameUI.panelUserOwn.lbUserChar.setIcon(new ImageIcon("src\\image\\char4.png"));
				bingoGameUI.revalidate();
				bingoGameUI.repaint();
			} else {
				clientNetwork.user.myTurn = false;
				bingoGameUI.panelUserOwn.lbUserChar.setIcon(new ImageIcon("src\\image\\char3.png"));
				bingoGameUI.revalidate();
				bingoGameUI.repaint();
			}
			
//			User receivedUser = (User) response.get("user");
//			if (receivedUser.myTurn) {
//				bingoGameUI.panelUserOwn.setOpaque(true);
//				bingoGameUI.panelUserOwn.setBackground(new Color(5, 30, 20));
//			} else {
//				bingoGameUI.panelUserOwn.setBackground(new Color(255, 225, 225));
//				bingoGameUI.panelUserOwn.setOpaque(false);
//			}
			
			String number = (String) response.get("index");
			for (JButton bt : bingoGameUI.panelBingo.tbtList) {
				
				String[] num = (String[]) (bt.getActionCommand().split(","));
				int[] indexNumber = new int[2];
				indexNumber[0] = (int) (Integer.parseInt(num[0]));
				indexNumber[1] = (int) (Integer.parseInt(num[1]));
				
//				System.out.println(bingoGameUI.panelBingo.lbbs[indexNumber[0]][indexNumber[1]]);
				String nums = bingoGameUI.panelBingo.lbbs[indexNumber[0]][indexNumber[1]];
				if (nums.equals(number)) {
					bt.setEnabled(false);
					if(indexNumber[0]==indexNumber[1]) {
						DIAGONAL[0]++;
						if(DIAGONAL[0]==5) {
							BINGO++;
						}
					}
					if((indexNumber[0]+indexNumber[1])==4) {
						DIAGONAL[1]++;
						if(DIAGONAL[1]==5) {
							BINGO++;
						}
					}
					BINGOROW[indexNumber[0]]++;
					if (BINGOROW[indexNumber[0]] == 5) {
						BINGO++;
					}
					BINGOCOL[indexNumber[1]]++;
					if (BINGOCOL[indexNumber[1]] == 5) {
						BINGO++;
					}
				}
				
				if(BINGO>=3 && clientNetwork.user.myTurn) {
					bingoGameWin();
					break;
				}
			}
			//for
			bingoNumberReceive();
			
		}
		break;
		case "gameStartTelling":
			bingoGameUI.btnStart.setEnabled(false);
			String start = "[게임을 시작합니다.]\n";
			// 캐릭터 이미지 변경
			if (clientNetwork.user.gameRoom.joinedUsers.get(clientNetwork.user) == 0) {
				bingoGameUI.panelUserOwn.lbUserChar.setIcon(new ImageIcon("src\\image\\char4.png"));
				bingoGameUI.revalidate();
				bingoGameUI.repaint();
			}
			//
			System.out.println("시작");
			BINGO = 0;
			DIAGONAL = new int[2];
			BINGOROW = new int[5];
			BINGOCOL = new int[5];
			DIAGONAL[0] = 0;
			DIAGONAL[1] = 0;
			for (int i = 0; i < 5; i++) {
				BINGOROW[i] = 0;
				BINGOCOL[i] = 0;
			}
			bingoGameUI.panelChat.taChatLog2.append(start);
			System.out.println(start);
			bingoGameUI.panelChat.taChatLog2.setCaretPosition(bingoGameUI.panelChat.taChatLog2.getText().length());
			break;
		case "bingoWin":
			String talker = (String) response.get("talker");
			bingoGameUI.panelChat.taChatLog2.append(talker + "님이 승리하셨습니다.\n");
			bingoGameUI.panelBingo.tbtList.clear();
			break;
		}
	}

	private void bingoNumberReceive() {
		int bingoNumber = (int)response.get("bingoNumber");
		User receivedUser = (User) response.get("user");
		
		System.out.println("bingoNumber received");
		
		if (clientNetwork.user.equals(receivedUser)) {
			bingoGameUI.panelUserOwn.lbBingoNumber.setText("Bingo : " + bingoNumber);;
			bingoGameUI.panelUserOwn.revalidate();
			bingoGameUI.panelUserOwn.repaint();
		} else {
			if (bingoGameUI.panelUser2.user.equals(receivedUser)) {
				bingoGameUI.panelUser2.lbBingoNumber.setText("Bingo : " + bingoNumber);;
				bingoGameUI.panelUser2.revalidate();
				bingoGameUI.panelUser2.repaint();
			} else if (bingoGameUI.panelUser3.user.equals(receivedUser)) {
				bingoGameUI.panelUser3.lbBingoNumber.setText("Bingo : " + bingoNumber);;
				bingoGameUI.panelUser3.revalidate();
				bingoGameUI.panelUser3.repaint();
			}
		}
	}


	public void bingoGameStart() { // 빙고게임 스타트 신호 전송 메소드
		Map<String, Object> request = new Hashtable<>();
		request.put("mode", "gameStart");
		
		try {
			clientNetwork.oos.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bingoGameUI.btnStart.setEnabled(false);
	}

	public void bingoGameAction(String number) { // 빙고게임 액션 신호 전송 메소드
		Map<String, Object> request = new Hashtable<>();
		request.put("mode", "bingoGameAction");
		request.put("index", number);
		request.put("bingoNumber", BINGO);
		try {
			clientNetwork.oos.writeObject(request);
			System.out.println("액션신호 전송완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bingoGameWin() { // 빙고게임 승리 신호 전송 메소드
		Map<String, Object> request = new Hashtable<>();
		System.out.println("bingowin sent");
		request.put("mode", "bingoWin");
		try {
			clientNetwork.oos.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
