package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.ClientUI;

public class ExitActionHandler implements ActionListener {
	ClientUI ui;
	public ExitActionHandler(ClientUI clientUI) {
		ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(ui, "정말로 종료?");
		// 예=0, 아니오=1, 취소=2   esc = -1
		if(n == 0) {
			ui.net.sendExitRequest();
		}
	}

}
