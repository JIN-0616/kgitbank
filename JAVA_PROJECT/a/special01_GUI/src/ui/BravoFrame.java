package ui;

/*
 *  
 */
import java.awt.*;
import javax.swing.*;

public class BravoFrame extends JFrame {
	public BravoFrame() {
		// 적용시킬수 있는 레이아웃은 크게 4가지정도를 많이 사용한다.
		/*
		 *  GridLayout  
		 *   - 바둑판 모양으로 만들고자 할때 사용하는 레이아웃
		 * 	GridLayout 설정시엔 JFrame의 뷰영역을 설정한 행,열로 분할되고
		 *  Component 들이 동일크기로 차례대로 한줄씩 → 그다음줄 배치됨
		 *  
		 *  BorderLayout
		 *   - 화면을 동,서,남,북,센터 영역으로 분할해서 
		 *   컴포넌트를 방향 잡아서 잡아서 배치하게 됨
		 *
		 *  AbsoluteLayout
		 *   - 화면을 좌표로 설정해서 원하는 곳에 원하는 크기로 컴포넌트를 배치하고자 할때
		 *   
		*/
	//	initTypeA();
		initTypeB();
	}
	private void initTypeB() {
		setTitle("Absolute Layout");
		setLayout(null);
		setSize(500, 300);
		
		JTextField tf = new JTextField();
		tf.setLocation(300, 180);	// JFrame 기준
			tf.setSize(150, 30);
		JPasswordField pf = new JPasswordField();
			pf.setBounds(300, 220, 150,30);	// x,y,width,height
		
		add(tf);
		add(pf);
	}
	
	private void initTypeA() {
		setTitle("BorderLayout");
		setLayout(new BorderLayout());
		JLabel lb = new JLabel("Graphic User Interface");
		add(lb, "North");	// BorderLayout.NORTH
		JTextField tf = new JTextField();
		add(tf, BorderLayout.SOUTH);
		JToggleButton bt = new JToggleButton("READY");
		add(bt, BorderLayout.CENTER);
		setSize(400, 300);
	}
}
