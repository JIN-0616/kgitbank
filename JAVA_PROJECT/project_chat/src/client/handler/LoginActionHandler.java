package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.ClientUI;

public class LoginActionHandler implements ActionListener {
	ClientUI ui;

	public LoginActionHandler(ClientUI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String nick = ui.pnLogin.tfId.getText();
		String pass = ui.pnLogin.tfPass.getText();
		if(nick.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(ui, "���̵�� ��й�ȣ�� �Է��Ѵ�.");
			return;
		}

		ui.net.sendAuthRequest(nick, pass);

	}

}
