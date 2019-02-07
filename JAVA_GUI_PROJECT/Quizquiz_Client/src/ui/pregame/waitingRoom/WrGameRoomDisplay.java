package ui.pregame.waitingRoom;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import data.gameRoom.GameRoom;
import data.network.ClientNetworkInfo;
import pregame.waitingRoom.WrGameRoomJoinNetwork;

public class WrGameRoomDisplay extends JPanel {
	public ClientNetworkInfo clientNetwork;
	public WaitingRoomUI waitingRoomUI;
	
	public List<GameRoomBtn> gameRooms;
	
	public WrGameRoomDisplay(ClientNetworkInfo clientNetwork, WaitingRoomUI waitingRoomUI) {
		setOpaque(false);
		setBackground(SystemColor.activeCaption);
		this.clientNetwork = clientNetwork;
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gameRooms = new Vector<GameRoomBtn>();
		
		this.waitingRoomUI = waitingRoomUI;
		
		initFrame();
//		actionListener();
		
	}
	
	public void actionListener() {
		
		for (int i=0; i<gameRooms.size(); i++) {
			GameRoomBtn RoomBtn = gameRooms.get(i);
			RoomBtn.setActionCommand("GameRoom/" + String.valueOf(i));
			RoomBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						WrGameRoomJoinNetwork wrgn = new WrGameRoomJoinNetwork(clientNetwork);
						boolean b = wrgn.sendJoinGameRoom(RoomBtn.gameRoom);
					}
					
				}
				
			});
		}
			
	}
	
	public void addGameRooms() {
		for (int i=0; i<gameRooms.size(); i++) {
			this.add(gameRooms.get(i));
		}
	}
	
	
	
	
	private void initFrame() {
		setSize(960, 360);
//		for (int i=0; i<6; i++) {
//			GameRoomBtn grBtn = new GameRoomBtn();
//			gameRooms.add(grBtn);
//			grBtn.setVisible(true);
//			
//		}
	}
	
	public void setGameRoomBtn(int index, GameRoom gameRoom) {
		GameRoomBtn grBtn = gameRooms.get(index);
		grBtn.setGameRoom(gameRoom);
		
	}
	
	public void addGameRoomBtn(GameRoomBtn gameRoomBtn) {
		this.add(gameRoomBtn);
	}
	
	
//	public static void main(String[] args) {								//test
//		WrGameRoomDisplay display = new WrGameRoomDisplay(clientNetwork);
//	       
//        JFrame frame = new JFrame();
//        
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(960, 360);
//
//        Container contentPane = frame.getContentPane();
//        contentPane.add(display);
//
//        frame.setVisible(true);
//	}
}
