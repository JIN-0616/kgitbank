package ui.pregame.waitingRoom;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.gameRoom.GameRoom;
import data.user.User;
import javax.swing.SwingConstants;

public class GameRoomBtn extends JButton {
	public GameRoom gameRoom;
	public JLabel grNumber;
	public JLabel grTitle;
	public JLabel grSize;
	
	public GameRoomBtn() {

	}
	

	public void initFrame() {
		JPanel p = new JPanel();
		p.setLayout(null);
		setPreferredSize(new Dimension(460, 100));
		
		this.add(p);
		
		grNumber = new JLabel(String.valueOf(gameRoom.roomNumber));
		grNumber.setBounds(12, 0, 55, 18);
		p.add(grNumber);
		
		grTitle = new JLabel(gameRoom.title);
		grTitle.setVerticalAlignment(SwingConstants.TOP);
		grTitle.setBounds(12, 27, 428, 34);
		p.add(grTitle);
		
		grSize = new JLabel(String.valueOf(gameRoom.joinedUsers.size()) + "/" + String.valueOf(gameRoom.maxPlayers));
		grSize.setVerticalAlignment(SwingConstants.TOP);
		grSize.setBounds(392, 0, 48, 18);
		p.add(grSize);
		this.setMargin(new Insets(1, 1, 1, 1));
	}
	public void setGameRoom(GameRoom gameRoom) {
		this.gameRoom = gameRoom;
		grNumber.setText(String.valueOf(gameRoom.roomNumber));
		grTitle.setText(gameRoom.title);
		grSize.setText(String.valueOf(gameRoom.joinedUsers.size()) + "/" + String.valueOf(gameRoom.maxPlayers));
		
		
		
		
	}

}
