import java.awt.*;
import javax.swing.*;

/*
 * Source01 에서는 main이 실행되는 과정에서 
 *  직접 Base 객체부터 생성해서, Component 배치를 해보았는데,
 *  
 *  만약, 같은 형태로 설계된 jDialog가 두개를 띄워서 프로그램을 돌린다고 가정하면,
 *  도 일일이 설계를 해야되는 번거로움이 있다.
 *  
 *  GUI 프로그램을 할때는, 보통 상속(extends) 을 이용해서 설계를 한다. *  
 */

class AlphaFrame extends JFrame {
	//핵심
	AlphaFrame() { //생성자에 미리 설정
		LayoutManager m = new GridLayout(3,4); //격자모양 만들때 사용하는 레이아웃
		setLayout(m);
		
		for (int i = 1; i <= 12; i++) {
			JToggleButton bt =new JToggleButton(String.valueOf(i)); // JToggleButton on/off상태저장 버튼
			add(bt);
		}
		setSize(240,320);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}

public class Source02_GraphicUI {
	public static void main(String[] args) {
		JFrame f1 = new AlphaFrame();
		f1.setVisible(true);
		JFrame f2 = new AlphaFrame();
		f2.setVisible(true);
		System.out.println("main... before terminate"); //메인은 종료되나, 창은 계속 진행되어있음, 쓰레드관련
	}
}
