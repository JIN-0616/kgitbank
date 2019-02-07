package UI;

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
 * 이벤트 발생시 어떤 형태로 잡아서 처리해야되는지 살펴보았고,
 * 이걸 실제로 이벤트에 의해서 어떤 프로그램이 돌아가게끔 하려면..? 
 * 
 */

public class IndiaFrame extends JFrame {
	IndiaEngine engine; // 엔진객체 담을 변수 선언

	// =====================================================
	JLabel lb;
	JButton btStart;
	JTextField tf;

	public IndiaFrame() {
		engine = new IndiaEngine(); // 내부에 설정
		
		setTitle("UP DOWN - GUI");
		setSize(500, 500);
		getContentPane().setLayout(null);
		
		
		btStart = new JButton("Start");
		btStart.setBounds(325, 10, 97, 23);
		getContentPane().add(btStart);

		lb = new JLabel("??");
		lb.setEnabled(false);
		lb.setFont(new Font("나눔고딕코딩", Font.BOLD, 40));
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(12, 46, 410, 179);
		getContentPane().add(lb);

		JTextField tf = new JTextField();
		tf.setEnabled(false);
		tf.setHorizontalAlignment(SwingConstants.CENTER);
		tf.setBounds(161, 230, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);

		btStart.addActionListener(new BtStartHandler(this));
		tf.addActionListener(new TfHandler(this));
	}

}

//--------------------------------------------다인작업위해 빼서작업추천
class TfHandler implements ActionListener {
	IndiaFrame target;

	public TfHandler(IndiaFrame f) {
		target = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * textField에서 글씨 봅아서 유효성검사( \\d{1,3} 인지 매치) 맞으면,
		 * parseInt를 해서 engine에 compare시키면 문자열이 나오게 됨.
		 * 이걸 JOptionPane.showMessageDialog를 띄움
		 * isRun 콜해서 check해서 true면
		 *   - tell을 통해서 나온 문자열을 label에 설정
		 * 그게아니면 - label에 ??로 설정해주고, 버튼을 활성화하고, 나머진 비활성화
		 */
		String in = target.tf.getText();
		if (in.matches("\\d{1,3}")) {
			int d = Integer.parseInt(in);
			String rst = target.engine.compare(d);
			JOptionPane.showMessageDialog(target, rst);
			if (target.engine.isRun()) {
				target.lb.setText(target.engine.tell());
			} else {
				target.lb.setText("??");
				target.lb.setEnabled(false);
				target.tf.setEnabled(false);
				target.btStart.setEnabled(true);
			}
		} else {
			target.tf.setText("");
		}
	}

}

//--------------------------------------------다인작업위해 빼서작업추천
class BtStartHandler implements ActionListener {
	IndiaFrame target;

	public BtStartHandler(IndiaFrame f) {
		target = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * targetUI 내부에 장착된 Engine을 start 콜
		 * btstart 을 enabled 를 false 처리
		 * lb와 tf를 enalbed를 true 처리
		 * engine에서 tell을 콜하면,
		 * 엔진상태가 나오는데 이걸 lb에 setText();
		 */
		target.engine.start();
		String r = target.engine.tell();
		target.lb.setText(r);

		target.btStart.setEnabled(false);
		target.lb.setEnabled(true);
		target.tf.setEnabled(true);;
		target.tf.requestFocus();

	}

}
