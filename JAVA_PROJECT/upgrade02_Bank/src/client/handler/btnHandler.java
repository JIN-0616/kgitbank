package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientGUI.BankClientUI;

public class btnHandler implements ActionListener {
	BankClientUI ui;
	public btnHandler(BankClientUI ui) {
		this.ui=ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = ui.textField.getText();
		String resp = ui.net.sendAndReceive("exist#"+id);
		if (resp.equals("true")) {
			ui.textField.setText("");
			ui.tabbedPane.setSelectedIndex(2);	
			ui.tabbedPane.setEnabledAt(0, false);
			ui.tabbedPane.setEnabledAt(2, true);
			ui.tabbedPane.setEnabledAt(3, true);
			ui.id = id;
		//	ui.lbCurrent2.setText(id+", add on");
		//	ui.lbCurrent1.setText(id+", add on");
		//	target.lbMain.setText("");

		} else {
		//	target.lbMain.setText("[SYSTEM] 존재하지 않는 계좌다.");
		//	target.tfId.setText("");
		}
	}

}
