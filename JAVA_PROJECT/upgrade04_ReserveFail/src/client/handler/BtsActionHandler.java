package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JToggleButton;

import client.ClientNetwork;
import client.ClientUI;

public class BtsActionHandler implements ActionListener {
	ClientUI ui;
//	ClientNetwork net;
	public BtsActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	//	this.net = clientUI.net;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * ��� ��ư�� �� �ϳ��� �׼�Handler�� ó���ϴ� ��Ȳ��
		 * �׷� �� �׼��� � ��ư�� ���ؼ� �۵��ϴ°����� �˾ƾ� ��.
		 */
		Object obj= e.getSource();	// �̺�Ʈ�� �߻���Ų ��ü�� ����.
		// ���� JToggleButton�鸸 ���� �ڵ鷯�� ó���ϱ� ������, JToggleButton ��ü��
		System.out.println("instanceOf JToggleButton? " + (obj instanceof JToggleButton));
		// Casting�� �ؼ� ó��
		JToggleButton src = (JToggleButton)obj;
		System.out.println(src.getText() + " .. " + src.isSelected());
		if(src.isSelected()==true) { // select�Ǹ鼭 action�� �߻��޴ٸ�
			String req = "reserve#"+src.getText();
			String s = ui.net.sendAndReceive(req);
			System.out.println("[client] request : "+"reserve#"+src.getText());
			System.out.println("[client] receive : "+s);
			if(s.equals("true")) {
				src.setSelected(true);
				System.out.println("[client] ���� �Ϸ�");
				ui.taLog.append("\n[client]"+src.getText()+"���� �Ϸ�");
				
			}else {
				src.setSelected(false);
				ui.taLog.append("\n[SYSTEM] �̹� ����Ǿ��ֽ��ϴ�.");
			}		
			
		}else if(src.isSelected()==false){
			String s = ui.net.sendAndReceive("cancel#"+src.getText());
			System.out.println("[client] request : "+"cancel#"+src.getText());
			System.out.println("[client] receive : "+s);
			if(s.equals("true")) {
				src.setSelected(false);
				System.out.println("[client] ��� �Ϸ�");
				ui.taLog.append("\n[client]"+src.getText()+"��� �Ϸ�");
			}else {
				src.setSelected(true);
				ui.taLog.append("\n[SYSTEM] ������� ����");
			}
			
		}
	
	}

}
/*
package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import client.ClientUI;

public class BtsActionHandler implements ActionListener {
	ClientUI ui;
	public BtsActionHandler(ClientUI clientUI) {
		this.ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JToggleButton src =(JToggleButton)e.getSource();
		String txt = src.getText();
		if(src.isSelected()) {
			String rst = ui.net.sendAndReceive("reserve#"+txt);
			String c = ui.taLog.getText();
			if(rst.equals("true")) {
				c += "\n[SYSTEM] " + txt+ " ���� ����"; 
			}else {
				c += "\n[SYSTEM] " + txt+ " ���� ���� (�̹� ����� �¼��̴�.)";
				src.setSelected(false);
			}
			ui.taLog.setText(c);
		} else {
			String rst = ui.net.sendAndReceive("cancel#"+txt);
			String c = ui.taLog.getText();
			if(rst.equals("true")) {
				c += "\n[SYSTEM] " + txt+ " ������� ����"; 
			}else {
				c += "\n[SYSTEM] " + txt+ " ������� ���� (�̹� ��ҵ� �¼��̴�.)";
			}
			ui.taLog.setText(c);
		}
	}

}

/*
 * ��� ��ư�� �� �ϳ��� �׼�Handler�� ó���ϴ� ��Ȳ��
 * �׷� �� �׼��� � ��ư�� ���ؼ� �۵��ϴ°����� �˾ƾ� ��.
 * 
 * Object obj= e.getSource();	// �̺�Ʈ�� �߻���Ų ��ü�� ����.
 * ���� JToggleButton�鸸 ���� �ڵ鷯�� ó���ϱ� ������, JToggleButton ��ü��
 * Casting�� �ؼ� ó�� why? 100���� �±� ������
 * 	JToggleButton src = (JToggleButton)obj;
 *  
 * Ȥ�� index�� ������
 * 	int idx = ui.bts.indexOf(obj);
 *  JToggleButton sr = ui.bts.get(idx);
 * 
 * ��������   src == sr ���� true��.
 * 
 * src.getText()  : �۾� ��������
 * src.isSelected() : ���õ� ��Ȳ���� �ƴ���
 * 
 * 
 * src.setSelected(false);	���� ���� Ǯ��
 * src.setSelected(false);	���� ���� ��Ű��
 * 
 * 
 */
