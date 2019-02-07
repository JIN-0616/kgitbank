import java.awt.*;
import javax.swing.*;

/*
 * Source01 에서는 main이 실행되는 과정에서 
 * 직접 Base 객체부터 생성해서, Component 배치를 해보았는데,
 * 
 *  만약, 같은 형태로 설계된 JDialog 를 두개를 띄워서 프로그램을 돌린다고 가정하면,
 *  또 일일이 설계를 해야되는 번거로움이 있다.
 * 
 *  GUI 프로그램을 할때는, 보통 extends 을 이용해서 설계를 한다.
 */

class AlphaFrame extends JFrame {
	AlphaFrame() {
		LayoutManager m = new GridLayout(3, 4);	// 격자모양 만들때 사용하는 레이아웃
		setLayout(m);
		for(int i=1; i<=12; i++) {
			JToggleButton bt = new JToggleButton(String.valueOf(i));
			add(bt);
		}
		setSize(240,320);
	}
}


public class Source02_GraphicUI {
	public static void main(String[] args) {
		JFrame f1 = new AlphaFrame();
		f1.setVisible(true);
		JFrame f2 = new AlphaFrame();
		f2.setVisible(true);
		System.out.println("main ... before terminate");
	}
}
