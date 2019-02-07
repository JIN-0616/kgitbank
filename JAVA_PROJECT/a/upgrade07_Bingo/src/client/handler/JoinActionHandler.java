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
			JOptionPane.showMessageDialog(ui, "��� ���Ǹ� �ش޶�.");
		}else {
			String nick = ui.pnWelcome.tfJoinNick.getText();
			String pass = ui.pnWelcome.pfJoinPass.getText();
			if(!nick.matches("[��-Ş]{2,5}")) {
				JOptionPane.showMessageDialog(ui, "���̵�� �ѱ۷� 2 ~ 5 ���ڴ�.");
				return;
			}
			if(!pass.matches("\\w{2,8}")) {
				JOptionPane.showMessageDialog(ui, "��й�ȣ�� 2 ~ 8 ���ڴ�.");
				return;
			}
			
			ui.net.sendJoinRequest(nick, pass);
		}

	}

}
