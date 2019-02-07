package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.ClientUI;

public class NewJoinActionHandler implements ActionListener {
	ClientUI ui;
	
	public NewJoinActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	}
	
	public void actionPerformed(ActionEvent e) {				
		ui.net.sendNewJoinRequest();
	}
}
