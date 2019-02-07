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
 */
