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
			// + matches ���Խ� �ɷ����� �߰�
			if (!nick.matches("[a-z0-9��-�R]{2,8}")) {
				JOptionPane.showMessageDialog(ui, "���̵�� �ѱ�,����,���� �� 2 ~ 8 ����.");
				return;
			}
			if (!pass.matches("\\w{2,8}")) {
				JOptionPane.showMessageDialog(ui, "�н������ 2~8��");
				return;
			}
			ui.net.sendJoinRequest(nick, pass);
			
		}		
	}
}
