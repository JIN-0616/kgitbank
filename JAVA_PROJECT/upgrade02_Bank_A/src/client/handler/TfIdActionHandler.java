package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.BankClientUI;

public class TfIdActionHandler implements ActionListener {
	BankClientUI target;

	public TfIdActionHandler(BankClientUI target) {
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = target.tfId.getText();
		String resp = target.network.sendAndReceive("exist#" + id);
		if (resp.equals("true")) {
			target.tfId.setText("");
			target.tabbedPane.setSelectedIndex(2);	
			target.tabbedPane.setEnabledAt(0, false);
			target.tabbedPane.setEnabledAt(1, false);
			target.tabbedPane.setEnabledAt(2, true);
			target.tabbedPane.setEnabledAt(3, true);
			target.currentId = id;
			target.lbCurrent2.setText(id+", add on");
			target.lbCurrent1.setText(id+", add on");
			
			target.lbMain.setText("");
		} else {
			target.lbMain.setText("[SYSTEM] 존재하지 않는 계좌다.");
			target.tfId.setText("");
		}
	}

}
