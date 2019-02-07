package UI;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

/*
 * GUI를 구축하는데 있어서 필요한 객체들과
 *  WindowBuilder 라는 Plug-In을 이용해서 사용자 UI를 더 쉽게 만들어내는 것을 살펴보았다.
 *  
 * 이 UI를 통해서 프로그램이 돌아아게 하려면, Event 라는걸 처리하는 방법을 알아야 한다. 
 * 
 * UI에서 사용자가 어떤 행동을 하게 되면 Event가 발생하게 되있고
 * 이걸 프로그램적으로 이미 Event를 캐치하는건 다 구현이 되어있다.
 * 
 * 프로그램을 만들려면, Event가 발생했을때 어떤 걸 하겠다고, 컴포넌트마다 설정만 해주면 된다.
 * 컴포넌트마다 설정할 수 있는 이벤트 종류는 조금씩 다르다.
 * 
 * 그러면 어떻게 설정을 하는것인가?
 */

class BtActionHandler implements ActionListener{
	JTextField targetTf;
	JLabel targetLb;
	
	BtActionHandler(JTextField tf, JLabel lb) {
		targetTf = tf;
		targetLb = lb;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Bt..actionPerformed.."+e);
		String txt = targetTf.getText();
		targetLb.setText(txt);
		targetTf.setText("");
	}
	
}
class TFctionHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tf..actionPerformed.."+e);
		
	}
	
}

//==========================================================
public class GolfFrame extends JFrame {
	private JTextField tf;
	public GolfFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton bt = new JButton("New button");
		bt.setBounds(12, 66, 97, 23);
		getContentPane().add(bt);
		
		tf = new JTextField();
		tf.setBounds(12, 35, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		JLabel lb = new JLabel("New label");
		lb.setBounds(12, 10, 57, 15);
		getContentPane().add(lb);
		
		setSize(400,400); //수동설정 후 툴수정하면 적용이된다.
		
		// 화면 구축이 끝남
		//=================================================================================
		// JButton 같은 경우는 사용자가 누르면 Action Event 라는것을 발생시키게 구현되있다.
		// 이 Action 발생시 무엇인가를 하고싶으면, ActionListener(I)를 토대로 객체를 생성해서
		
		// action 
		// 	-> actionListener , ...
		//		->addActionListener
		
		//bt.addActionListener(new BtActionHandler());
		
		// ex) void setAdv(...), void open(){adv.start(name)};
		
		tf.addActionListener(new TFctionHandler());
		// 실제 이벤트가 발생하게 됬을때 감지만 하는게 아니라,
		// 감지해서 GUI 객체들의 상태를 확인이나 변경을 하고자 한다면..?
		// 예를들어 버튼클릭했을때, TextField에 적힌글을 뽑아서 , JLabel에 설정하려면
		
		ActionListener i = new BtActionHandler(tf, lb); 
		// 이 이벤트리스터 들어갈때 제어해야되는 GUI객체값을 넘겨주고,
		// BtActinHandler 에서 매개변수를 받을 생성자를 만들어서 내부변수에 넣어준다.
		// 그리고 actionPerformed에서 getText와 setText를 이용해서 넘겨주는 이벤트를 작성한다.
		// 이 헨들러를 다시 버튼에 넣어준다.
		
		// 이벤트 발생시 접근할수 있게 해두어야한다.
		bt.addActionListener(i);
		// Listener를 붙이는데 그 Listener가 접근 및 제어 해야할 컴포넌트가 많다면?
		// 객체를 넘기기가 힘들지 않을까?
	}
}
