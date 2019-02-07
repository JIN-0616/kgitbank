package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * 이벤트 발생시 어떤형태로 잡아서 처리해야되는지 살펴보았고,
 * 이걸 실제로 이벤트에 의해서 어떤 프로그램이 돌아가게끔 하려면..? 
 *
 * Up & Down 했던 걸 GUI 버전으로 한번 만들어보면서 살펴보자.
 */

public class IndiaFrame extends JFrame {
	IndiaEngine engine;
	//====================================================
	JTextField textField;
	JLabel lbStatus;
	JButton btStart;
	
	public IndiaFrame() {
		JOptionPane.showInputDialog("userName?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		engine = new IndiaEngine();
		
		setTitle("UP DOWN - GUI");
		setSize(400, 400);
		getContentPane().setLayout(null);
		
		btStart = new JButton("S T A R T");
		btStart.setBounds(275, 10, 97, 23);
		getContentPane().add(btStart);
		
		lbStatus = new JLabel("??");
		lbStatus.setEnabled(false);
		lbStatus.setFont(new Font("굴림", Font.PLAIN, 37));
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(12, 69, 360, 193);
		getContentPane().add(lbStatus);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(134, 293, 116, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		//=================================================================================
		btStart.addActionListener(new BtStartHandler(this));
		textField.addActionListener(new TfHandler(this));
	}
}
//=========================================================================================================
class TfHandler implements ActionListener {
	IndiaFrame target;
	
	TfHandler(IndiaFrame f) {
		target = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * textField에서 글씨 뽑아서 유효성 검사 ( \\d{1,3} 인지 매치)
		 * 맞으면, parseInt를 해서 engine에 compare 시키면 
		 * 문자열이 나오게 됨. 이걸 JOptionPane.showMessageDialog 로 띄움
		 * isRun 콜해서 체크해서 true 면,
		 *   tell을 콜해서 나온 문자열을 label에 설정
		 * 그게아니면,
		 *   label에 ?? 로 설정해주고, 버튼을 활성화 하고, 나머진 비활성화
		 */
		String in = target.textField.getText();
		if(in.matches("\\d{1,3}")) {
			int d = Integer.parseInt(in);
			String rst = target.engine.compare(d);
			JOptionPane.showMessageDialog(target, rst);
			if(target.engine.isRun() )  {
				target.lbStatus.setText(  target.engine.tell()   );
			}else {
				target.lbStatus.setText("??");
				target.lbStatus.setEnabled(false);
				target.textField.setEnabled(false);
				target.btStart.setEnabled(true);
			}
		}else {
			target.textField.setText("");
		}
		
	}
	
}

//=========================================================================================================
class BtStartHandler implements ActionListener {
	IndiaFrame target;
	BtStartHandler(IndiaFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.start();
		String r =target.engine.tell();
		target.lbStatus.setText(r);
		
		target.btStart.setEnabled(false);
		target.lbStatus.setEnabled(true);
		target.textField.setEnabled(true);
		target.textField.requestFocus();
		/*
		 * targetUI 내부에 장착된 Engine 을 start 콜 해주고
		 * btStart 을 enabled false 처리
		 * lb 과 tf를 enabled true 처리
		 * engine에서 tell을 콜하면, 엔진상태가 나오는데
		 * 이걸 lb에 setText
		 */
	}
}






