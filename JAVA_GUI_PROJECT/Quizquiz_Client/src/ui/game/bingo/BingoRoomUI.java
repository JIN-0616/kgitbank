package ui.game.bingo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.gameRoom.GameRoom;
import data.network.ClientNetworkInfo;
import game.bingo.BingoGameNetwork;

public class BingoRoomUI extends JFrame {
	public ClientNetworkInfo clientNetwork;
	public BingoRoomUI bingoRoomUI;
	public BingoUI panelBingo;
	public BingoUserInfo panelUserOwn;
	public BingoUserInfo panelUser2;
	public BingoUserInfo panelUser3;
	public BingoChatUI panelChat;
	public JButton btnStart;
	public GameRoom gameRoom;
	public BingoGameNetwork bingoGameNetwork;
	public JButton btnExit;
	public JLabel bingoScreen;

	public BingoRoomUI(ClientNetworkInfo clientNetwork, GameRoom gameRoom) { // 생성자
		this.gameRoom = gameRoom;
		this.clientNetwork = clientNetwork;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		init();
		
		addActionListener();
	}

	public void addActionListener() { // 액션 처리
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gameRoom.isStarted = true;
				bingoGameNetwork = new BingoGameNetwork(clientNetwork, null, BingoRoomUI.this);
				bingoGameNetwork.bingoGameStart(); // 빙고 게임 스타트 신호 전송 메소드 호출

			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("[CLIENT EXIT GAMEROOM]");
				Map request = new Hashtable<>();
				request.put("mode", "bingoGameRoomExit");
				try {
					clientNetwork.oos.writeObject(request);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				

			}
		});
//		addWindowListener(new WindowAdapter() { // 창을 강제로 종료할경우 시스템 종료
//			public void windowClosing(WindowEvent e) {
//				e.getWindow().setVisible(false);
//				e.getWindow().dispose();
//				sendExit();
//				System.exit(0);
//			}
//		});
	}

	public void sendExit() {
		Map request = new Hashtable<>();
		request.put("mode", "gameRoomExit");
		try {
			clientNetwork.oos.writeObject(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() { // UI
		setResizable(false);
		setSize(1000, 700);
		getContentPane().setLayout(null);

		
		panelBingo = new BingoUI(gameRoom);
		panelBingo.setBounds(99, 40, 300, 300);
		getContentPane().add(panelBingo);

		panelUserOwn = new BingoUserInfo(clientNetwork.user);
		panelUserOwn.setOpaque(false);
		panelUserOwn.setBounds(148, 422, 200, 200);
		getContentPane().add(panelUserOwn);

		panelChat = new BingoChatUI(clientNetwork, this);
		panelChat.setOpaque(false);
		panelChat.setBounds(487, 422, 463, 200);
		getContentPane().add(panelChat);

		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon("src\\image\\START.jpg"));
		btnStart.setBounds(148, 351, 200, 43);
		getContentPane().add(btnStart);
		btnStart.setEnabled(clientNetwork.user.isOwner);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("src\\image\\\uB098\uAC00\uAE302.jpg"));
		btnExit.setBounds(852, 15, 125, 29);
		getContentPane().add(btnExit);
		
		bingoScreen = new JLabel("");
		bingoScreen.setIcon(new ImageIcon("src\\image\\\uBE59\uACE0\uB8F82.jpg"));
		bingoScreen.setOpaque(false);
		bingoScreen.setBounds(0, 0, 994, 671);
		getContentPane().add(bingoScreen);
	}
//
//	public void initUser() {
//
//		panelUser2 = new JPanel();
//		panelUser2.setBounds(487, 89, 200, 200);
//		getContentPane().add(panelUser2);
//
//		panelUser3 = new JPanel();
//		panelUser3.setBounds(749, 89, 200, 200);
//		getContentPane().add(panelUser3);
//
//	}
}
