package ui.game.bingo;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.network.ClientNetworkInfo;
import data.user.User;

public class BingoUserInfo extends JPanel{
	
	public User user;
	
	
	public JLabel lbUserChar;
	public JLabel lblNickname;
	public JLabel lbBingoNumber;
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public BingoUserInfo(User user) {
		setOpaque(false);

		this.user = user;
		initUser();
	}
	
	
	
	public void initUser() {
		setSize(200,200);
		setLayout(null);
		
		lbUserChar = new JLabel("");
		lbUserChar.setIcon(new ImageIcon("src\\image\\char3.png"));
		lbUserChar.setOpaque(false);
		setBackground(new Color(255, 255, 255));
		lbUserChar.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserChar.setBounds(12, 0, 170, 170);
		add(lbUserChar);
		
		lblNickname = new JLabel("NickName");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(12, 185, 170, 15);
		lblNickname.setText(user.nickname);
		add(lblNickname);
		
		lbBingoNumber = new JLabel("Bingo : 0");
		lbBingoNumber.setBounds(143, 185, 57, 15);
		add(lbBingoNumber);
		
	}


}
