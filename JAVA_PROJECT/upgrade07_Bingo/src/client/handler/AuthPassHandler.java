package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.ClientUI;

public class AuthPassHandler implements ActionListener {
	ClientUI ui;
	public AuthPassHandler(ClientUI ui) {
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String nick = ui.pnWelcome.tfAuthNick.getText();
		String pass = new String(ui.pnWelcome.pfAuthPass.getPassword()); 
		 // �ߺ� ���� ���� �߰��Ұ�	
		
		if(nick.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(ui, "���̵�� ��й�ȣ�� �Է��Ѵ�.");
			return;
		}		
		ui.net.sendAuthRequest(nick, pass);
	}

}
