package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;

import client.ClientUI;

public class BtRefreshActionHandler implements ActionListener {
	ClientUI ui;
	
	public BtRefreshActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	}
 	
	@Override
	public void actionPerformed(ActionEvent e) {
		String rst = ui.net.sendAndReceive("all");
		String[] ss = rst.split("#");
		List<String> chList = new ArrayList<>();
		for(String s:  ss) {
			chList.add(s);
		}
		for(JToggleButton b: ui.bts) {
			if(chList.contains(b.getText())) {
				b.setSelected(true);
			}else {
				b.setSelected(false);
			}
		}
	}
}




