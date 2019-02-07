package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;

import client.ClientUI;

public class RefreshActionHandler implements ActionListener {
	ClientUI ui;
	List<String> chList;
	public RefreshActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
		chList = new ArrayList<>();
		for(int r=1; r<=4; r++) {
			for(char c='A'; c<='H'; c++) {
				chList.add(r +"-"+c);
			}
		}
	}
 	
	@Override
	public void actionPerformed(ActionEvent e) {
		String rst = ui.net.sendAndReceive("all");
		String[] ss = rst.split("#");
		for(String s: ss) {
			int idx = chList.indexOf(s);
			ui.bts.get(idx).setSelected(true);
		}
	}
}




