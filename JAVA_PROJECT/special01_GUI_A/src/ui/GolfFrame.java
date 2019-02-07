package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Gui를 만들어내는데 있어서 필요한 객체들과 
 * WindowBuilder 라는 Plug-In 을 이용해서 사용자 UI 좀 쉽게 만들어내는 걸 살펴보았다.
 * 
 * 이 UI 를 통해서 프로그램이 돌아가게 하려면, Event 라는걸 처리하는 방법을 알아야 한다.
 * 
 * UI에서 사용자가 어떤 행동을 하게 되면 Event가 발생하게 되있고 
 * 이걸 프로그램적으로 이미 Event를 캐치하는건 다 구현이 되있다. 
 * 
 * 프로그램을 만들려면, Event가 발생했을때 어떤 걸 하겠다고, 컴포넌트마다 설정만 해주면 된다.
 * 컴포넌트마다 설정할수 있는 이벤트 종류는 조금씩 다르다.
 * 
 * 그러면 어떻게 설정을 하는건가..?
 * 
 */
class BtActionHandler implements ActionListener {
	JTextField targetTf;
	JLabel targetLb;
	
	BtActionHandler(JTextField tf, JLabel lb) {
		targetTf = tf;
		targetLb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("bt .. actionPerformed.." + e);
		String txt = targetTf.getText();
		targetLb.setText(txt);
		targetTf.setText("");
	}
}

class TfActionHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("tf .. actionPerformed.." + e);
	}
}

//==========================================================
public class GolfFrame extends JFrame {
	private JTextField tf;
	public GolfFrame() {
		setSize(415, 309);
		getContentPane().setLayout(null);
		
		JButton bt = new JButton("New button");
		bt.setBounds(164, 193, 97, 23);
		getContentPane().add(bt);
		
		tf = new JTextField();
		tf.setBounds(152, 145, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		JLabel lb = new JLabel("New label");
		lb.setBounds(178, 83, 57, 15);
		getContentPane().add(lb);
		// 화면 구축이 끝남
		//============================================================
		// JButton 같은 경우는 사용자가 버튼을 누를때 Action Event 라는걸 발생시키게 구현되있다.
		// 이 Action 발생시 먼가를 하고 싶으면, ActionListener(I) 를 토대로 객체를 생성해서
		
		tf.addActionListener(new TfActionHandler());
		// 실제 이벤트가 발생하게 됫을때 감지만 하는게 아니라, 
		// 감지해서 GUI 객체들의 상태를 확인이나 변경을 하고자 한다면..?
		// 예를들어, 버튼클릭했을때 TextField에 적힌글을 뽑아서 , JLabel에 설정하는,
		
		ActionListener i = new BtActionHandler(tf, lb);	
		// 이 이벤트리스너 돌아갈때 제어해야되는 GUI객체값을 같이 넘겨주고,
		// 이벤트 발생시 접근할수 있게 해두어야 한다.
		bt.addActionListener(i);
		// Listener를 붙이는데 그 Listener가 접근 및 제어 해야될 컴포넌트가 많다면..? 객체를 넘기기가 힘들지 않을까..?
	}
	
}
