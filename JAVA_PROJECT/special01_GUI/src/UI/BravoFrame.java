package UI;
/*
 * 
 */
import java.awt.*;
import javax.swing.*;
public class BravoFrame extends JFrame {
	public BravoFrame() {
		// 적용시킬수 있는 레이아웃은 크게 4가지 정도를 많이 사용
		/*
		 * 1. GridLayout
		 *  - 격자모양(바둑판)으로 만들고자 할때 사용하는 레이아웃
		 * 	- GridLayout 설정시엔 JFrame의 뷰영역을 설정한 행,열로 분할
		 *  - Component 들이 동일크기로 차례대로 한줄씩 -> 그 다음줄
		 *  
		 * 2. BorderLayout
		 *  - 화면을 동,서,남,북 + Center 영역으로 분할해서 컴포넌트를 방향잡아서 배치
		 * 
		 * 3. AbsoluteLayout (null -> 수동설정)
		 * 	- 화면을 좌표로 설정해서 원하는 곳에 원하는 크기로 컴포넌트를 배치하고자 할때
		 *  - setLayout(null);
		 *  
		 * 4.
		 * 
		 * ==>레이아웃 혼합을 위해서는 penal (JPenal)을 설정하고 추가하는 방식으로 사용한다.
		 * ==> 패널별로 레이아웃을 지정하고 그것을 추가하는 방법 
		 */
		//initTypeA();
		initTypeB();		
	}
	private void initTypeB() {
		setTitle("AbsoluteLayout");
		setLayout(null);
		setSize(500, 300);
		
		JTextField tf = new JTextField();
			tf.setSize(100,30);
			tf.setLocation(300, 180); // JFrame기준
		JPasswordField pf = new JPasswordField();
			pf.setBounds(300,220,150,30); //x,y,with,height 동시설정
			
		add(tf);
		add(pf);
		
	}
	
	private void initTypeA() { //내부호출만 가능하게
		setTitle("BorderLayout");
		setLayout(new BorderLayout());
		setSize(400,300);
		
		JLabel lb = new JLabel("Graphic User Interface");
		add(lb, "North"); // BorderLayout.NORTH
		JTextField tf = new JTextField();
		add(tf, BorderLayout.SOUTH);
		JToggleButton bt = new JToggleButton("READY");
		add(bt, BorderLayout.CENTER);
		
		
	}
}
