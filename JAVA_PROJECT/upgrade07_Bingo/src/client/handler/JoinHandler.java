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
			// + matches 정규식 걸러내기 추가
			if (!nick.matches("[a-z0-9가-힣]{2,8}")) {
				JOptionPane.showMessageDialog(ui, "아이디는 한글,영문,숫자 로 2 ~ 8 글자.");
				return;
			}
			if (!pass.matches("\\w{2,8}")) {
				JOptionPane.showMessageDialog(ui, "패스워드는 2~8자");
				return;
			}
			ui.net.sendJoinRequest(nick, pass);
			
		}		
	}
}
