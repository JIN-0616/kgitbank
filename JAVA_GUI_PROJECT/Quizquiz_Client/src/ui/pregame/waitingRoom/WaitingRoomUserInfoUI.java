package ui.pregame.waitingRoom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.network.ClientNetworkInfo;

public class WaitingRoomUserInfoUI extends JPanel{
	public JLabel lbUserChar;
	public JLabel lblNickname;
	ClientNetworkInfo clientNetworkInfo;
	WaitingRoomUI waitingRoomUI;
	public WaitingRoomUserInfoUI(ClientNetworkInfo clientNetworkInfo,WaitingRoomUI waitingRoomUI) {
		
		this.clientNetworkInfo = clientNetworkInfo;
		this.waitingRoomUI = waitingRoomUI;
		init();
		
		
		
		
	}
	
	public void init() {
		
		setSize(200,200);
		setLayout(null);
		
		lbUserChar = new JLabel("\uC720\uC800 \uC815\uBCF4");
		lbUserChar.setIcon(new ImageIcon("src\\image\\char3.png"));
		lbUserChar.setOpaque(false);
		lbUserChar.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserChar.setBounds(12, 0, 170, 170);
		add(lbUserChar);
		
		lblNickname = new JLabel("NickName");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(12, 185, 170, 15);
		lblNickname.setText(clientNetworkInfo.user.nickname);
		add(lblNickname);
		
	}
}
