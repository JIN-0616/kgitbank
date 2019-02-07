package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientUI;

public class EnterActionHandler implements ActionListener {
	ClientUI ui;
	public EnterActionHandler(ClientUI ui) {
		this.ui=ui;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		for (int i = 0; i < ui.pnLounge.rbts.size(); i++) {
			if(ui.pnLounge.rbts.get(i) == e.getSource()) {
				ui.net.sendRoomEnterRequest(i);
			}
		}
		*/
		JButton b = (JButton)e.getSource();
		int idx = ui.pnLounge.rbts.indexOf(b);
		ui.net.sendRoomEnterRequest(idx);
	}
}

class EnterRoomActionHandler implements ActionListener{
	ClientUI ui;
	int target;
	public EnterRoomActionHandler(ClientUI ui, int t) {
		this.ui=ui;
		target = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ui.net.sendRoomEnterRequest(target);
	}
}


