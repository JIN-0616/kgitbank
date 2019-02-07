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
		 * 모든 버튼을 다 하나의 액션Handler로 처리하는 상황임
		 * 그럼 이 액션은 어떤 버튼에 의해서 작동하는것인지 알아야 함.
		 */
		Object obj= e.getSource();	// 이벤트를 발생시킨 객체가 나옴.
		// 물론 JToggleButton들만 이쪽 핸들러로 처리하기 때문에, JToggleButton 객체임
		System.out.println("instanceOf JToggleButton? " + (obj instanceof JToggleButton));
		// Casting을 해서 처리
		JToggleButton src = (JToggleButton)obj;
		System.out.println(src.getText() + " .. " + src.isSelected());
		if(src.isSelected()==true) { // select되면서 action이 발생햇다면
			String req = "reserve#"+src.getText();
			String s = ui.net.sendAndReceive(req);
			System.out.println("[client] request : "+"reserve#"+src.getText());
			System.out.println("[client] receive : "+s);
			if(s.equals("true")) {
				src.setSelected(true);
				System.out.println("[client] 예약 완료");
				ui.taLog.append("\n[client]"+src.getText()+"예약 완료");
				
			}else {
				src.setSelected(false);
				ui.taLog.append("\n[SYSTEM] 이미 예약되어있습니다.");
			}		
			
		}else if(src.isSelected()==false){
			String s = ui.net.sendAndReceive("cancel#"+src.getText());
			System.out.println("[client] request : "+"cancel#"+src.getText());
			System.out.println("[client] receive : "+s);
			if(s.equals("true")) {
				src.setSelected(false);
				System.out.println("[client] 취소 완료");
				ui.taLog.append("\n[client]"+src.getText()+"취소 완료");
			}else {
				src.setSelected(true);
				ui.taLog.append("\n[SYSTEM] 예약취소 에러");
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
				c += "\n[SYSTEM] " + txt+ " 예약 성공"; 
			}else {
				c += "\n[SYSTEM] " + txt+ " 예약 실패 (이미 예약된 좌석이다.)";
				src.setSelected(false);
			}
			ui.taLog.setText(c);
		} else {
			String rst = ui.net.sendAndReceive("cancel#"+txt);
			String c = ui.taLog.getText();
			if(rst.equals("true")) {
				c += "\n[SYSTEM] " + txt+ " 예약취소 성공"; 
			}else {
				c += "\n[SYSTEM] " + txt+ " 예약취소 실패 (이미 취소된 좌석이다.)";
			}
			ui.taLog.setText(c);
		}
	}

}

/*
 * 모든 버튼을 다 하나의 액션Handler로 처리하는 상황임
 * 그럼 이 액션은 어떤 버튼에 의해서 작동하는것인지 알아야 함.
 * 
 * Object obj= e.getSource();	// 이벤트를 발생시킨 객체가 나옴.
 * 물론 JToggleButton들만 이쪽 핸들러로 처리하기 때문에, JToggleButton 객체임
 * Casting을 해서 처리 why? 100프로 맞기 때문에
 * 	JToggleButton src = (JToggleButton)obj;
 *  
 * 혹은 index로 재접근
 * 	int idx = ui.bts.indexOf(obj);
 *  JToggleButton sr = ui.bts.get(idx);
 * 
 * 같을꺼임   src == sr 값이 true임.
 * 
 * src.getText()  : 글씨 가져오기
 * src.isSelected() : 선택된 상황인지 아닌지
 * 
 * 
 * src.setSelected(false);	강제 선택 풀기
 * src.setSelected(false);	강제 선택 시키기
 * 
 * 
 */
