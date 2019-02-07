package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientUI;

public class EnterActionHandler implements ActionListener {
	ClientUI ui;
	public EnterActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		int idx = ui.pnLounge.rbts.indexOf(b);
		ui.net.sendEnterRequest(idx);		
	}
}

class EnterRoomActionHandler  implements ActionListener {
	ClientUI ui;
	int target;
	public EnterRoomActionHandler(ClientUI clientUI, int t) {
		this.ui = clientUI;
		target = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ui.net.sendEnterRequest(target);		
	}
}




