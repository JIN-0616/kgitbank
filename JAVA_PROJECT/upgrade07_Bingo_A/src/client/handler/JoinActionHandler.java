package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.ClientUI;

public class JoinActionHandler implements ActionListener {
	ClientUI ui;
	public JoinActionHandler(ClientUI clientUI) {
		ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean b = ui.pnWelcome.rbtAgree.isSelected();
		if(!b) {
			JOptionPane.showMessageDialog(ui, "약관 동의를 해달라.");
		}else {
			String nick = ui.pnWelcome.tfJoinNick.getText();
			String pass = ui.pnWelcome.pfJoinPass.getText();
			if(!nick.matches("[가-힇]{2,5}")) {
				JOptionPane.showMessageDialog(ui, "아이디는 한글로 2 ~ 5 글자다.");
				return;
			}
			if(!pass.matches("\\w{2,8}")) {
				JOptionPane.showMessageDialog(ui, "비밀번호는 2 ~ 8 글자다.");
				return;
			}
			
			ui.net.sendJoinRequest(nick, pass);
		}

	}

}
