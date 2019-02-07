package client.handler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import client.ClientUI;

public class radioButtonHandler implements ItemListener {
	ClientUI ui;
	public radioButtonHandler(ClientUI ui) {
		this.ui=ui;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		AbstractButton ab = (AbstractButton)e.getItemSelectable();
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(ab.getText().equals("����")) {
				ui.pnWelcome.btJoin.setEnabled(true);
			}else if(ab.getText().equals("����")){
				ui.pnWelcome.btJoin.setEnabled(false);
				JOptionPane.showMessageDialog(null, "����� �����ؾ� �մϴ�.");
			}
		}
	}
}
