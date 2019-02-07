package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JToggleButton;

import client.ClientUI;

public class BtRefreshHandler implements ActionListener {
	ClientUI ui;
	List<String> chList; //리스트를 사용할시
	public BtRefreshHandler(ClientUI clientUI) {
		this.ui = clientUI;
		chList = new ArrayList<>();	//리스트를 사용할시
		for (int i = 1; i <= 4; i++) {
			for (char c = 'A'; c <= 'H'; c++) {
				chList.add(i +"-"+c);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String req = "total";
		String s = ui.net.SendRequest(req);
		String[] ss = s.split("#");
		for(JToggleButton b : ui.bts) {
			b.setSelected(false);
			for (String st : ss) {
				if(b.getText().equals(st)) {
					b.setSelected(true);
				}
			}
		}
		
		
		// List생성시 간편해짐, 위치상태를 알수있음
		
		/* ====ArrayList적용시 방식=====
		String req = "total";
		String result = ui.net.sendAndReceive("total");
		System.out.println("[client] request : "+req);
		System.out.println("[client] receive : "+result);
		String[] ss = result.split("#");
		for (JToggleButton t : ui.bts) {
			t.setSelected(false);
		}
		for(String s: ss) {
			int idx = chList.indexOf(s);
			ui.bts.get(idx).setSelected(true);
		}
		*///=============================
		
		System.out.println("[client] refreshed");
		ui.taLog.append("\n[SYSTEM] refreshed");
		
		// cf)
		// ObjectStream은 넘길시에는 이미 한번 넘긴것을 저장함
		// .reset();을 이용하거나 넘길때마다 새로운 객체 생성을 권장
			
	}

}
