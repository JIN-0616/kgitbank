package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.ClientUI;

public class JoinHandler implements ActionListener {
	ClientUI ui;
	
	public JoinHandler(ClientUI ui) {
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String nick = ui.pnWelcome.tfJoinNick.getText();
		String pass = new String(ui.pnWelcome.pfJoinPass.getPassword());
		if(ui.pnWelcome.rbtAgree.isSelected()) {
			// + matches Á¤±Ô½Ä °É·¯³»±â Ãß°¡
			if (!nick.matches("[a-z0-9°¡-ÆR]{2,8}")) {
				JOptionPane.showMessageDialog(ui, "¾ÆÀÌµð´Â ÇÑ±Û,¿µ¹®,¼ýÀÚ ·Î 2 ~ 8 ±ÛÀÚ.");
				return;
			}
			if (!pass.matches("\\w{2,8}")) {
				JOptionPane.showMessageDialog(ui, "ÆÐ½º¿öµå´Â 2~8ÀÚ");
				return;
			}
			ui.net.sendJoinRequest(nick, pass);
			
		}		
	}
}
