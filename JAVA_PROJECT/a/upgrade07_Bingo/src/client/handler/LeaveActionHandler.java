package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientUI;

public class LeaveActionHandler implements ActionListener {
	ClientUI ui;
	public LeaveActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ui.net.sendLeaveRequest();
	}
}
