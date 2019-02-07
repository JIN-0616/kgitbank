package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * JFrame 이라는 컨테이너에 자주 설정되는 레이아웃을 살펴보았는데,
 *  어쨌든 레이아웃은 하나밖에 적용이 안된다.
 *  레이아웃을 섞어서 적용을 하고 싶다면..?
 * 
 *  JPanal 이라는 JFrame에 장착이 되는 Container 인 Component를 사용하면 된다.
 */
public class CharlieFrame extends JFrame {
	public CharlieFrame() {
		setTitle("Mixed Layout");
		setLayout(new BorderLayout());
		
		JLabel lb = new JLabel("round 1");
		add(lb, BorderLayout.NORTH);
		
		JPanel pn = new JPanel();
			pn.setLayout(new GridLayout(1, 2));
			
			JButton bt = new JButton("READY");
			pn.add(bt);
			
			JPanel rpn = new JPanel();
				rpn.setLayout(new GridLayout(3, 3));
				for (int cnt = 1; cnt <=9 ; cnt++) {
					rpn.add(new JButton());					
				}
			pn.add(rpn);
		add(pn, BorderLayout.CENTER);
		
		setSize(500, 250);
	}
}
